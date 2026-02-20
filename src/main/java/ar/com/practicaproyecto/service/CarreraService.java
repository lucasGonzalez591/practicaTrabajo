package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.Carrera;

public interface CarreraService extends CRUDService<Carrera>{
    Carrera findByName(String nombre);
}
