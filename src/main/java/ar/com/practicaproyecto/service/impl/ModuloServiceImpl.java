package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.AlumnoInscriptoMateria;
import ar.com.practicaproyecto.model.Modulo;
import ar.com.practicaproyecto.repository.ModuloRepository;
import ar.com.practicaproyecto.repository.impl.ModuloRepositoryImpl;
import ar.com.practicaproyecto.service.ModuloService;

import java.util.List;

public class ModuloServiceImpl implements ModuloService {
    private ModuloRepository moduloRepository;

    public ModuloServiceImpl(){
        this.moduloRepository = new ModuloRepositoryImpl();
    }

    @Override
    public Modulo findByCodigo(String codigo) {
        return this.moduloRepository.findByCodigo(codigo);
    }


    @Override
    public List<Modulo> findAll() {
        return this.moduloRepository.findAll();
    }

    @Override
    public void save(Modulo modulo) {
        this.moduloRepository.save(modulo);
    }

    @Override
    public void update(Modulo modulo) {
        this.moduloRepository.update(modulo);
    }

    @Override
    public void delete(Modulo modulo) {
        this.moduloRepository.delete(modulo);
    }


}
