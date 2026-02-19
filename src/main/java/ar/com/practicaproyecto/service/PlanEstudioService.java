package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.PlanEstudio;
import ar.com.practicaproyecto.repository.CRUDRepository;

public interface PlanEstudioService extends CRUDService<PlanEstudio> {
    PlanEstudio findByName(String dni);


}
