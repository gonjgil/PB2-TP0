package ar.edu.unlam.pb2.educacion;

public class Jardin extends Curso {

    public Jardin(Nivel salon) {
	super(salon);
	this.DOCENTES_MAX = 2;
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
	if (!esMismoAlumno(alumno)) {
	    if (alumno.getEdad() >= 2 && alumno.getEdad() <= 5) {
		alumnos.add(alumno);
	    }
	}
    }

    /* ver si esta es la forma adecuada para evitar que un alumno de jardin sea evaluado */
    @Override
    public void evaluarAlumno(Alumno alumno, Docente docente, Integer nota) {
	return;
    }

}
