package ar.edu.unlam.pb2.institucion;

import java.util.Set;

import ar.edu.unlam.pb2.enums.Competencias;
import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelNoPermitidoException;
import ar.edu.unlam.pb2.excepciones.NoEvaluableException;
import ar.edu.unlam.pb2.personas.Alumno;
import ar.edu.unlam.pb2.personas.Docente;

public class Jardin extends Curso {

	public Jardin(Niveles salon) {
		super(salon);
		DOCENTES_MAX = 2;
		COMPETENCIAS_REQUERIDAS = Set.of(Competencias.MAESTRX_JARDINERX);
	}

	@Override
	public Boolean validarEdad(Alumno alumno) throws EdadNoPermitidaException {
		boolean resultado = false;
		if (alumno.getEdad() >= 2 && alumno.getEdad() <= 5) {
			resultado = true;
		} else {
			throw new EdadNoPermitidaException(alumno.getNombre() + " no tiene la edad adecuada para inscribirse en esta salita");
		}
		return resultado;
	}

	@Override
	public Boolean validarNivel(Alumno alumno) {
		return true;
	}

	@Override
	public void evaluarAlumno(Alumno alumno, Docente docente, Integer nota) throws NoEvaluableException {
	    throw new NoEvaluableException("El alumnado de Jardin no es evaluable");
	}

}
