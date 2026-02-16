package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Materia;

public interface MateriaRepository extends CRUDRepository<Materia> {
    Materia findByCodigo(String codigoMateria);
}
