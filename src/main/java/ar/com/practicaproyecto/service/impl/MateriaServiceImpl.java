package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.Materia;
import ar.com.practicaproyecto.repository.MateriaRepository;
import ar.com.practicaproyecto.repository.impl.MateriaRepositoryImpl;
import ar.com.practicaproyecto.service.MateriaService;

import java.util.List;

public class MateriaServiceImpl implements MateriaService {
    private final MateriaRepository materiaRepository;

    public MateriaServiceImpl(){
        this.materiaRepository = new MateriaRepositoryImpl();
    }

    @Override
    public Materia findByCode(String codigoMateria) {
        return this.materiaRepository.findByCodigo(codigoMateria);
    }

    @Override
    public List<Materia> findAll() {
        return this.materiaRepository.findAll();
    }

    @Override
    public void save(Materia materia) {
        this.materiaRepository.save(materia);
    }

    @Override
    public void update(Materia materia) {
        this.materiaRepository.update(materia);
    }

    @Override
    public void delete(Materia materia) {
        this.materiaRepository.delete(materia);
    }
}
