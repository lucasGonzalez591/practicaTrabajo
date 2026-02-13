package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.ProfesorController;
import ar.com.practicaproyecto.model.Profesor;

import java.util.List;
import java.util.Scanner;

public class ProfesorView {
    private final ProfesorController profesorController;
    private final Scanner scanner;

    public ProfesorView(ProfesorController profesorController,Scanner scanner){
        this.profesorController = profesorController;
        this.scanner = scanner;
    }

    public void inciar(){
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
                case 1 -> listarProfesores();
                case 2 -> buscarProfesor();
                case 3 -> crearProfesor();
                case 4 -> actualizarProfesor();
                case 5 -> eliminarProfesor();
                case 6 -> continuar = false;
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
    }


    private void mostrarMenu(){
        System.out.println("\n-------GESTION DE PROFESORES---------");
        System.out.println("1.Listar profesores");
        System.out.println("2.Buscar profesor por DNI");
        System.out.println("3.Registrar profesor");
        System.out.println("4.Actualizar datos de un profesor");
        System.out.println("5.Dar de baja un profesor");
        System.out.println("6.Volver atras");
        System.out.print("seleccione una opcion: ");
    }

    //metodos auxiliares

    private void mostrarProfesor(Profesor profesor){
        System.out.println(
                "DNI: " + profesor.getDni() +
                        "| NOMBRE: " + profesor.getNombre() +
                        "| APELLIDO : " + profesor.getApellido() +
                        "| TELEFONO : " + profesor.getTelefono() +
                        "| EMAIL : " + profesor.getEmail() +
                        "| ESTADO : " + (profesor.isActivo() ? "ACTIVO" : "INACTIVO")
        );
    }

    private void pausa(){
        scanner.nextLine();
    }

    private int confirmarAccion(){
        int opcion = 0;
        while (opcion != 1 && opcion != 2){
            System.out.println("\nConfirmar :");
            System.out.println("1.Si");
            System.out.println("2.No");
            if(scanner.hasNext()){
                opcion = scanner.nextInt();
            }else{
                scanner.nextLine();
            }
        }
        pausa();
        return opcion;
    }

    //funcionalidades
    private void listarProfesores(){
        List<Profesor> profesores = profesorController.findAll();
        if(profesores.isEmpty()){
            System.out.println("No se encuentran profesores registrados");
            return;
        }
        profesores.forEach(this::mostrarProfesor);
    }

    private void buscarProfesor(){
        System.out.println("----Buscar profesor------");
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();
        Profesor profesor = profesorController.findByDni(dni);
        if(profesor == null){
            System.out.println("profesor no encontrado");
            return;
        }else{
            mostrarProfesor(profesor);
        }
    }

    public void crearProfesor(){
        System.out.println("----Registrar profesor-----");
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        if(profesorController.findByDni(dni) != null){
            System.out.println("El DNI ya esta registrado");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Telefono : ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Profesor profesor = new Profesor(dni,nombre,apellido,telefono,email);
        System.out.println("\nVista previa ");
        mostrarProfesor(profesor);
        if(confirmarAccion() == 1){
            profesorController.createProfesor(profesor);
            System.out.println("Profesor registrado correctamente");
        }
    }

    private void actualizarProfesor(){
        System.out.println("------Actualizar profesor----------");
        System.out.println("ingrese el DNI del profesor");
        String dni = scanner.nextLine();
        Profesor profesor = profesorController.findByDni(dni);
        if(profesor == null){
            System.out.println("profesor no encontrado");
            return;
        }
        System.out.println("profesor encontrado");
        mostrarProfesor(profesor);
        System.out.println("\nNuevos datos (dejar en blanco para no cambiar)");
        System.out.print("Nuevo nombre (" + profesor.getNombre() + " ): ");
        String nombre = scanner.nextLine();
        if(!nombre.isBlank()) profesor.setNombre(nombre);

        System.out.print("Nuevo apellido ( " + profesor.getApellido() + ") : ");
        String apellido = scanner.nextLine();
        if(!apellido.isBlank()) profesor.setApellido(apellido);

        System.out.print("Nuevo telefono ( " + profesor.getTelefono() + " ) : ");
        String telefono = scanner.nextLine();
        if(!telefono.isBlank()) profesor.setTelefono(telefono);

        System.out.print("nuevo email ( " + profesor.getEmail() + ") : ");
        String email = scanner.nextLine();
        if(!email.isBlank()) profesor.setEmail(email);

        System.out.print("\nVista previa");
        mostrarProfesor(profesor);
        if(confirmarAccion() == 1){
            profesorController.updateProfesor(profesor);
            System.out.println("Datos actuaizados correctamente");
        }
    }

    private void eliminarProfesor(){
        System.out.println("----Eliminar profesor-----");
        System.out.println("Ingrese el DNI del profesor");
        String dni = scanner.nextLine();
        Profesor profesor = profesorController.findByDni(dni);
        if(profesor == null){
            System.out.println("profesor no encontrado");
            return;
        }
        System.out.println("profesor encontrado");
        mostrarProfesor(profesor);
        if(confirmarAccion() == 1){
            profesorController.deleteProfesor(profesor);
            System.out.println("profesor eliminado correctamente");
        }
    }


}

/*


}*/
