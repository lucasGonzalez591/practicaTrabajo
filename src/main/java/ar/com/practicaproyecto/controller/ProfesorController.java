package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.Profesor;
import ar.com.practicaproyecto.service.ProfesorService;
import ar.com.practicaproyecto.service.impl.ProfesorServiceImpl;

import java.util.List;

public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(){
        this.profesorService = new ProfesorServiceImpl();
    }

    public Profesor findByDni(String dni){
        return this.profesorService.findByDni(dni);
    }
    public List<Profesor> findAll(){
        return this.profesorService.findAll();
    }

    public void createProfesor(Profesor profesor){
        this.profesorService.save(profesor);
    }

    public void updateProfesor(Profesor profesor){
        this.profesorService.update(profesor);
    }

    public void deleteProfesor(Profesor profesor){
        this.profesorService.delete(profesor);
    }


}
