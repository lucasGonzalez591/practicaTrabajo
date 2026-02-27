package ar.com.practicaproyecto.controller;

import ar.com.practicaproyecto.model.Horario;
import ar.com.practicaproyecto.service.HorarioService;
import ar.com.practicaproyecto.service.impl.HorarioServiceImpl;

import java.util.List;

public class HorarioController  {
    private final HorarioService horarioService;

    public HorarioController(){
        this.horarioService = new HorarioServiceImpl();
    }

    public Horario findById(String id){
       return this.horarioService.findById(id);
    }

    public List<Horario> findAll(){
       return this.horarioService.findAll();
    }

    public void createHorario(Horario horario){
        this.horarioService.save(horario);
    }
    public void updateHorario(Horario horario){
        this.horarioService.update(horario);
    }

    public void deleteHorario(Horario horario){
        this.horarioService.delete(horario);
    }

}
