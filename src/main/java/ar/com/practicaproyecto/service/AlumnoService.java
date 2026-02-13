package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.Alumno;

public interface AlumnoService extends CRUDService<Alumno> {
    Alumno findByDni(String dni);
}
