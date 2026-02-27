package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Modulo;

public interface ModuloRepository extends CRUDRepository<Modulo> {
    Modulo findByCodigo(String codigoModulo);
}
