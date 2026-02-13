package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.Profesor;

public interface ProfesorService extends  CRUDService<Profesor> {
    Profesor findByDni(String dni);

}
