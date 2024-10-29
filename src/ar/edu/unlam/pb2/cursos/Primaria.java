package ar.edu.unlam.pb2.educacion;

public class Primaria extends Curso {

    public Primaria(Nivel salon) {
	super(salon);
	this.DOCENTES_MAX = 1;
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
	if (!alumnos.contains(alumno)) {
	    if ((alumno.getEdad() == this.edadRequerida() || alumno.getEdad() == this.edadRequerida() + 1)
		    && ((this.salon == Nivel.PRIMERO_P && sinEscolarizar(alumno)) || alumno.getNivelAprobado().equals(nivelRequeridoPorEdad()))) {
		alumnos.add(alumno);
	    }
	}
    }

    public Boolean sinEscolarizar(Alumno alumno) {
	Boolean sinEscolarizar = false;
	if (alumno.getNivelAprobado() == Nivel.NINGUNO || alumno.getNivelAprobado() == Nivel.AZUL || alumno.getNivelAprobado() == Nivel.CELESTE
		|| alumno.getNivelAprobado() == Nivel.ROJO || alumno.getNivelAprobado() == Nivel.VERDE) {
	    sinEscolarizar = true;
	    return sinEscolarizar;
	}
	return sinEscolarizar;
    }

}
