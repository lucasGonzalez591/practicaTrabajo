package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Cuatrimestre;

public interface CuatrimestreRepository extends  CRUDRepository<Cuatrimestre> {
    Cuatrimestre findByNumber(String numeroCuatrimestre);
}
