package ar.edu.unlam.pb2.personas;

import java.util.Comparator;

public class OrdenDeAlumnosPorNombre implements Comparator<Alumno>{
    
    public OrdenDeAlumnosPorNombre() {
    }

    @Override
    public int compare(Alumno alumno1, Alumno alumno2) {
	 return alumno1.getNombre().compareTo(alumno2.getNombre());
    }

}
