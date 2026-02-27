package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.AlumnoInscriptoMateria;
import ar.com.practicaproyecto.model.Modulo;
import ar.com.practicaproyecto.service.impl.ModuloServiceImpl;

public interface ModuloService extends CRUDService<Modulo> {
    Modulo findByCodigo(String  codigo);
}
