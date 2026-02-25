package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.AlumnoInscriptoMateria;
import ar.com.practicaproyecto.service.AlumnoInscriptoMateriaService;
import ar.com.practicaproyecto.service.impl.AlumnoInscriptoMateriaServiceImpl;

import java.util.List;

public class AlumnoInscriptoMateriaController {
    private final AlumnoInscriptoMateriaService alumnoInscriptoMateriaService;

    public AlumnoInscriptoMateriaController(){
        this.alumnoInscriptoMateriaService = new AlumnoInscriptoMateriaServiceImpl();
    }

    public AlumnoInscriptoMateria findByAlumnoDni(String dni){
         return this.alumnoInscriptoMateriaService.findByAlumnoDni(dni);
    }

    public List<AlumnoInscriptoMateria> findAll(){
        return this.alumnoInscriptoMateriaService.findAll();
    }

    public void save(AlumnoInscriptoMateria alumnoInscriptoMateria){
        this.alumnoInscriptoMateriaService.save(alumnoInscriptoMateria);
    }

    public void update(AlumnoInscriptoMateria alumnoInscriptoMateria){
        this.alumnoInscriptoMateriaService.update(alumnoInscriptoMateria);
    }

    public void delete (AlumnoInscriptoMateria alumnoInscriptoMateria){
        this.alumnoInscriptoMateriaService.delete(alumnoInscriptoMateria);
    }


}
