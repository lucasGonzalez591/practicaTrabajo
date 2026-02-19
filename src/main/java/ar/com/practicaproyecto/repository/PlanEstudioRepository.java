package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.PlanEstudio;

public interface PlanEstudioRepository extends CRUDRepository<PlanEstudio> {
    PlanEstudio findByName(String nombre);
    
}
