package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Alumno;

public interface AlumnoRepository extends CRUDRepository<Alumno>{
    Alumno findByDni(String dni);

}
