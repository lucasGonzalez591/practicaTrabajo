package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.Profesor;
import ar.com.practicaproyecto.repository.ProfesorRepository;
import ar.com.practicaproyecto.repository.impl.ProfesorRepositoryImpl;
import ar.com.practicaproyecto.service.ProfesorService;

import java.util.List;

public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(){
        this.profesorRepository = new ProfesorRepositoryImpl();
    }

    @Override
    public Profesor findByDni(String dni) {
        return this.profesorRepository.findByDni(dni);
    }

    @Override
    public List<Profesor> findAll() {
        return this.profesorRepository.findAll();
    }

    @Override
    public void save(Profesor profesor) {
        this.profesorRepository.save(profesor);
    }

    @Override
    public void update(Profesor profesor) {
        this.profesorRepository.update(profesor);
    }

    @Override
    public void delete(Profesor profesor) {
        this.profesorRepository.delete(profesor);
    }
}
