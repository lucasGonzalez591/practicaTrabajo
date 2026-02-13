package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.Cuatrimestre;

public interface CuatrimestreService  extends CRUDService<Cuatrimestre>{
    Cuatrimestre findByNumber(String numeroCuatrimestre);

    
}
