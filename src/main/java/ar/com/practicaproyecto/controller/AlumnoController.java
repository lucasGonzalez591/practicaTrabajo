package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.Alumno;
import ar.com.practicaproyecto.service.AlumnoService;
import ar.com.practicaproyecto.service.impl.AlumnoServiceImpl;

import java.util.List;

public class AlumnoController {
    private final AlumnoService alumnoService;

    public AlumnoController(){
        this.alumnoService = new AlumnoServiceImpl();
    }

    public Alumno findByDni(String dni){
        return this.alumnoService.findByDni(dni);
    }

    public List<Alumno> findAll(){
        return this.alumnoService.findAll();
    }

    public void createAlumno(Alumno alumno){
        this.alumnoService.save(alumno);
    }
    public void updateAlumno(Alumno alumno){
        this.alumnoService.update(alumno);
    }
    public void deleteAlumno(Alumno alumno){
        this.alumnoService.delete(alumno);
    }


}



