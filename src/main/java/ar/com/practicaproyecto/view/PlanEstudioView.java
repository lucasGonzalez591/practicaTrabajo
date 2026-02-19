package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.MateriaController;
import ar.com.practicaproyecto.controller.PlanEstudioController;
import ar.com.practicaproyecto.model.Materia;
import ar.com.practicaproyecto.model.PlanEstudio;

import java.util.List;
import java.util.Scanner;

public class PlanEstudioView {
    private final PlanEstudioController planEstudioController;
    private final MateriaController materiaController;
    Scanner scanner;

    public PlanEstudioView(PlanEstudioController planEstudioController,
                           MateriaController materiaController,Scanner scanner){

        this.planEstudioController = planEstudioController;
        this.materiaController = materiaController;
        this.scanner = scanner;
    }

    public void iniciar(){
        boolean gestionando = true;
        while (gestionando){
            mostrarMenu();
            int opcion = leerEntero();
            switch (opcion){
                case 1 -> listarPlanes();
                case 2 -> busarPlan();
                case 3 -> crearPlan();
                case 4 -> actualizarPLan();
                case 5 -> eliminarPlan();
                case 6 -> gestionando = false;
                default -> System.out.println("ingrese una opcion valida");
            }
        }
    }


    private void mostrarMenu(){
        System.out.println("\n----GESTION DE PLAN DE ESTUDIO");
        System.out.println("1.Listar planes");
        System.out.println("2.Buscar plan por nombre");
        System.out.println("3.Registrar nuevo plan");
        System.out.println("4.Actualizar plan");
        System.out.println("5.Eliminar plan");
        System.out.println("6.Volver atrás");
    }

    //METODOS UTILITARIOS
    private int leerEntero(){
        while(!scanner.hasNext()){
            System.out.println("Debe ingresar un numero");
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    private boolean confirmarAccion(String mensaje){
        int opcion;
        do {
            System.out.println(mensaje);
            System.out.println("1.Si");
            System.out.println("2.No");
            opcion = leerEntero();
        }while (opcion < 1 || opcion > 2);
        return opcion == 1;
    }

    private void mostrarPlan(PlanEstudio planEstudio){
        String materias = (planEstudio.getMaterias() != null && !planEstudio.getMaterias().isEmpty())
                ? planEstudio.getMaterias().stream()
                .map(Materia:: getNombre)
                .reduce((a,b) -> a + ", " + b)
                .orElse("No posee")
                : "No posee";
        System.out.println(
                "NOMBRE : " + planEstudio.getNombre() +
                        "| TITULO : " + planEstudio.getTitulo() +
                        "|MATERIAS :" + materias +
                        "| ESTADO : " + (planEstudio.isActivo() ? "ACTIVO" : "INACTIVO")
        );
    }

    private void mostrarMateria(Materia m){
        System.out.println(
                "CODIGO: " + m.getCodigoMateria() +
                        "|MATERIA : " + m.getNombre() +
                        "| AÑO : " + m.getAnio()
        );
    }

    //FUNCIONALIDADES

    private void listarPlanes(){
        System.out.println("--------Listado de planes-------");
        List<PlanEstudio> planes = planEstudioController.findAll();
        if(planes.isEmpty()){
            System.out.println("No hay planes registrados");
            return;
        }
        planes.forEach(this::mostrarPlan);
    }

    private void busarPlan(){
        System.out.println("-------Buscar plan-------");
        System.out.println("Ingrese el nombre del plan: ");
        String nombre = scanner.nextLine();

        PlanEstudio plan = planEstudioController.findByName(nombre);
        if(plan == null){
            System.out.println("Plan no encontrado");
        }else{
            mostrarPlan(plan);
        }
    }

    private void crearPlan(){
        System.out.println("-------Registrar plan--------");
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        if(planEstudioController.findByName(nombre) != null){
            System.out.println("Ya existe un plan de estudio registrado con ese nombre");
            return;
        }
        System.out.println("Titulo:");
        String titulo = scanner.nextLine();

        System.out.println("Duracion");
        String duracion  = scanner.nextLine();

        System.out.println("Año: ");
        String anio  = scanner.nextLine();

        PlanEstudio nuevoPlan = new PlanEstudio(nombre,anio,duracion,titulo);

        System.out.println("------Gestion de materias del plan--------");
        gestionarMateriasDelPlan(nuevoPlan);

        System.out.println("\nVista previa");
        mostrarPlan(nuevoPlan);
        if(confirmarAccion("¿confirmar registro?")){
            planEstudioController.createPlanEstudio(nuevoPlan);
            System.out.println("plan registrado correctamente");
        }

    }

    private void actualizarPLan(){
        System.out.println("-------Actualizar plan--------------");
        System.out.println("ingrese el nombre del plan: ");
        String nombre = scanner.nextLine();

        PlanEstudio plan = planEstudioController.findByName(nombre);
        if(plan == null){
            System.out.println("plan de estudio no encontrado");
            return;
        }
        mostrarPlan(plan);
        System.out.println("Nuevos datos(dejar en banco los datos que no desee cambiar)");
        System.out.println("Titulo (" + plan.getTitulo() + ") ");
        String nuevoTitulo = scanner.nextLine();
        if(!nuevoTitulo.isEmpty()) plan.setTitulo(nuevoTitulo);

        System.out.println("Duracion (" + plan.getDuracion() + " ) " );
        String nuevaDuracion = scanner.nextLine();
        if(!nuevaDuracion.isEmpty()) plan.setTitulo(nuevaDuracion);


        System.out.println("Año (" + plan.getAnio() + " )");
        String nuevoAnio = scanner.nextLine();
        if(!nuevoAnio.isEmpty()) plan.setTitulo(nuevoAnio);

        System.out.println("GEstion de materias del plan");
        gestionarMateriasDelPlan(plan);
        if(confirmarAccion("¿Confirmar la actualizacion del plan?")){
            planEstudioController.updatePlanEstudio(plan);
            System.out.println("plan actualizado correctamente");
        }

    }

    private void eliminarPlan(){
        System.out.println("-------Eliminar plan de estudio---------");
        System.out.println("ingrese el nombre del plan");
        String nombre = scanner.nextLine();
        PlanEstudio plan  = planEstudioController.findByName(nombre);
        if(plan == null){
            System.out.println("Plan no encontrado");
            return;
        }
        mostrarPlan(plan);

        if(confirmarAccion("¿eliminar  plan de estudio?")){
            planEstudioController.deletePlanEstudio(plan);
            System.out.println("plan eliminado corrctamente");
        }

    }

    // ============================================================
    // GESTIONAR MATERIAS
    // ============================================================

    private void gestionarMateriasDelPlan(PlanEstudio plan){
        boolean gestionando = true;
        while (gestionando){
            System.out.println("Gestion de materias del plan");
            System.out.println("1.Agregar materia");
            System.out.println("2.Quitar materia");
            System.out.println("3.Ver materias del plan");
            System.out.println("4.Salir");
            String opcion = scanner.nextLine();
            switch (opcion){
                case "1" -> agregarMateria(plan);
                case "2" -> quitarMateria(plan);
                case "3" -> mostrarMateriasDelPlan(plan);
                case "4" -> gestionando = false;
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
    }


    private void agregarMateria(PlanEstudio planEstudio){
        List<Materia> disponibles = materiaController.findAll();
        if(disponibles.isEmpty()){
            System.out.println("No hay materias registradas");
            return;
        }
        System.out.println("Materias disponibles: ");
        disponibles.forEach(this::mostrarMateria);
        System.out.println("\nCodigo de la materia a agregar");
        String codigo = scanner.nextLine();
        Materia materia = materiaController.findByCode(codigo);
        if(materia != null){
            if(planEstudio.getMaterias().contains(materia)){
                System.out.println("La materia ya esta agregada al plan");
            }else {
                planEstudio.getMaterias().add(materia);
                System.out.println("materia agregada correctamente");
            }
        }else{
            System.out.println("materia no encontrada");
        }
    }

    private void quitarMateria(PlanEstudio planEstudio){
        if(planEstudio.getMaterias().isEmpty()){
            System.out.println("El plan no tiene materias");
            return;
        }
        System.out.println("Materias del plan: ");
        planEstudio.getMaterias().forEach(this::mostrarMateria);
        System.out.println("Ingrese el codigo de la materia a quitar");
        String codigo = scanner.nextLine();
        Materia materia = materiaController.findByCode(codigo);

        if(materia != null && planEstudio.getMaterias().remove(materia)){
            System.out.println("materia removida");
        }else {
            System.out.println("materia no encontrada en el plan");
        }

    }

    private void mostrarMateriasDelPlan(PlanEstudio planEstudio){
        System.out.println("Materia del plan:");
        if(planEstudio.getMaterias().isEmpty()){
            System.out.println("No tiene materias cargadas");
        }else {
            planEstudio.getMaterias().forEach(this::mostrarMateria);
        }
    }


}


/*





*/
