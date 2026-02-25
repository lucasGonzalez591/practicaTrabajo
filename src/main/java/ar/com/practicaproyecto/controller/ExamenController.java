package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.Examen;
import ar.com.practicaproyecto.service.ExamenService;
import ar.com.practicaproyecto.service.impl.ExamenServiceImpl;

import java.util.List;

public class ExamenController {
    private final ExamenService examenService;

    public ExamenController(){
        this.examenService = new ExamenServiceImpl();
    }

    public Examen findbyDni(String idExamen){
        return this.examenService.findById(idExamen);
    }

    public List<Examen> findAll(){
        return this.examenService.findAll();
    }

    public void createExamen(Examen examen){
        this.examenService.save(examen);
    }

    public void updateExamen(Examen examen){
        this.examenService.update(examen);
    }

    public void deleteExamen(Examen examen){
        this.examenService.delete(examen);
    }

}

