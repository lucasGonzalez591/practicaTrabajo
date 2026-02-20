package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Carrera;

public interface CarreraRepository extends CRUDRepository<Carrera> {
    Carrera findByName(String nombre);
    
}
