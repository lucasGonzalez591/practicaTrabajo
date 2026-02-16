package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.Materia;
import ar.com.practicaproyecto.repository.MateriaRepository;

import java.util.ArrayList;
import java.util.List;

public class MateriaRepositoryImpl implements MateriaRepository {
    private final List<Materia> materiaDB;

    public MateriaRepositoryImpl(){
        this.materiaDB = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos(){
        Materia matematica1 = new Materia("An25Mat1","Matematica 1","1");
        Materia matematica2 = new Materia("An25Mat2","Matematica 2","1");
        Materia matematica3 = new Materia("An25Mat2","Matematica 3","2");
        Materia ingles1 = new Materia("An25Ing1","Ingles 1", "1");
        Materia ingles2 = new Materia("An25Ing2","Ingles 2", "1");

        List<Materia> correMat2 = new ArrayList<>();
        correMat2.add(matematica1);
        matematica2.setCorrelativas(correMat2);

        List<Materia> correMat3 = new ArrayList<>();
        correMat3.add(matematica2);
        matematica3.setCorrelativas(correMat3);

        List<Materia> correIngle2 = new ArrayList<>();
        correIngle2.add(ingles1);
        ingles2.setCorrelativas(correIngle2);

        this.materiaDB.add(matematica1);
        this.materiaDB.add(matematica2);
        this.materiaDB.add(matematica3);
        this.materiaDB.add(ingles1);
        this.materiaDB.add(ingles2);


    }

    @Override
    public Materia findByCodigo(String codigoMateria) {
        Materia materia = null;
        for(Materia materiaResult : this.materiaDB){
            if(materiaResult.getCodigoMateria().equals(codigoMateria)){
                materia = materiaResult;
                break;
            }
        }
        return materia;
    }

    @Override
    public List<Materia> findAll() {
        return this.materiaDB;
    }

    @Override
    public void save(Materia materia) {
        for(Materia materiaResult : this.materiaDB){
            if(materiaResult.getCodigoMateria().equals(materia.getCodigoMateria())){
                return;
            }
        }
        this.materiaDB.add(materia);
    }

    @Override
    public void update(Materia materia) {
        for(Materia materiaResult : this.materiaDB ){
            if(materiaResult.getCodigoMateria().equals(materia.getCodigoMateria())){
                materiaResult.setNombre(materia.getNombre());
                materiaResult.setAnio(materia.getAnio());
                return;
            }
        }
    }

    @Override
    public void delete(Materia materia) {
        for(Materia materiaResult : this.materiaDB){
            if(materiaResult.getCodigoMateria().equals(materia.getCodigoMateria())){
                materiaResult.setActivo(false);
                return;
            }
        }
    }
}




