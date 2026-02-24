package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.AlumnoInscriptoCarrera;
import ar.com.practicaproyecto.service.AlumnoInscriptoCarreraService;
import ar.com.practicaproyecto.service.impl.AlumnoInscriptoCarreraServiceImpl;

import java.util.List;

public class AlumnoInscriptoCarreraController {
    private final AlumnoInscriptoCarreraService alumnoInscriptoCarreraService;

    public AlumnoInscriptoCarreraController(){
        this.alumnoInscriptoCarreraService = new AlumnoInscriptoCarreraServiceImpl();
    }

    public AlumnoInscriptoCarrera findByDni(String dni){
        return this.alumnoInscriptoCarreraService.findByDn(dni);
    }

    public List<AlumnoInscriptoCarrera> findAll(){
        return this.alumnoInscriptoCarreraService.findAll();
    }

    public void save(AlumnoInscriptoCarrera alumnoInscriptoCarrera){
        this.alumnoInscriptoCarreraService.save(alumnoInscriptoCarrera);
    }

    public void update(AlumnoInscriptoCarrera alumnoInscriptoCarrera){
        this.alumnoInscriptoCarreraService.update(alumnoInscriptoCarrera);
    }

    public void delete(AlumnoInscriptoCarrera alumnoInscriptoCarrera){
        this.alumnoInscriptoCarreraService.delete(alumnoInscriptoCarrera);
    }


}
