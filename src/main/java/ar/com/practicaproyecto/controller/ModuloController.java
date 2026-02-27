package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.Modulo;
import ar.com.practicaproyecto.service.ModuloService;
import ar.com.practicaproyecto.service.impl.ModuloServiceImpl;

import java.util.List;

public class ModuloController {
    private final ModuloService moduloService;

    public ModuloController(){
        this.moduloService = new ModuloServiceImpl();
    }

    public Modulo findByCodigo(String codigo){
        return this.moduloService.findByCodigo(codigo);
    }

    public List<Modulo> findAll(){
        return this.moduloService.findAll();
    }

    public void createModulo(Modulo modulo){
        this.moduloService.save(modulo);
    }

    public void updateModulo(Modulo modulo){
        this.moduloService.update(modulo);
    }

    public void deleteModulo(Modulo modulo){
        this.moduloService.delete(modulo);
    }

}

