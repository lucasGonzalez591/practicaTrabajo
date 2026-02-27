package ar.com.practicaproyecto.model;

import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Modulo {
    private String codigo;
    private LocalTime inicio;
    private LocalTime fin;
    private boolean activo;

    public Modulo(String codigo,LocalTime inicio,LocalTime fin){
        this.codigo = codigo;
        this.inicio = inicio;
        this.fin = fin;
        this.activo = true;
    }
}


