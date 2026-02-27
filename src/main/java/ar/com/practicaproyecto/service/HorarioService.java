package ar.com.practicaproyecto.service;

import ar.com.practicaproyecto.model.Horario;

public interface HorarioService extends CRUDService<Horario>{
    Horario findById(String id);
}
