package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.PlanEstudio;
import ar.com.practicaproyecto.repository.PlanEstudioRepository;
import ar.com.practicaproyecto.repository.impl.PlanEstudioRepositoryImpl;
import ar.com.practicaproyecto.service.PlanEstudioService;

import java.util.List;

public class PlanEstudioServiceImpl implements PlanEstudioService {
    private final PlanEstudioRepository planEstudioRepository;

    public PlanEstudioServiceImpl(){
        this.planEstudioRepository = new PlanEstudioRepositoryImpl();
    }

    @Override
    public PlanEstudio findByName(String nombre) {
        return this.planEstudioRepository.findByName(nombre);
    }

    @Override
    public List<PlanEstudio> findAll() {
        return this.planEstudioRepository.findAll();
    }

    @Override
    public void save(PlanEstudio planEstudio) {
        this.planEstudioRepository.save(planEstudio);
    }

    @Override
    public void update(PlanEstudio planEstudio) {
        this.planEstudioRepository.update(planEstudio);
    }

    @Override
    public void delete(PlanEstudio planEstudio) {
        this.planEstudioRepository.delete(planEstudio);
    }
}
