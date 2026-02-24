package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.Alumno;
import ar.com.practicaproyecto.model.AlumnoInscriptoCarrera;
import ar.com.practicaproyecto.model.Carrera;
import ar.com.practicaproyecto.model.PlanEstudio;
import ar.com.practicaproyecto.repository.AlumnoInscriptoCarreraRepository;
import ar.com.practicaproyecto.repository.AlumnoRepository;
import ar.com.practicaproyecto.repository.CarreraRepository;
import ar.com.practicaproyecto.repository.PlanEstudioRepository;

import java.util.ArrayList;
import java.util.List;

public class AlumnoInscriptoCarreraImpl implements AlumnoInscriptoCarreraRepository {
    private final List<AlumnoInscriptoCarrera> alumnosInscrCarrera;
    private final AlumnoRepository alumnoRepository;
    private final CarreraRepository carreraRepository;
    private final PlanEstudioRepository planEstudioRepository;

    public AlumnoInscriptoCarreraImpl(){
        this.alumnosInscrCarrera = new ArrayList<>();
        this.alumnoRepository = new AlumnoRepositoryImpl();
        this.carreraRepository = new CarreraRepositoryImpl();
        this.planEstudioRepository  = new PlanEstudioRepositoryImpl();
        cargarDatos();
    }

    private void cargarDatos(){
        Carrera carreraAnalista = carreraRepository.findByName("Tecnicatura en analisis de sistemas");
        Carrera carreraGastronomia = carreraRepository.findByName("Tecnicatura en gastronomia");
        Alumno alumnoMauro = this.alumnoRepository.findByDni("11111111");
        Alumno alumnoLucas = this.alumnoRepository.findByDni("22222222");
        Alumno alumnoLuciano = this.alumnoRepository.findByDni("33333333");
        Alumno alumnoMauroG = this.alumnoRepository.findByDni("44444444");


        PlanEstudio planAnalista = this.planEstudioRepository.findByName("Analista");
        PlanEstudio planGastronomia = this.planEstudioRepository.findByName("Gastronomia");

        AlumnoInscriptoCarrera inscripto1 = new AlumnoInscriptoCarrera("2025",carreraAnalista,alumnoMauro,planAnalista);
        AlumnoInscriptoCarrera inscripto2 = new AlumnoInscriptoCarrera("2025",carreraAnalista,alumnoLucas,planAnalista);
        AlumnoInscriptoCarrera inscripto3 = new AlumnoInscriptoCarrera("2025",carreraAnalista,alumnoLuciano,planAnalista);
        AlumnoInscriptoCarrera inscripto4 = new AlumnoInscriptoCarrera("2025",carreraAnalista,alumnoMauroG,planAnalista);
        AlumnoInscriptoCarrera inscripto5 = new AlumnoInscriptoCarrera("2025",carreraGastronomia,alumnoLucas,planGastronomia);
        this.alumnosInscrCarrera.add(inscripto1);
        this.alumnosInscrCarrera.add(inscripto2);
        this.alumnosInscrCarrera.add(inscripto3);
        this.alumnosInscrCarrera.add(inscripto4);
        this.alumnosInscrCarrera.add(inscripto5);
    }

    @Override
    public AlumnoInscriptoCarrera findByDni(String dni) {
        AlumnoInscriptoCarrera inscripto = null;
        for(AlumnoInscriptoCarrera alumnoInscripto : this.alumnosInscrCarrera){
            if(alumnoInscripto.getAlumno().getDni().equals(dni)){
                inscripto = alumnoInscripto;
            }
        }
        return inscripto;
    }

    @Override
    public List<AlumnoInscriptoCarrera> findAll() {
        return this.alumnosInscrCarrera;
    }

    @Override
    public void save(AlumnoInscriptoCarrera inscriptoC) {
        for(AlumnoInscriptoCarrera alc : this.alumnosInscrCarrera){
            if(alc.getAlumno().getDni().equals(inscriptoC.getAlumno().getDni())
                    && alc.getCarrera().getNombre().equals(inscriptoC.getCarrera().getNombre())){
                return;
            }
        }
        this.alumnosInscrCarrera.add(inscriptoC);
    }

    @Override
    public void update(AlumnoInscriptoCarrera inscriptoC) {
        for(AlumnoInscriptoCarrera aic : this.alumnosInscrCarrera){
            if(aic.getAlumno().getDni().equals(inscriptoC.getAlumno().getDni())){
                aic.setCarrera(inscriptoC.getCarrera());
                aic.setAlumno(inscriptoC.getAlumno());
                aic.setPlanEstudio(inscriptoC.getPlanEstudio());
                return;
            }
        }
    }

    @Override
    public void delete(AlumnoInscriptoCarrera alumnoInscriptoCarrera) {
        for(AlumnoInscriptoCarrera aic : this.alumnosInscrCarrera){
            if(aic.getAlumno().getDni().equals(alumnoInscriptoCarrera.getAlumno().getDni())
                    && (aic.getCarrera().getNombre().equals(alumnoInscriptoCarrera.getCarrera().getNombre()))){
                    aic.setActivo(false);

                return;
            }
        }
    }
}

/*




*/
