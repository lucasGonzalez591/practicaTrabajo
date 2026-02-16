package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.Materia;

public interface MateriaService extends CRUDService<Materia> {
    Materia findByCode(String codigoMateria);
}
