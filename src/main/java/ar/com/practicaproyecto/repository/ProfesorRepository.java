package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Profesor;

public interface ProfesorRepository extends CRUDRepository<Profesor>{
    Profesor findByDni(String dni);
}
