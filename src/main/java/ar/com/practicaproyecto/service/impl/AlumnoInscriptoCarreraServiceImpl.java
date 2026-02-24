package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.AlumnoInscriptoCarrera;
import ar.com.practicaproyecto.repository.AlumnoInscriptoCarreraRepository;
import ar.com.practicaproyecto.repository.impl.AlumnoInscriptoCarreraImpl;
import ar.com.practicaproyecto.service.AlumnoInscriptoCarreraService;

import java.util.List;

public class AlumnoInscriptoCarreraServiceImpl implements AlumnoInscriptoCarreraService {
    private final AlumnoInscriptoCarreraRepository alumnoInscriptoCarreraRepository;

    public AlumnoInscriptoCarreraServiceImpl(){
        this.alumnoInscriptoCarreraRepository = new AlumnoInscriptoCarreraImpl();
    }

    @Override
    public AlumnoInscriptoCarrera findByDn(String dni) {
        return this.alumnoInscriptoCarreraRepository.findByDni(dni);
    }

    @Override
    public List<AlumnoInscriptoCarrera> findAll() {
        return this.alumnoInscriptoCarreraRepository.findAll();
    }

    @Override
    public void save(AlumnoInscriptoCarrera inscriptoCarrera) {
        this.alumnoInscriptoCarreraRepository.save(inscriptoCarrera);
    }

    @Override
    public void update(AlumnoInscriptoCarrera inscriptoCarrera) {
        this.alumnoInscriptoCarreraRepository.update(inscriptoCarrera);
    }

    @Override
    public void delete(AlumnoInscriptoCarrera inscriptoCarrera) {
        this.alumnoInscriptoCarreraRepository.delete(inscriptoCarrera);
    }
}
