package ar.com.practicaproyecto.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AlumnoInscriptoCarrera {
    private String anioIngreso;
    private Carrera carrera;
    private PlanEstudio planEstudio;
    private Alumno alumno;
    private boolean activo;

    public AlumnoInscriptoCarrera(String anioIngreso,Carrera carrera,Alumno alumno,PlanEstudio planEstudio){
        this.anioIngreso = anioIngreso;
        this.carrera = carrera;
        this.alumno = alumno;
        this.planEstudio = planEstudio;
        this.activo = true;
    }

}



