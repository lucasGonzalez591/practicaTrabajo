package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.AlumnoInscriptoCarrera;

public interface AlumnoInscriptoCarreraRepository extends CRUDRepository<AlumnoInscriptoCarrera> {
    AlumnoInscriptoCarrera findByDni(String dni);


}

