package ar.com.practicaproyecto.repository;

import ar.com.practicaproyecto.model.Horario;

public interface HorarioRepository extends CRUDRepository<Horario>{
    Horario findById(String id);
}
