package ar.com.practicaproyecto.view;

import ar.com.practicaproyecto.controller.ModuloController;
import ar.com.practicaproyecto.model.Modulo;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class ModuloView {
    private final ModuloController moduloController;
    private final Scanner scanner;

    public ModuloView(ModuloController moduloController,Scanner scanner){
        this.moduloController = moduloController;
        this.scanner = scanner;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero();

            switch (opcion) {
                case 1 -> listarModulos();
                case 2 -> buscarModulo();
                case 3 -> crearModulo();
                case 4 -> actualizarModulo();
                case 5 -> eliminarModulo();
                case 6 -> continuar = false;
                default -> System.out.println("Ingrese una opción válida.");
            }
        }
    }
    private void mostrarMenu() {
        System.out.println("\nGESTIÓN DE MÓDULOS");
        System.out.println("1. Listar módulos");
        System.out.println("2. Buscar módulo por código");
        System.out.println("3. Registrar módulo");
        System.out.println("4. Actualizar módulo");
        System.out.println("5. Dar de baja módulo");
        System.out.println("6. Volver atrás");
    }

    // ============================================================
    // MÉTODOS UTILITARIOS
    // ============================================================
        private int leerEntero(){
        while (!scanner.hasNext()){
            scanner.nextLine();
            scanner.nextLine();
            System.out.println("Debe ingresar un ingresar numero.");
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
        }

        private String leerOpcional(String mensaje, String valorActual){
            System.out.println(mensaje + "(actual: " + valorActual + " , ENTER para mantener): ");
            String input = scanner.nextLine().trim();
            return input.isEmpty() ? valorActual : input;
        }

        private LocalTime leerHoraOpcional(String mensaje,LocalTime valorActual){
            System.out.println(mensaje + " ( actual :  " + valorActual + ", ENTER para mantener) :");
            String input = scanner.nextLine().trim();
            if(input.isEmpty()) return valorActual; // no modificar
            while (true){
                try {
                    return LocalTime.parse(input); // intenta parsear
                }catch (Exception e){
                    System.out.println("Formato invalido.use HH:mm (ej : 8:30).intente nuevamente: ");
                    input = scanner.nextLine().trim();
                    if (input.isEmpty())  return valorActual; // permite volver atras
                }
            }
        }

        private LocalTime leerHoraObligatoria(String mensaje){
            System.out.println(mensaje + "(formato HH:mm): ");
            String input = scanner.nextLine().trim();
            while (true){
                try {
                    return LocalTime.parse(input);
                }catch (Exception e){
                    System.out.println("Formato invalido. Use HH:mm (ej : 08:30).Intenete nuevamente: ");
                    input = scanner.nextLine().trim();
                }
            }
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

        private void mostrarModulo(Modulo m){
            System.out.println(
                    "CODIGO: " + m.getCodigo() +
                            "| INICIO: " + m.getInicio() +
                            "| FIN: " + m.getFin() +
                            "1 ESTADO: " + (m.isActivo() ? "ACTIVO" : "INACTIVO")
            );
        }
        // ============================================================
        // CRUD
        // ============================================================

        private void listarModulos(){
            System.out.println("--------Listar modulos-----------");
            List<Modulo> lista = moduloController.findAll();
            if(lista.isEmpty()){
                System.out.println("No hay modlos registrados");
                return;
            }
            lista.forEach(this::mostrarModulo);
        }

        private void buscarModulo(){
            System.out.println("-------Buscar modulo----------------");
            System.out.println("Ingrese el codigo del modulo");
            String codigo = scanner.nextLine();

            Modulo m = moduloController.findByCodigo(codigo);

            if(m == null){
                System.out.println("Modulo no encontrado");
                return;
            }
            mostrarModulo(m);
    }

    private void crearModulo(){
        System.out.println("-----Registrar modulo");
        System.out.println("Codigo del modulo: ");
        String codigo = scanner.nextLine();

        if(moduloController.findByCodigo(codigo) != null){
            System.out.println("Ya existe un modulo con ese codigo");
            return;
        }

        LocalTime inicio = leerHoraObligatoria("Hora de inicio");
        LocalTime fin = leerHoraObligatoria("Hora de fin");

        Modulo nuevo = new Modulo(codigo,inicio,fin);
        System.out.println("Vista previa");
        mostrarModulo(nuevo);

        if(confirmarAccion("¿confirmar registro?")){
            moduloController.createModulo(nuevo);
            System.out.println("modulo registrado correctamente");

        }
    }

    private void actualizarModulo(){
        System.out.println("-----Actualizar modulo---------");
        System.out.println("ingrese el codigo del modulo: ");
        String codigo = scanner.nextLine();
        Modulo m = moduloController.findByCodigo(codigo);
        if(m == null){
            System.out.println("Modulo no encontrado o inactivo");
            return;
        }
        System.out.println("Modulo encontrado");
        mostrarModulo(m);

        System.out.println("Ingrese nuevos valores (ENTER para mantener el actual)");

        //hora de incio opcional

        LocalTime nuevoInicio = leerHoraOpcional("Nueva hora de incio(HH:mm)",m.getInicio());

        // hora de fin opcional
        LocalTime nuevoFin = leerHoraOpcional("Nueva hora de incio(HH:mm)",m.getFin());

        m.setInicio(nuevoInicio);
        m.setFin(nuevoFin);

        System.out.println("Vista previa");
        mostrarModulo(m);

        if(confirmarAccion("¿Guardar cambios?")){
            moduloController.updateModulo(m);
            System.out.println("modulo actualizado");
        }

    }

    private void eliminarModulo(){
        System.out.println("---------ELiminar modulo----------------");
        System.out.println("ingese el codigo del modulo");
        String codigo = scanner.nextLine();
        Modulo m = moduloController.findByCodigo(codigo);
        if(m == null){
            System.out.println("modulo no encontrado");
            return;
        }

        mostrarModulo(m);
        if(confirmarAccion("¿Confirmar baja?")){
            moduloController.deleteModulo(m);
            System.out.println("modulo eliminado");
        }
    }


}

/*








*/
