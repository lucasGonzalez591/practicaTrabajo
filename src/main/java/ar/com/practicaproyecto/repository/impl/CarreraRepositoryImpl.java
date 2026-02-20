package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.Carrera;
import ar.com.practicaproyecto.model.Turno;
import ar.com.practicaproyecto.repository.CarreraRepository;
import ar.com.practicaproyecto.repository.PlanEstudioRepository;

import java.util.ArrayList;
import java.util.List;

public class CarreraRepositoryImpl  implements CarreraRepository {
    private final List<Carrera> carreraDB;
    private final PlanEstudioRepository planEstudioRepository;

    public CarreraRepositoryImpl(){
        this.carreraDB = new ArrayList<>();
        this.planEstudioRepository = new PlanEstudioRepositoryImpl();
        cargarDatos();
    }

    private void cargarDatos(){
        Carrera carrera1 = new Carrera("Tecnicatura en analisis de sistemas", Turno.NOCHE);
        Carrera carrera2 = new Carrera("Tecnicatura en gastronomia",Turno.MANANA);

        //agrega el plan a la carrera
        carrera1.setPlanEstudio(planEstudioRepository.findByName("Analista"));
        carreraDB.add(carrera1);
        carreraDB.add(carrera2);
    }


    @Override
    public Carrera findByName(String nombre) {
        Carrera carrera = null;
        for (Carrera carreraResult : this.carreraDB ){
            if(carreraResult.getNombre().equals(nombre)){
                carrera = carreraResult;
            }
        }
        return carrera;
    }

    @Override
    public List<Carrera> findAll() {
        return this.carreraDB;
    }

    @Override
    public void save(Carrera carrera) {
        for(Carrera carreraResult : this.carreraDB){
            if(carreraResult.getNombre().equals(carreraResult.getNombre())){
                return;
            }
        }
        this.carreraDB.add(carrera);
    }

    @Override
    public void update(Carrera carrera) {
        for(Carrera carreraResult : this.carreraDB){
            if(carreraResult.getNombre().equals(carrera.getNombre())){
                carreraResult.setTurno(carrera.getTurno());
                carreraResult.setPlanEstudio(carrera.getPlanEstudio());
                return;
            }
        }
    }

    @Override
    public void delete(Carrera carrera) {
        for(Carrera carreraResult : this.carreraDB){
            if (carreraResult.getNombre().equals(carreraResult.getNombre())){
                carreraResult.setActivo(false);
                return;
            }
        }
    }
}

