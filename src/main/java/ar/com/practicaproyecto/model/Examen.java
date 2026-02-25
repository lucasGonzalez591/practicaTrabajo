package ar.com.practicaproyecto.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Examen {
    private String id;
    private Tipo tipo;
    private LocalDate fecha;
    private double nota;
    private Alumno alumno;
    private Materia materia;
    private boolean activo;

    public Examen(String id,Tipo tipo,LocalDate fecha,Alumno alumno, Materia materia){
        this.id = id;
        this.tipo = tipo;
        this.fecha  = fecha;
        this.alumno = alumno;
        this.materia = materia;
        this.activo = true;
    }

    public Examen(String id,Tipo tipo, LocalDate fecha,Double nota,Alumno alumno,Materia materia){
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
        this.activo = true;
    }


}


