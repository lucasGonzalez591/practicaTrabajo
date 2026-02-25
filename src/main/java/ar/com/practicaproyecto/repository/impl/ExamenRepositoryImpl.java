package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.Alumno;
import ar.com.practicaproyecto.model.Examen;
import ar.com.practicaproyecto.model.Materia;
import ar.com.practicaproyecto.model.Tipo;
import ar.com.practicaproyecto.repository.AlumnoRepository;
import ar.com.practicaproyecto.repository.ExamenRepository;
import ar.com.practicaproyecto.repository.MateriaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExamenRepositoryImpl  implements ExamenRepository {
    private final List<Examen> examenDB;
    private final AlumnoRepository alumnoRepository;
    private final MateriaRepository materiaRepository;

    public ExamenRepositoryImpl(){
        this.examenDB = new ArrayList<>();
        this.alumnoRepository = new AlumnoRepositoryImpl();
        this.materiaRepository = new MateriaRepositoryImpl();
        cargarDatos();
    }

    private void cargarDatos(){
        Alumno mauro = this.alumnoRepository.findByDni("11111111");
        Alumno lucas = this.alumnoRepository.findByDni("22222222");
        Alumno luciano = this.alumnoRepository.findByDni("33333333");
        Alumno mauroG = this.alumnoRepository.findByDni("44444444");

        Materia matematica1 = this.materiaRepository.findByCodigo("An25Mat1");
        Examen examen1 = new Examen("1", Tipo.PARCIAL, LocalDate.now(),9.00,mauro,matematica1);
        Examen examen2 = new Examen("2",Tipo.PARCIAL,LocalDate.now(),7.00,lucas,matematica1);
        Examen examen3 = new Examen("3",Tipo.PARCIAL,LocalDate.now(),9.50,luciano,matematica1);
        Examen examen4 = new Examen("4",Tipo.PARCIAL,LocalDate.now(),10.00,mauroG,matematica1);

        examenDB.add(examen1);
        examenDB.add(examen2);
        examenDB.add(examen3);
        examenDB.add(examen4);
    }


    @Override
    public Examen findById(String idExamen) {
        Examen examen = null;
        for(Examen examenResult : this.examenDB){
            if (examenResult.getId().equals(idExamen)){
                examen = examenResult;
            }
        }
        return examen;
    }

    @Override
    public List<Examen> findAll() {
        return this.examenDB;
    }

    @Override
    public void save(Examen examen) {
        for(Examen examenResult : this.examenDB){
            if(examenResult.getId().equals(examen.getId())){
                return;
            }
        }
        this.examenDB.add(examen);
    }

    @Override
    public void update(Examen examen) {
        for(Examen examenResult : this.examenDB){
            if(examenResult.getId().equals(examen.getId())){
                examenResult.setTipo(examen.getTipo());
                examenResult.setFecha(examen.getFecha());
                examenResult.setNota(examen.getNota());
                examenResult.setAlumno(examen.getAlumno());
                examenResult.setMateria(examen.getMateria());
                return;
            }
        }
    }

    @Override
    public void delete(Examen examen) {
        for(Examen examenResult : this.examenDB){
            if(examenResult.getId().equals(examen.getId())){
                examenResult.setActivo(false);
            }
        }
    }
}

/*



*/
