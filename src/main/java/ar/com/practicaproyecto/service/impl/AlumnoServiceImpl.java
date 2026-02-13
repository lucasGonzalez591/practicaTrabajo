package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.Alumno;
import ar.com.practicaproyecto.repository.AlumnoRepository;
import ar.com.practicaproyecto.repository.impl.AlumnoRepositoryImpl;
import ar.com.practicaproyecto.service.AlumnoService;

import java.util.List;

public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(){
        this.alumnoRepository = new AlumnoRepositoryImpl();
    }

    @Override
    public Alumno findByDni(String dni) {
        return this.alumnoRepository.findByDni(dni);
    }

    @Override
    public List<Alumno> findAll() {
        return this.alumnoRepository.findAll();
    }

    @Override
    public void save(Alumno alumno) {
        this.alumnoRepository.save(alumno);
    }

    @Override
    public void update(Alumno alumno) {
        this.alumnoRepository.update(alumno);
    }

    @Override
    public void delete(Alumno alumno) {
        this.alumnoRepository.delete(alumno);
    }
}
