	package ar.edu.unlam.pb2.cursos;

import ar.edu.unlam.pb2.enums.Nivel;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.personas.Alumno;
import ar.edu.unlam.pb2.personas.Docente;

public class Jardin extends Curso {

    public Jardin(Nivel salon) {
	super(salon);
	this.DOCENTES_MAX = 2;
    }

    @Override
    public Boolean validarEdad(Alumno alumno) throws EdadNoPermitidaException {
	Boolean resultado = false;
	if (alumno.getEdad() >= 2 && alumno.getEdad() <= 5) {
	    resultado = true;
	} else {
	    throw new EdadNoPermitidaException("No tiene la edad adecuada para inscribirse en esta salita");
	}
	return resultado;
    }
    
    @Override
    public Boolean validarNivel(Alumno alumno) {
	return true;
    }
    
// PREGUNTAR ver si esta es la forma adecuada para evitar que un alumno de jardin sea evaluado (un metodo void en la clase heredada)
    @Override
    public void evaluarAlumno(Alumno alumno, Docente docente, Integer nota) {
    }

}
