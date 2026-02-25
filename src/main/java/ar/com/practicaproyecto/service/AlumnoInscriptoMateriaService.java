package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.AlumnoInscriptoMateria;

public interface AlumnoInscriptoMateriaService extends CRUDService<AlumnoInscriptoMateria> {
        AlumnoInscriptoMateria findByAlumnoDni(String dni);

}

