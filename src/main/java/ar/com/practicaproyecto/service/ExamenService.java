package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.Examen;

public interface ExamenService extends CRUDService<Examen>  {
    Examen findById(String idExamen);


}
