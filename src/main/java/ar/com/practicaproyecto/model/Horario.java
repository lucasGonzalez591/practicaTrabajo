package ar.com.practicaproyecto.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Horario {
    private String id;
    private Dia dia;
    private  Carrera carrera;
    private Cuatrimestre cuatrimestre;
    private Modulo modulo;
    private boolean disponible;
    private boolean activo;



    public Horario (String id, Dia dia,Carrera carrera,Cuatrimestre cuatrimestre){
        this.id = id;
        this.dia = dia;
        this.carrera = carrera;
        this.disponible = true;
        this.activo = true;
    }

    public Horario(String id,Dia dia,Carrera carrera,Cuatrimestre cuatrimestre ,Modulo modulo){
        this(id, dia, carrera, cuatrimestre);
        this.modulo = modulo;
    }

}



