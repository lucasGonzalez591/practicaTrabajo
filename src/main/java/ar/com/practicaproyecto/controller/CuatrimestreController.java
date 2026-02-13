package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.Cuatrimestre;
import ar.com.practicaproyecto.service.CuatrimestreService;
import ar.com.practicaproyecto.service.impl.CuatrimestreServiceimpl;

import java.util.List;

public class CuatrimestreController {
    private final CuatrimestreService cuatrimestreService;

    public CuatrimestreController(){
        this.cuatrimestreService = new CuatrimestreServiceimpl();
    }

    public Cuatrimestre findByNumber(String numeroCuatrimestre){
        return this.cuatrimestreService.findByNumber(numeroCuatrimestre);
    }

    public List<Cuatrimestre> findAll(){
        return this.cuatrimestreService.findAll();
    }

    public void createCuatrimestre(Cuatrimestre cuatrimestre){
        this.cuatrimestreService.save(cuatrimestre);
    }

    public void updateCuatrimestre(Cuatrimestre cuatrimestre){
        this.cuatrimestreService.update(cuatrimestre);
    }

    public void deleteCuatrimestre(Cuatrimestre cuatrimestre){
        this.cuatrimestreService.delete(cuatrimestre);
    }


}
