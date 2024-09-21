package ar.edu.unlam.pb2.educacion;

public class Jardin extends Curso {

    public Jardin(Nivel salon) {
	super(salon);
	this.DOCENTES_MAX = 2; /* cambiar esta logica */
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
	if (!esMismoAlumno(alumno)) {
	    if (alumno.getEdad() >= 2 && alumno.getEdad() <= 5) {
		alumnos.add(alumno);
	    }
	}
    }

}
