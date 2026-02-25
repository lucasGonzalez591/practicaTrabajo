package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.AlumnoInscriptoMateria;
import ar.com.practicaproyecto.repository.AlumnoInscriptoMateriaRepository;
import ar.com.practicaproyecto.repository.impl.AlumnoInscriptoMateriaRepositoryImpl;
import ar.com.practicaproyecto.service.AlumnoInscriptoMateriaService;

import java.util.List;

public class AlumnoInscriptoMateriaServiceImpl implements AlumnoInscriptoMateriaService {
    private final AlumnoInscriptoMateriaRepository alumnoInscriptoMateriaRepository;

    public AlumnoInscriptoMateriaServiceImpl(){
        this.alumnoInscriptoMateriaRepository = new AlumnoInscriptoMateriaRepositoryImpl();
    }

    @Override
    public AlumnoInscriptoMateria findByAlumnoDni(String dni) {
        return this.alumnoInscriptoMateriaRepository.findByAlumnoDni(dni);
    }

    @Override
    public List<AlumnoInscriptoMateria> findAll() {
        return this.alumnoInscriptoMateriaRepository.findAll();
    }

    @Override
    public void save(AlumnoInscriptoMateria alumnoInscriptoMateria) {
        this.alumnoInscriptoMateriaRepository.save(alumnoInscriptoMateria);
    }

    @Override
    public void update(AlumnoInscriptoMateria alumnoInscriptoMateria) {
        this.alumnoInscriptoMateriaRepository.update(alumnoInscriptoMateria);
    }

    @Override
    public void delete(AlumnoInscriptoMateria alumnoInscriptoMateria) {
        this.alumnoInscriptoMateriaRepository.delete(alumnoInscriptoMateria);
    }
}
