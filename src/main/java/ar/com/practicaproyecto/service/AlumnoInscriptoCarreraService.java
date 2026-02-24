package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.AlumnoInscriptoCarrera;

public interface AlumnoInscriptoCarreraService extends CRUDService<AlumnoInscriptoCarrera>{
    AlumnoInscriptoCarrera findByDn(String dni);

}
