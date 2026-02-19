package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.PlanEstudio;
import ar.com.practicaproyecto.service.PlanEstudioService;
import ar.com.practicaproyecto.service.impl.PlanEstudioServiceImpl;

import java.util.List;

public class PlanEstudioController {
    private final PlanEstudioService planEstudioService;

    public PlanEstudioController(){
        this.planEstudioService = new PlanEstudioServiceImpl();
    }

    public PlanEstudio findByName(String nombre){
        return this.planEstudioService.findByName(nombre);
    }

    public List<PlanEstudio> findAll(){
        return this.planEstudioService.findAll();
    }

    public void createPlanEstudio(PlanEstudio planEstudio){
        this.planEstudioService.save(planEstudio);
    }

    public void updatePlanEstudio(PlanEstudio planEstudio){
        this.planEstudioService.update(planEstudio);
    }

    public void deletePlanEstudio(PlanEstudio planEstudio){
        this.planEstudioService.delete(planEstudio);
    }


}
