package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.AlumnoController;
import ar.com.practicaproyecto.model.Alumno;

import java.util.List;
import java.util.Scanner;

public class AlumnoView {
    private final AlumnoController alumnoController;
    Scanner scanner;

    public AlumnoView(AlumnoController alumnoController, Scanner scanner){
        this.alumnoController = alumnoController;
        this.scanner = scanner;
    }

    public void iniciar(){
        boolean continuar = true;
        while (continuar){
            mostrarMenu();
            if(!scanner.hasNext()){
                System.out.println("Debe ingresar un numero");
                scanner.next();
                continue;
            }
            int opcion = scanner.nextInt();
            pausa();
            switch (opcion){
                case 1 -> listarAlumnos();
                case 2 -> buscarAlumno();
                case 3 -> crearAlumno();
                case 4 -> actualizarAlumno();
                case 5 -> eliminarAlumno();
                case 6 -> continuar = false;
                default -> System.out.println("ingrese una opcion valida");
            }
        }

    }

    //metodos auxiliares

    private void mostrarMenu(){
        System.out.println("---\nGESTION DE ALUNNOS");
        System.out.println("1.Listar alumnos");
        System.out.println("2.Buscar alumno por DNI");
        System.out.println("3.Registrar alumno");
        System.out.println("4.Actualizar datos de un alumno");
        System.out.println("5.Dar de baja un alumno");
        System.out.println("6.Volver atras");
        System.out.println("seleccione una opcion");
    }

    private void mostrarAlumno(Alumno alumno){
        System.out.println(
                "DNI : " + alumno.getDni() +
                        " | NOMBRE: " + alumno.getNombre() +
                        "| APELLIDO:" + alumno.getApellido() +
                        "| EMAIL : " + alumno.getEmail() +
                        "| TELEFONO : " + alumno.getTelefono() +
                        "| ESTADO : " + (alumno.isActivo() ? "Activo" : "Inactivo")
        );
    }

    private int confirmarAccion(){
        int opcion = 0;
        while(opcion != 1 && opcion != 2){
            System.out.println("\nConfirmar");
            System.out.println("1.si");
            System.out.println("2.No");
            System.out.print("opcion: ");
            if(scanner.hasNext()){
                opcion = scanner.nextInt();
            }else {
                scanner.next();
            }
        }
        pausa();
        return opcion;
    }

    private void pausa(){
        scanner.nextLine();
    }

    //funcionalidades

    private void listarAlumnos(){
        System.out.println("------Listado de alumnos------");
        List<Alumno> alumnos = alumnoController.findAll();
        if(alumnos.isEmpty()){
            System.out.println("No hay alumnos registrados");
            return;
        }
        alumnos.forEach(this:: mostrarAlumno);
    }


    private void buscarAlumno(){
        System.out.println("-------Buscar Alumno--------");
        System.out.println("Ingres el dni: ");
        String dni = scanner.nextLine();

        Alumno alumno = alumnoController.findByDni(dni);
        if(alumno == null){
            System.out.println("Alumno no encontrado");
        }else{
            mostrarAlumno(alumno);
        }
    }

    private void crearAlumno(){
        System.out.println("-----Registrar alumno--------");
        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        if(alumnoController.findByDni(dni) != null){
            System.out.println("El DNI ya esta registrado");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido");
        String apellido = scanner.nextLine();

        System.out.print("Telefono :");
        String telefono = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Alumno alumno = new Alumno(dni,nombre,apellido,telefono,email);

        System.out.println("\nVista previa");
        mostrarAlumno(alumno);

        if(confirmarAccion() == 1){
            alumnoController.createAlumno(alumno);
            System.out.println("Alumno registrado!!!");
        }
    }

    private void actualizarAlumno(){
        System.out.println("-----Actualizar alumno----------");

        System.out.println("Ingrese el dni");
        String dni = scanner.nextLine();
        Alumno alumno = alumnoController.findByDni(dni);
        if(alumno == null){
            System.out.println("alumno no encontrado");
            return;
        }
        System.out.println("Alumno encontrado");
        mostrarAlumno(alumno);

        System.out.println("\nNUEVOS DATOS(dejar en blanco para no cambiar)");

        System.out.println("Nombre ( " + alumno.getNombre() + ") :" );
        String nombre = scanner.nextLine();
        if(!nombre.isBlank()) alumno.setNombre(nombre);

        System.out.print("Nuevo apellido (" + alumno.getApellido() + "): ");
        String apellido = scanner.nextLine();
        if (!apellido.isBlank()) alumno.setApellido(apellido);

        System.out.print("Nuevo teléfono (" + alumno.getTelefono() + "): ");
        String telefono = scanner.nextLine();
        if (!telefono.isBlank()) alumno.setTelefono(telefono);

        System.out.print("Nuevo email (" + alumno.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isBlank()) alumno.setEmail(email);

        System.out.println("\nVista preiva");
        mostrarAlumno(alumno);

        if(confirmarAccion() == 1){
            alumnoController.updateAlumno(alumno);
            System.out.println("Alumno actualizado correctamente");
        }
    }

    private void eliminarAlumno(){
        System.out.println("-----Eliminar alumno-----------");
        System.out.print("Ingrese el dni: ");
        String dni = scanner.nextLine();
        Alumno alumno = alumnoController.findByDni(dni);
        if(alumno == null){
            System.out.println("Alumno no encontrado");
            return;
        }
        System.out.println("Alumno encontrado");
        mostrarAlumno(alumno);
        if(confirmarAccion() == 1){
            alumnoController.deleteAlumno(alumno);
            System.out.println("Alumno eliminado correctamente");
        }

    }






}






