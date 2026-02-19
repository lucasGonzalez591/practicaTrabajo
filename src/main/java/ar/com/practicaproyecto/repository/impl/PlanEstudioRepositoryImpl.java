package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.Materia;
import ar.com.practicaproyecto.model.PlanEstudio;
import ar.com.practicaproyecto.repository.MateriaRepository;
import ar.com.practicaproyecto.repository.PlanEstudioRepository;

import java.util.ArrayList;
import java.util.List;

public class PlanEstudioRepositoryImpl implements PlanEstudioRepository {
    private final MateriaRepository materiaRepository;
    private final List<PlanEstudio> planesDb;

    public PlanEstudioRepositoryImpl(){
        this.planesDb = new ArrayList<>();
        this.materiaRepository = new MateriaRepositoryImpl();
        cargarDatos();
    }

    private void cargarDatos(){
        PlanEstudio planAnalista2025 = new PlanEstudio("Analista","2025","3","Tecnicatura en analisis de sistemas");
        PlanEstudio planGastronomia = new PlanEstudio("Gastronomia","2025","3","Tecnicatura en gastronomia");

        //agregar las materias al plan
        List<Materia> materiasAnalista = new ArrayList<>();
        materiasAnalista.add(materiaRepository.findByCodigo("An25Mat1"));
        materiasAnalista.add(materiaRepository.findByCodigo("An25Mat2"));
        materiasAnalista.add(materiaRepository.findByCodigo("An25Mat3"));
        materiasAnalista.add(materiaRepository.findByCodigo("An25Ing1"));
        materiasAnalista.add(materiaRepository.findByCodigo("An25Ing2"));

        planAnalista2025.setMaterias(materiasAnalista);
        planesDb.add(planAnalista2025);
        planesDb.add(planGastronomia);
    }

    @Override
    public PlanEstudio findByName(String nombre) {
        PlanEstudio planEstudio = null;
        for(PlanEstudio planEstudioResult : this.planesDb){
            if(planEstudioResult.getNombre().equals(nombre)){
                planEstudio = planEstudioResult;
                break;
            }
        }
        return planEstudio;
    }

    @Override
    public List<PlanEstudio> findAll() {
        return this.planesDb;
    }

    @Override
    public void save(PlanEstudio planEstudio) {
        for(PlanEstudio planEstudioResult : this.planesDb){
            if(planEstudioResult.getNombre().equals(planEstudio.getNombre())){
                return;
            }
        }
        this.planesDb.add(planEstudio);
    }

    @Override
    public void update(PlanEstudio planEstudio) {
        for(PlanEstudio planEstudioResult : this.planesDb){
            if(planEstudioResult.getNombre().equals(planEstudio.getNombre())){
                planEstudioResult.setNombre(planEstudio.getNombre());
                planEstudioResult.setAnio(planEstudio.getAnio());
                planEstudioResult.setDuracion(planEstudio.getDuracion());
                planEstudioResult.setTitulo(planEstudio.getTitulo());
                return;
            }
        }
    }

    @Override
    public void delete(PlanEstudio planEstudio) {
        for(PlanEstudio planEstudioResult : this.planesDb){
            if(planEstudioResult.getNombre().equals(planEstudio.getNombre())){
                planEstudioResult.setActivo(false);
                return;
            }
        }
    }
}

