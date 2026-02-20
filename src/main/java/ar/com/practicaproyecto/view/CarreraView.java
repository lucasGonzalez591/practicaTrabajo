package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.CarreraController;
import ar.com.practicaproyecto.controller.PlanEstudioController;
import ar.com.practicaproyecto.model.Carrera;
import ar.com.practicaproyecto.model.PlanEstudio;
import ar.com.practicaproyecto.model.Turno;

import java.util.List;
import java.util.Scanner;

public class CarreraView {
    private final CarreraController carreraController;
    private final PlanEstudioController planEstudioController;
    Scanner scanner;

    public CarreraView(CarreraController carreraController,PlanEstudioController planEstudioController,
                       Scanner scanner){
        this.carreraController = carreraController;
        this.planEstudioController = planEstudioController;
        this.scanner = scanner;
    }

    public void iniciar(){
        boolean continuar = true;
        while (continuar){
            mostrarMenu();
            if(!scanner.hasNext()){
                System.out.println("debe ingresar un numero");
                scanner.nextLine();
                continue;
            }
            int opcion = scanner.nextInt();
            pausa();
            switch (opcion){
                case 1 -> listarCarreras();
                case 2 -> buscarCarrera();
                case 3 -> crearCarrera();
                case 4 -> actualizarCarrera();
                case 5 -> eliminarCarrera();
                case 6 -> continuar = false;
                default -> System.out.println("ingrese una opcion valida");
            }
        }
    }


    // ----------------------------------------------------
    // MÉTODOS AUXILIARES
    // ----------------------------------------------------

    private void mostrarMenu(){
        System.out.println("----GESTION DE CARRERAS-------");
        System.out.println("1.Listar carreras");
        System.out.println("2.Buscar carrera por nombre");
        System.out.println("3.Registrar carrera");
        System.out.println("4.Actualizar carrera");
        System.out.println("5.Eliminar carrera");
        System.out.println("6.Salir");
        System.out.println("Seleccione unaa opcion: ");
    }

    private void pausa(){scanner.nextLine();}

    private int confirmarAccion(){
        int opcion = 0;
        while(opcion != 1 && opcion != 2){
            System.out.println("\nConfirmar");
            System.out.println("1.Si");
            System.out.println("2.No");
            if(scanner.hasNext()) {
                opcion = scanner.nextInt();
            }else {
                scanner.next();
            }
        }
        pausa();
        return opcion;
    }

    private void mostrarCarrera(Carrera carrera){
        String  planInfo;
        if(carrera.getPlanEstudio() != null){
            planInfo = carrera.getPlanEstudio().getNombre();
        }else{
            planInfo = "No posee";
        }
        System.out.println(
                "NOMBRE: " + carrera.getNombre() +
                        "| TURNO: " + carrera.getTurno() +
                        "| PLAN DE ESTUDIO: " + planInfo +
                        "| ESTADO: " + (carrera.isActivo() ? "ACTIVO" : "INACTIVO")
        );
    }

    private void mostrarPlan(PlanEstudio planEstudio){
        String materiasInfo;
        if(planEstudio.getMaterias() != null && !planEstudio.getMaterias().isEmpty()){
            materiasInfo = planEstudio.getMaterias()
                    .stream()
                    .map(m -> m.getNombre())
                    .reduce((a,b) -> a + ", " +b)
                    .orElse("No posee");
        }else {
            materiasInfo = "No poseee";
        }
        System.out.println(
                "NOMBRE : " + planEstudio.getNombre() +
                        "| TITULO :" + planEstudio.getTitulo() +
                        "| MATERIAS : " + materiasInfo +
                        "| ESTADO: " + (planEstudio.isActivo() ? "ACTIVO" : "INACTIVO")
        );
    }

    //----------------------------------------------------
    //FUNCIONALIDADES
    //---------------------------------------------------

    private void listarCarreras(){
        List<Carrera> carreras = carreraController.findAll();
        if(carreras.isEmpty()){
            System.out.println("No hay correras registradas");
            return;
        }
        carreras.forEach(this::mostrarCarrera);
    }

    private void buscarCarrera(){
        System.out.println("------Buscar carrera------");
        System.out.println("Ingrese el nombre de la carrera");
        String nombre = scanner.nextLine();
        Carrera carrera = carreraController.findByName(nombre);
        if(carrera == null){
            System.out.println("carrera no encontrada");
        }else{
            mostrarCarrera(carrera);
        }
    }

    private void crearCarrera(){
        System.out.println("-------Registrar carrera---------");
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        if(carreraController.findByName(nombre) != null){
            System.out.println("Ya existe una carrera registrada con el mismo nombre");
            return;
        }
        Turno turno = seleccionarTurno();
        Carrera carrera = new Carrera(nombre,turno);

        System.out.println("---Plan de estudio (opcional)----");
        gestionarPLanEstudio(carrera);
        System.out.println("\nVista previa :");
        mostrarCarrera(carrera);
        if(confirmarAccion() == 1){
            carreraController.createCarrera(carrera);
            System.out.println("carrera creada exitosamente");
        }
    }

    private void actualizarCarrera(){
        System.out.println("-----Actualizar carrera-----");
        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        Carrera carrera = carreraController.findByName(nombre);
        if(carrera == null){
            System.out.println("Carrera no encontrada");
            return;
        }
        System.out.println("carrera encontrada");
        mostrarCarrera(carrera);

        Turno nuevoTurno = seleccionarTurnoOpcional(carrera.getTurno());
        carrera.setTurno(nuevoTurno);

        System.out.println("----Gestion de plan de estudios-----");
        gestionarPLanEstudio(carrera);

        System.out.println("\nVista previa");
        mostrarCarrera(carrera);
        if(confirmarAccion() == 1){
            carreraController.updateCarrera(carrera);
            System.out.println("carrera actualizada correctamente");
        }

    }

    private void eliminarCarrera(){
        System.out.println("---------Eliminar carrera------");
        System.out.println("ingrese el nombre de la carrera");
        String nombre = scanner.nextLine();
        Carrera carrera = carreraController.findByName(nombre);
        if(carrera == null){
            System.out.println("carrera no encontrada");
            return;
        }
        System.out.println("materia encontrada");
        mostrarCarrera(carrera);
        if(confirmarAccion() == 1){
            carreraController.deleteCarrera(carrera);
            System.out.println("carrera eliminada correctamente");
        }
    }


    // ----------------------------------------------------
    // GESTIÓN DE TURNOS
    // ----------------------------------------------------
        private Turno seleccionarTurno(){
            int opcion = 0;
            while (opcion < 1  || opcion > 3){
                System.out.println("Seleccione un turno");
                System.out.println("1.Turno mañana");
                System.out.println("2.Turno tarde");
                System.out.println("3.Turno noche");
                System.out.println("opcion: ");
                if(scanner.hasNext()){
                    opcion = scanner.nextInt();
                }else {
                    scanner.nextLine();
                }
            }
            pausa();

           return switch (opcion){
                case 1 -> Turno.MANANA;
                case 2 -> Turno.TARDE;
                case 3 -> Turno.NOCHE;
               default -> Turno.MANANA;
            };
        }

        private Turno seleccionarTurnoOpcional(Turno actual){
            System.out.println("\nTurno actual " + actual);
            System.out.println("Seleccione nuevo turno(enter para mantener el actual) ");
            System.out.println("1.Mañana");
            System.out.println("2.Tarfde");
            System.out.println("3.Noche");
            System.out.println("opcion: ");
            String input = scanner.nextLine().trim();
            return switch (input){
                case "1" -> Turno.MANANA;
                case "2" -> Turno.TARDE;
                case "3" -> Turno.NOCHE;
                default -> {
                    System.out.println("opcion invalida, se mantiene el turno actual");
                    yield actual;
                }
            };
        }


    // ----------------------------------------------------
    // GESTIÓN PLAN DE ESTUDIO
    // ----------------------------------------------------

    private void gestionarPLanEstudio(Carrera carrera){
        boolean gestionando = true;
        while (gestionando){
            System.out.println("----Gestor de plan de estudio----");
            System.out.println("1.Agregar plan");
            System.out.println("2.Eliminar plan");
            System.out.println("3.Ver plan actual");
            System.out.println("4.salir de gestion de plan de estudio");
            System.out.println("ingrese una opcion: ");
            String opcion = scanner.nextLine();
            switch (opcion){
                case "1" -> agregarPlanEstudio( carrera);
                case "2" -> eliminarPlanEstudio(carrera);
                case "3" -> {
                    if(carrera.getPlanEstudio() == null){
                        System.out.println("La carrera no tiene plan de estudio");
                    }else{
                        System.out.println("Plan de estudio actual");
                        mostrarPlan(carrera.getPlanEstudio());
                    }
                }
                case "4" -> gestionando = false;
                default -> System.out.println("Ingrese una opcion valida");
            }

        }
    }

    private void agregarPlanEstudio(Carrera carrera){
        List<PlanEstudio> planes = planEstudioController.findAll();
        if(planes.isEmpty()){
            System.out.println("No hay planes disponibles");
            return;
        }
        System.out.println("\nplanes disponibles");
        planes.forEach(this::mostrarPlan);

        System.out.println("Ingrese el nombre del plan: ");
        String nombre = scanner.nextLine();
        PlanEstudio plan = planEstudioController.findByName(nombre);
        if(plan != null){
            carrera.setPlanEstudio(plan);
            System.out.println("Plan de estudio agregado a la carrera");
        }else {
            System.out.println("Plan invalido");
        }
    }

    private void eliminarPlanEstudio(Carrera carrera){
        if(carrera.getPlanEstudio() == null){
            System.out.println("La carrera no posee plan de estudio");
            return;
        }
        System.out.println("plan de estudio a eliminar:" + carrera.getPlanEstudio());

        if(confirmarAccion() == 1){
            carrera.setPlanEstudio(null);
            System.out.println("Plan eliminado correctamente");
        }
    }

}



