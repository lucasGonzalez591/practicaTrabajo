package ar.com.practicaproyecto.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Carrera {
    private String nombre;
    private Turno turno;
    private PlanEstudio planEstudio;
    private boolean activo;

    public Carrera(String nombre,Turno turno){
        this.nombre = nombre;
        this.turno = turno;
        this.activo = true;
    }

    public Carrera(String nombre, Turno turno,PlanEstudio planEstudio){
        this.nombre = nombre;
        this.turno = turno;
        this.planEstudio = planEstudio;
        this.activo = true;
    }

}



