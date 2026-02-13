package ar.com.practicaproyecto.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Cuatrimestre  {
    private String numero;
    private LocalDate inicio;
    private LocalDate fin;
    private String anio;
    private boolean activo;

    public Cuatrimestre(String numero,LocalDate inicio,LocalDate fin,String anio){
        this.numero = numero;
        this.inicio = inicio;
        this.fin = fin;
        this.anio = anio;
        this.activo = true;
    }
}


