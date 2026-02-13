package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.Profesor;
import ar.com.practicaproyecto.repository.ProfesorRepository;

import java.util.ArrayList;
import java.util.List;

public class ProfesorRepositoryImpl implements ProfesorRepository {
    private final List<Profesor> profesoresDb;

    public ProfesorRepositoryImpl(){
        this.profesoresDb = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos(){
        Profesor profesor1 = new Profesor("10101010", "Carlos", "Ramírez", "3764001001", "carlosramirez@gmail.com");
        Profesor profesor2 = new Profesor("20202020", "María", "Benítez", "3764002002", "mariabenitez@gmail.com");
        Profesor profesor3 = new Profesor("30303030", "Jorge", "Sosa", "3764003003", "jorgesosa@gmail.com");
        Profesor profesor4 = new Profesor("40404040", "Ana", "Gutiérrez", "3764004004", "anagutierrez@gmail.com");
        Profesor profesor5 = new Profesor("50505050", "Ricardo", "Martínez", "3764005005", "ricardomartinez@gmail.com");
        Profesor profesor6 = new Profesor("60606060", "Sofía", "Acosta", "3764006006", "sofiaacosta@gmail.com");
        Profesor profesor7 = new Profesor("70707070", "Hernán", "Cáceres", "3764007007", "hernancaceres@gmail.com");
        Profesor profesor8 = new Profesor("80808080", "Laura", "Fernández", "3764008008", "laurafernandez@gmail.com");
        Profesor profesor9 = new Profesor("90909090", "Diego", "López", "3764009009", "diegolopez@gmail.com");
        Profesor profesor10 = new Profesor("11223344", "Paula", "Ríos", "3764010010", "paularios@gmail.com");

        this.profesoresDb.add(profesor1);
        this.profesoresDb.add(profesor2);
        this.profesoresDb.add(profesor3);
        this.profesoresDb.add(profesor4);
        this.profesoresDb.add(profesor5);
        this.profesoresDb.add(profesor6);
        this.profesoresDb.add(profesor7);
        this.profesoresDb.add(profesor8);
        this.profesoresDb.add(profesor9);
        this.profesoresDb.add(profesor10);

    }


    @Override
    public Profesor findByDni(String dni) {
        Profesor profesor = null;
        for(Profesor profesorResult : this.profesoresDb){
            if(profesorResult.getDni().equals(dni)){
                profesor = profesorResult;
                break;
            }
        }
        return profesor;
    }

    @Override
    public List<Profesor> findAll() {
        return this.profesoresDb;
    }

    @Override
    public void save(Profesor profesor) {
        for(Profesor profesorResult: this.profesoresDb){
            if (profesorResult.getDni().equals(profesorResult.getDni())){
                return;
            }
        }
        profesoresDb.add(profesor);
    }

    @Override
    public void update(Profesor profesor) {
        for(Profesor profesorResult: this.profesoresDb){
            if(profesorResult.getDni().equals(profesor.getDni())){
                profesorResult.setNombre(profesor.getNombre());
                profesorResult.setApellido(profesor.getApellido());
                profesorResult.setTelefono(profesor.getTelefono());
                profesorResult.setEmail(profesor.getEmail());
                return;
            }
        }
    }

    @Override
    public void delete(Profesor profesor) {
        for(Profesor profesorResult : this.profesoresDb){
            if(profesorResult.getDni().equals(profesor.getDni())){
                profesorResult.setActivo(false);
                return;
            }

        }
    }
}
