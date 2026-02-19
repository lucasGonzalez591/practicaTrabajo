package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.MateriaController;
import ar.com.practicaproyecto.model.Materia;

import java.util.List;
import java.util.Scanner;

public class MateriaView {
    private final Scanner scanner;
    private final MateriaController materiaController;

    public MateriaView(MateriaController materiaController, Scanner scanner){
        this.materiaController = materiaController;
        this.scanner = scanner;
    }

    public void iniciar(){
        boolean gestionando = true;
        while (gestionando){
            mostrarMenu();
           int opcion = leerEntero();
           switch (opcion){
               case 1 -> listarMaterias();
               case 2 -> buscarMateria();
               case 3 -> crearMateria();
               case 4 -> actualizarMateria();
               case 5 -> eliminarMateria();
               case 6 -> gestionando = false;
               default -> System.out.println("Ingrese una opcion valida");
           }
        }
    }


    private void mostrarMenu(){
        System.out.println("------GESTION DE MATERIAS-----");
        System.out.println("1.Lista materias");
        System.out.println("2.Buscar materia por codigo");
        System.out.println("3.Registrar materias");
        System.out.println("4.Actualizar materia");
        System.out.println("5.Eliminar materia");
        System.out.println("6.Volver atras");
    }

    //metodos auxiliares
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
            opcion = scanner.nextInt();
        }while (opcion < 1 || opcion > 2);
        return opcion == 1;
    }

    private String obtenerNombresCorrelativas(Materia m) {
        if (m.getCorrelativas() == null || m.getCorrelativas().isEmpty()) {
            return "NO POSEE";
        }

        return m.getCorrelativas().stream()
                .filter(Materia::isActivo) // Solo las que están activas
                .map(Materia::getNombre)
                .reduce((a, b) -> a + ", " + b)
                .orElse("NO POSEE");
    }





    private void mostrarMateria(Materia materia){
        if(materia.isActivo()) {
            System.out.println(
                    "CODIGO: " + materia.getCodigoMateria() +
                            "| MATERIA: " + materia.getNombre() +
                            "AÑO : " + materia.getAnio() +
                            "| CORRELATIVAS :" + obtenerNombresCorrelativas(materia) +
                            "| ESTADO : " + (materia.isActivo() ? "ACTIVO" : "INACTIVO")
            );
        }
    }

    //funcionalidades
    private void listarMaterias(){
        System.out.println("----Listado de materias------");
        List<Materia> materias = materiaController.findAll();
        if(materias.isEmpty()){
            System.out.println("No hay materias registradas");
            return;
        }
        materias.forEach(this::mostrarMateria);
    }

    private void buscarMateria(){
        System.out.println("Ingrese el codigo de la materia");
        String codigo = scanner.nextLine();
        Materia materia = materiaController.findByCode(codigo);
        if(materia == null || !materia.isActivo()){
            System.out.println("Materia no encontrada");
            return;
        }
        mostrarMateria(materia);
    }

    public void crearMateria(){
        System.out.println("---------Registrar materia--------");
        System.out.println("Codigo: ");
        String codigo = scanner.nextLine();
        if(materiaController.findByCode(codigo) != null){
            System.out.println("ya existe una materia registrada con ese nombre");
            return;
        }
        System.out.println("nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Año: ");
        String anio = scanner.nextLine();

        Materia materia = new Materia(codigo,nombre,anio);
        System.out.println("-----Gestion de correlativas--------");
        gestionarCorrelativas(materia);

        System.out.println("\nVista previa");
        mostrarMateria(materia);

        if(confirmarAccion("¿confirmar el registro de la carrera?")){
            materiaController.createMateria(materia);
            System.out.println("Materia registrada correctamente");
        }
    }

    private void actualizarMateria(){
        System.out.println("-------Actualizar materia------------");
        System.out.println("Ingrese el codigo de la materia");
        String codigo = scanner.nextLine();
        Materia materia = materiaController.findByCode(codigo);
        if(materia == null){
            System.out.println("materia no encontrada");
            return;
        }
        mostrarMateria(materia);

        System.out.println(" nuevos datos (presiones enter si no desea cabiar)");
        System.out.println("Nombre (" + materia.getNombre() + " ) : ");
        String nombre = scanner.nextLine();
        if(!nombre.isEmpty()) materia.setNombre(nombre);

        System.out.println("Año ( " + materia.getAnio() + ") " );
        String anio = scanner.nextLine();
        if(!anio.isEmpty()) materia.setAnio(anio);

        System.out.println("----Gestion de correlativas------");
        gestionarCorrelativas(materia);

        System.out.println("\nVista previa");
        mostrarMateria(materia);

        if(confirmarAccion("¿confirmar actualizacion de la materia?")){
            materiaController.updateMateria(materia);
            System.out.println("materia actualizada correctamente");
        }

    }
    
    private void eliminarMateria(){
        System.out.println("----------Eliminar materia----");
        System.out.println("ingrese el codigo de la materia a eliminar");
        String codigo = scanner.nextLine();
        Materia materia = materiaController.findByCode(codigo);
        if(materia == null){
            System.out.println("materia no encontrada");
            return;
        }
        mostrarMateria(materia);
        if(confirmarAccion("¿Eliminar la materia?")){
            materiaController.deleteMateria(materia);
            System.out.println("materia eliminada correctamente");
        }
    }

    //AQUiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii

    //GESTION DE CORRELATIVAS

    private void gestionarCorrelativas(Materia materia){
        boolean gestionando = true;
        while(gestionando){
            System.out.println("\nGestionar correlativas");
            System.out.println("1.Agregar correlativa");
            System.out.println("2.Eliminar correlativa");
            System.out.println("3.ver correlativas");
            System.out.println("4.Terminar gestion de correlativas");
            String opcion = scanner.nextLine();
            switch(opcion){
                case "1" -> agregarCorrelativa(materia);
                case "2" -> quitarCorrelativa(materia);
                case "3" -> mostrarCorrelativas(materia);
                case "4" -> gestionando = false;
                default -> System.out.println("Debe ingresar una correlativa");
            }
        }
    }

    // en este metodo hay que agrgar el filtro
    private void agregarCorrelativa(Materia materia){
        List<Materia> disponibles = materiaController.findAll();
        if(disponibles.isEmpty()){
            System.out.println("No hay materias disponibles");
            return;
        }
        System.out.println("\nMaterias disponibles ");
        disponibles.forEach(m -> System.out.println("CODIGO:" + m.getCodigoMateria() + "MATERIA:" + m.getNombre()));
        System.out.println("\nCodigo de la materia a agregar");
        String codigo = scanner.nextLine();
        Materia correlativa = materiaController.findByCode(codigo);
        if(materia == null){
            System.out.println("materia no encontrada");
            return;
        }
        if(materia == correlativa){
            System.out.println("Esta materia no se puede agregar como correlativa");
            return;
        }
        if(materia.getCorrelativas().contains(correlativa)){
            System.out.println("la materia a agregar ya esta como correlativa");
            return;
        }
        materia.getCorrelativas().add(correlativa);
        System.out.println("correlativa agregada correctamente");
    }

    private void quitarCorrelativa(Materia materia){
        if(materia.getCorrelativas().isEmpty()){
            System.out.println("Esta materia no tiene correlativas");
            return;
        }
        mostrarCorrelativas(materia);
        System.out.println("Ingrese el codigo de la correlativa a quitar: ");
        String codigo = scanner.nextLine();
        Materia correlativa = materiaController.findByCode(codigo);
        if(correlativa == null){
            System.out.println("correlativa no encontrada");
            return;
        }
        if(materia.getCorrelativas().remove(correlativa)){
            System.out.println("correlativa eliminada correctamente");
        }else{
            System.out.println("la materia a eliminar no s encuentra como correlativa");
        }
    }

    private void mostrarCorrelativas(Materia materiaActual) {
        System.out.println("\nCorrelativas:");

        boolean encontroActiva = false;

        for (Materia m : materiaActual.getCorrelativas()) {
            if (m.isActivo()) { // <--- FILTRO MANUAL
                System.out.println("MATERIA: " + m.getNombre());
                encontroActiva = true;
            }
        }

        if (!encontroActiva) {
            System.out.println("No posee correlativas activas.");
        }
    }

}

/*



*/
