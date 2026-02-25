package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.AlumnoInscriptoMateria;
import ar.com.practicaproyecto.repository.AlumnoInscriptoCarreraRepository;
import ar.com.practicaproyecto.repository.AlumnoInscriptoMateriaRepository;

import java.util.ArrayList;
import java.util.List;

public class AlumnoInscriptoMateriaRepositoryImpl implements AlumnoInscriptoMateriaRepository {

    private final List<AlumnoInscriptoMateria> inscriptosDB;
    private final AlumnoInscriptoCarreraRepository alumnoInscriptoCarreraRepository;

    public AlumnoInscriptoMateriaRepositoryImpl(){
        this.inscriptosDB = new ArrayList<>();
        this.alumnoInscriptoCarreraRepository = new AlumnoInscriptoCarreraImpl();
        cargarDatos();
    }

    private void cargarDatos(){

    }

    @Override
    public AlumnoInscriptoMateria findByAlumnoDni(String dni) {
        AlumnoInscriptoMateria inscripto = null;
        for (AlumnoInscriptoMateria inscriptoResult : this.inscriptosDB){
            if(inscriptoResult.getAlumnoInscriptoCarrera().getAlumno().getDni().equals(dni)){
                inscripto = inscriptoResult;
                break;
            }
        }
        return inscripto;
    }

    @Override
    public List<AlumnoInscriptoMateria> findAll() {
        return this.inscriptosDB;
    }

    @Override
    public void save(AlumnoInscriptoMateria alumnoInscriptoMateria) {
        for(AlumnoInscriptoMateria inscriptoResult : this.inscriptosDB){
            if(inscriptoResult.getAlumnoInscriptoCarrera().getAlumno().equals(alumnoInscriptoMateria.getAlumnoInscriptoCarrera().getAlumno().getDni())){
                return;
            }
        }
        this.inscriptosDB.add(alumnoInscriptoMateria);
    }

    @Override
    public void update(AlumnoInscriptoMateria alumnoInscriptoMateria) {
        for(AlumnoInscriptoMateria aim : this.inscriptosDB){
            if(aim.getAlumnoInscriptoCarrera().getAlumno().getDni().equals(alumnoInscriptoMateria.getAlumnoInscriptoCarrera().getAlumno().getDni())) {
                aim.setAlumnoInscriptoCarrera(alumnoInscriptoMateria.getAlumnoInscriptoCarrera());
                aim.setExamenes(alumnoInscriptoMateria.getExamenes());
                aim.setEstado(alumnoInscriptoMateria.getEstado());
            }
        }
    }

    @Override
    public void delete(AlumnoInscriptoMateria alumnoInscriptoMateria) {
        for(AlumnoInscriptoMateria aim: this.inscriptosDB) {
            if (aim.getAlumnoInscriptoCarrera().getAlumno().getDni().equals(alumnoInscriptoMateria.getAlumnoInscriptoCarrera().getAlumno().getDni())) {
                aim.setActivo(false);
                return;
            }
        }

    }
}


/*



*/
