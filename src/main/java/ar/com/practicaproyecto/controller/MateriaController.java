package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.Materia;
import ar.com.practicaproyecto.service.MateriaService;
import ar.com.practicaproyecto.service.impl.MateriaServiceImpl;

import java.util.List;

public class MateriaController {
    private final MateriaService materiaService;

    public MateriaController(){
        this.materiaService = new MateriaServiceImpl();
    }

    public Materia findByCode(String codigoMateria){
        return this.materiaService.findByCode(codigoMateria);
    }

    public List<Materia> findAll(){
        return this.materiaService.findAll();
    }

    public void createMateria(Materia materia){
        this.materiaService.save(materia);
    }
    public void updateMateria(Materia materia){
        this.materiaService.update(materia);
    }
    public void deleteMateria(Materia materia){
        this.materiaService.delete(materia);
    }

}
