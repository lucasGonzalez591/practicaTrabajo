package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.AlumnoInscriptoMateria;

public interface AlumnoInscriptoMateriaRepository extends CRUDRepository<AlumnoInscriptoMateria>{
    AlumnoInscriptoMateria findByAlumnoDni(String dni);


}
