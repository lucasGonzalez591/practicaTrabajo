package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Examen;

public interface ExamenRepository extends CRUDRepository<Examen> {
    Examen findById(String idExamen);
}

