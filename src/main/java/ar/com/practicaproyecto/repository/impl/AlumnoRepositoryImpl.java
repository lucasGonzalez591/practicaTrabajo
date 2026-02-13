package ar.com.practicaproyecto.repository.impl;

import ar.com.practicaproyecto.model.Alumno;
import ar.com.practicaproyecto.repository.AlumnoRepository;

import java.util.ArrayList;
import java.util.List;

public class AlumnoRepositoryImpl implements AlumnoRepository {
    private final List<Alumno> alumnosDB;

    public AlumnoRepositoryImpl(){
        this.alumnosDB = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos(){
        Alumno alumno1 = new Alumno("11111111", "Mauro", "Britez", "3764208778", "maurobritez@gmail.com");
        Alumno alumno2 = new Alumno("22222222", "Lucas", "Gonzales", "3764102030", "lucasgonzales@gmail.com");
        Alumno alumno3 = new Alumno("33333333", "Luciano", "Garayo", "3764111111", "lucianogarayo@gmail.com");
        Alumno alumno4 = new Alumno("44444444", "Mauro", "Gavilan", "3764222222", "maurogavilan@gmail.com");
        Alumno alumno5 = new Alumno("55555555", "Efrain", "Godoy", "3765333333", "efraingodoy@gmail.com");

        this.alumnosDB.add(alumno1);
        this.alumnosDB.add(alumno2);
        this.alumnosDB.add(alumno3);
        this.alumnosDB.add(alumno4);
        this.alumnosDB.add(alumno5);

    }

    @Override
    public Alumno findByDni(String dni) {
       Alumno alumno = null;
       for(Alumno alumnoResult : this.alumnosDB){
           if(alumnoResult.getDni().equals(dni)){
               alumno = alumnoResult;
               break;
           }
       }
       return alumno;
    }

    @Override
    public List<Alumno> findAll() {
        return this.alumnosDB;
    }

    @Override
    public void save(Alumno alumno) {
        for(Alumno alumnoResult : this.alumnosDB){
            if(alumnoResult.getDni().equals(alumno.getDni())){
                return;
            }
        }
        alumnosDB.add(alumno);
    }

    @Override
    public void update(Alumno alumno) {
        for(Alumno alumnoResult : this.alumnosDB){
            if(alumnoResult.getDni().equals(alumno.getDni())){
                alumnoResult.setNombre(alumno.getNombre());
                alumnoResult.setApellido(alumno.getApellido());
                alumnoResult.setTelefono(alumno.getTelefono());
                alumnoResult.setEmail(alumno.getEmail());
                return;

            }
        }
    }

    @Override
    public void delete(Alumno alumno) {
        for(Alumno alumnoResult: this.alumnosDB){
            if(alumnoResult.getDni().equals(alumno.getDni())){
                alumnoResult.setActivo(false);
                return;
            }
            }
        }
    }








/*


}*/
