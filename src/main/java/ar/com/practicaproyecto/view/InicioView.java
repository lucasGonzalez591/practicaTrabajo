package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.AlumnoController;
import ar.com.practicaproyecto.controller.CuatrimestreController;
import ar.com.practicaproyecto.controller.ProfesorController;
import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.Scanner;

public class InicioView {
    private final Scanner scanner = new Scanner(System.in);

    // --- INSTANCIACIÓN DE CONTROLADORES Y VISTAS (IGUAL QUE ANTES) ---
    // Entidades básicas
    AlumnoController alumnoController = new AlumnoController();
    ProfesorController profesorController = new ProfesorController();
    CuatrimestreController cuatrimestreController = new CuatrimestreController();

    //vistas
    AlumnoView alumnoView = new AlumnoView(alumnoController,scanner);
    ProfesorView profesorView = new ProfesorView(profesorController,scanner);
    CuatrimestreView cuatrimestreView = new CuatrimestreView(cuatrimestreController,scanner);



    //METODO PRINCIPAL
    public void iniciar(){
        boolean continuar = true;
        while (continuar){
            mostrarMenuPrincipal();
            if (scanner.hasNext()){
                int opcion = scanner.nextInt();
                switch (opcion){
                    case 1 -> menuPersonas();
                    case 2 -> menuAcademico();
                    case 3 -> menuCursada();
                    case 4 -> menuConfiguracion();
                    case 5 -> continuar = false;
                    default -> System.out.println("Ingrese una opcion valida");
                }
            }else{
                System.out.println("Debe ingresar un nunero: ");
                scanner.nextLine();
            }
        }
    }




    private void mostrarMenuPrincipal(){
        System.out.println("\n-----SISTEMA DE GESTIÓN--------");
        System.out.println("1.Persona (alumno,profesores)");
        System.out.println("2.Estructura academica(carreras,planes,materias");
        System.out.println("3.Cursada e inscripciones(comisiones,inscripcion a carrera)");
        System.out.println("4.configuracion (cuatrimestres,horarios)");
        System.out.println("5.Salir");
        System.out.print("seleccione una categoria: ");
    }

    //personas
    private void menuPersonas(){
        boolean volver = false;
        while (!volver){
            System.out.println("\n----GESTIÓN DE PERSONAS-----");
            System.out.println("1.Alumnos");
            System.out.println("2.Profesores");
            System.out.println("3.Volver al menu principal");
            System.out.print("seleccione: ");
            if(scanner.hasNext()){
                int op = scanner.nextInt();
                switch (op){
                    case 1 -> this.alumnoView.iniciar();
                    case 2 -> this.profesorView.inciar();
                    case 3 -> volver = true;
                    default -> System.out.println("Ingrese una opcion valida");
                }
            }else{
                scanner.nextLine();
            }
        }
    }


    //2.ACADEMICO
    private void menuAcademico(){
        boolean volver = false;
        while(!volver){
            System.out.println("\n------Estructura academica------");
            System.out.println("1.Carreras");
            System.out.println("2.Planes de estudio");
            System.out.println("3.MAterias");
            System.out.println("4.Volver al menu principal");
            System.out.print("selecione: ");
            if(scanner.hasNext()){
                int op = scanner.nextInt();
                switch (op){
                    case 4 -> volver = true;
                    default -> System.out.println("Ingrese una opcion valida");
                }
            }else{
                scanner.nextLine();
            }
        }
    }

    //3 cursada e inscripciones
    private void menuCursada(){
        boolean volver = false;
        while (!volver){
            System.out.println("\n-----GESTION DE CURSADA-------");
            System.out.println("1.Comisiones(cursado actual)");
            System.out.println("2.Inscripciones a carreras");
            System.out.println("3.Volver al menu principal");
            System.out.print("Seleccione: ");
            if(scanner.hasNext()){
                int op = scanner.nextInt();
                switch (op){
                    case 3 -> volver  = true;
                    default -> System.out.println("ingrese una opcion valida");
                }
            }else{
                scanner.nextLine();
            }
        }
    }

    //4 configuracion
    private void menuConfiguracion(){
        boolean volver = false;
        while (!volver){
            System.out.println("\n------CONFIGURACION Y CALENDARIO------");
            System.out.println("1.Cuatrimestres");
            System.out.println("2.Horarios");
            System.out.println("3.Modulos horarios");
            System.out.println("4.Volver al menu principal");
            System.out.print("seleccione: ");
            if(scanner.hasNext()){
                int op = scanner.nextInt();
                switch (op){
                    case 1 -> cuatrimestreView.iniciar();
                    case 4 -> volver = true;
                    default -> System.out.println("ingrese una opcion valida");
                }
            }else{
                scanner.nextLine();
            }
            }
        }
    }














