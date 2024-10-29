package ar.edu.unlam.pb2.educacion;

public class Jardin extends Curso {

    public Jardin(Nivel salon) {
	super(salon);
	this.DOCENTES_MAX = 2;
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
	if (!alumnos.contains(alumno)) {
	    if (alumno.getEdad() >= 2 && alumno.getEdad() <= 5) {
		alumnos.add(alumno);
	    }
	}
    }

// PREGUNTAR ver si esta es la forma adecuada para evitar que un alumno de jardin sea evaluado (un metodo void en la clase heredada)
    @Override
    public void evaluarAlumno(Alumno alumno, Docente docente, Integer nota) {
    }

}
