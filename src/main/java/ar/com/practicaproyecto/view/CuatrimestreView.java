package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.CuatrimestreController;
import ar.com.practicaproyecto.model.Cuatrimestre;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CuatrimestreView {
    private final CuatrimestreController cuatrimestreController;
    private final Scanner scanner;

    public CuatrimestreView(CuatrimestreController cuatrimestreController,Scanner scanner){
        this.cuatrimestreController = cuatrimestreController;
        this.scanner = scanner;
    }

    public void iniciar(){
        boolean continuar = true;
        while (continuar){
            mostrarMenu();
             int opcion =leerEntero();
             switch (opcion){
                 case 1 -> listarCuatrimestre();
                 case 2 -> buscarCuatrimestre();
                 case 3 -> crearCuatrimestre();
                 case 4 -> actualizarCuatrimestre();
                 case 5 -> eliminarCuatrimestre();
                 case 6 -> continuar = false;
                 default -> System.out.println("ingrese una opcion valida");
             }
        }
    }

    private void mostrarMenu(){
        System.out.println("\nGESTION DE CUATRIMESTRES");
        System.out.println("1.Listar cuatrimestres ");
        System.out.println("2.Buscar cuatrimestres por número");
        System.out.println("3.Registrar cuatrimestre");
        System.out.println("4.actualizar datos de un cuatrimestre");
        System.out.println("5.Eliminar cuatrimestre");
        System.out.println("6.volver atrás");
    }

    //metodos auxiliares
    private int leerEntero(){
        while(!scanner.hasNext()){
            scanner.nextLine();
            System.out.println("Debe ingresar un numero");
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    private boolean confirmarAccion(String mensaje){
        int opcion;
        do{
            System.out.println(mensaje);
            System.out.println("1.Si");
            System.out.println("2.No");
            opcion  = leerEntero();
        }while (opcion < 1 || opcion > 2);
        return opcion == 1;
    }

    private void mostrarCuatrimestre(Cuatrimestre c){
        System.out.println(
                "NUMERO : " + c.getNumero() +
                        "| AÑO: " + c.getAnio() +
                        "| INICIO: " + c.getInicio() +
                        "| FIN: " + c.getFin() +
                        "| ESTADO: " + (c.isActivo() ? "ACTIVO" : "INACTIVO")
        );
    }

    private void listarCuatrimestre(){
        System.out.println("----Listado de cuatrimestres------");
        List<Cuatrimestre> lista = cuatrimestreController.findAll();
        if(lista.isEmpty()){
            System.out.println("No hay cuatrimestres disponibles");
        }
        lista.forEach(this::mostrarCuatrimestre);
    }

    private void buscarCuatrimestre(){
        System.out.println("----Buscar cuatrimestre-----");
        System.out.println("Ingrese el numero del cuatrimestre");
        String numero = scanner.nextLine();
        Cuatrimestre cuatrimestre = cuatrimestreController.findByNumber(numero);
        if(cuatrimestre == null){
            System.out.println("no se ha encontrado el cuatrimestre");
            return;
        }
        mostrarCuatrimestre(cuatrimestre);
    }

    private void crearCuatrimestre(){
        System.out.println("-----------Registrar cuatrimestre---------");
        System.out.println("Numero: ");
        String numero = scanner.nextLine();
        if(cuatrimestreController.findByNumber(numero) != null){
            System.out.println("Ya existe un cuatrimestre con ese numero");
            return;
        }
        System.out.println("Año: ");
        String anio = scanner.nextLine();

        System.out.println("Fecha de inicio (YYYY-MM-DD): ");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());

        System.out.println("Fecha de fin (YYYY-MM-DD) : ");
        LocalDate fin = LocalDate.parse(scanner.nextLine());

        Cuatrimestre cuatrimestre = new Cuatrimestre(numero,inicio,fin,anio);
        System.out.println("\nVista previa ");
        mostrarCuatrimestre(cuatrimestre);
        if(confirmarAccion("¿ Confirmar registro?")){
            cuatrimestreController.createCuatrimestre(cuatrimestre);
            System.out.println("cuatrimestre registrado");
        }
    }

    private void actualizarCuatrimestre(){
        System.out.println("-----Actualizar cuatrimestre--------");
        System.out.println("Ingrese el numero del cuatrimestre: ");
        String numero = scanner.nextLine();
        Cuatrimestre cuatrimestre = cuatrimestreController.findByNumber(numero);
        if(cuatrimestre == null){
            System.out.println("No se ha encontrado el cuatrimestre");
            return;
        }
        System.out.println("cuatrimestre encontrado");
        mostrarCuatrimestre(cuatrimestre);

        System.out.println("\nNuevos datos (dejar en blanco para no cambiar)");
        System.out.println("AÑO (" + cuatrimestre.getAnio() + ") :" );
        String anio = scanner.nextLine();
        if(!anio.isEmpty()) cuatrimestre.setAnio(anio);

        System.out.println("Fecha de inicio ( " + cuatrimestre.getInicio() + " ) :");
        String  incio = scanner.nextLine();
        if(!incio.isEmpty()) cuatrimestre.setInicio(LocalDate.parse(incio));

        System.out.println("fecha de fin ( " + cuatrimestre.getFin() + " )" );
        String fin = scanner.nextLine();
        if(!fin.isEmpty()) cuatrimestre.setFin(LocalDate.parse(fin));

        System.out.println("Vista previa");
        mostrarCuatrimestre(cuatrimestre);
        if(confirmarAccion("¿confirmar actualizaciones?")){
            cuatrimestreController.updateCuatrimestre(cuatrimestre);
            System.out.println("cuatrimestre actualizado correctamente");
        }
    }

    private void eliminarCuatrimestre(){
        System.out.println("Ingrese el numero del cuatrimestre");
        String numero = scanner.nextLine();
        Cuatrimestre cuatrimestre = cuatrimestreController.findByNumber(numero);
        if(cuatrimestre == null){
            System.out.println("cuatrimestre no encontrado.");
            return;
        }
        mostrarCuatrimestre(cuatrimestre);
        if (confirmarAccion("¿Eliminar este cuatrimestre?")){
            cuatrimestreController.deleteCuatrimestre(cuatrimestre);
            System.out.println("cuatrimestre eliminado correctamente");
        }

    }
}

