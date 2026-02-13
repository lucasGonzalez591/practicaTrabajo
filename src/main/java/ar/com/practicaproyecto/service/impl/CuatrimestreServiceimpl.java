package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.Cuatrimestre;
import ar.com.practicaproyecto.repository.CuatrimestreRepository;
import ar.com.practicaproyecto.repository.impl.CuatrimestreRepositoryImpl;
import ar.com.practicaproyecto.service.CuatrimestreService;

import java.util.List;

public class CuatrimestreServiceimpl implements CuatrimestreService {
    private final CuatrimestreRepository cuatrimestreRepository;

    public CuatrimestreServiceimpl(){
        this.cuatrimestreRepository = new CuatrimestreRepositoryImpl();
    }

    @Override
    public Cuatrimestre findByNumber(String numeroCuatrimestre) {
        return this.cuatrimestreRepository.findByNumber(numeroCuatrimestre);
    }

    @Override
    public List<Cuatrimestre> findAll() {
        return this.cuatrimestreRepository.findAll();
    }

    @Override
    public void save(Cuatrimestre cuatrimestre) {
        this.cuatrimestreRepository.save(cuatrimestre);
    }

    @Override
    public void update(Cuatrimestre cuatrimestre) {
        this.cuatrimestreRepository.update(cuatrimestre);
    }

    @Override
    public void delete(Cuatrimestre cuatrimestre) {
        this.cuatrimestreRepository.delete(cuatrimestre);
    }
}
