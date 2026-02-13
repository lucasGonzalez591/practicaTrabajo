package ar.com.practicaproyecto;

import ar.com.practicaproyecto.view.InicioView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticaProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaProyectoApplication.class, args);
        InicioView inicioView = new InicioView();

        inicioView.iniciar();
    }

}
