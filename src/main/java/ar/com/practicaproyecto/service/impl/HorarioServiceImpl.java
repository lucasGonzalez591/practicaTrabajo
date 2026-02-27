package ar.com.practicaproyecto.service.impl;

import ar.com.practicaproyecto.model.Horario;
import ar.com.practicaproyecto.repository.HorarioRepository;
import ar.com.practicaproyecto.repository.impl.HorarioRepositoryImpl;
import ar.com.practicaproyecto.service.HorarioService;

import java.util.List;

public class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository horarioRepository;

    public HorarioServiceImpl(){
        this.horarioRepository = new HorarioRepositoryImpl();
    }


    @Override
    public Horario findById(String id) {
        return this.horarioRepository.findById(id);
    }

    @Override
    public List<Horario> findAll() {
        return this.horarioRepository.findAll();
    }

    @Override
    public void save(Horario horario) {
        this.horarioRepository.save(horario);
    }

    @Override
    public void update(Horario horario) {
        this.horarioRepository.update(horario);
    }

    @Override
    public void delete(Horario horario) {
        this.horarioRepository.delete(horario);
    }
}
