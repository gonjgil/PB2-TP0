package ar.edu.unlam.pb2.cursos;

import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.personas.Alumno;

public class Primaria extends Curso {

	public Primaria(Niveles salon) {
		super(salon);
		this.DOCENTES_MAX = 1;
	}

	@Override
	public Boolean validarEdad(Alumno alumno) throws EdadNoPermitidaException {
		Boolean resultado = false;
		if (alumno.getEdad() == this.edadRequerida() || alumno.getEdad() == this.edadRequerida() + 1) {
			resultado = true;
		} else {
			throw new EdadNoPermitidaException("No tiene la edad adecuada para inscribirse en Secundaria");
		}
		return resultado;
	}

	@Override
	public Boolean validarNivel(Alumno alumno) throws NivelInvalidoException {
		Boolean resultado = false;
		if (alumno.getNivelAprobado().equals(nivelRequeridoPorEdad())
				|| (this.salon == Niveles.PRIMERO_P && estaEscolarizado(alumno))) {
			resultado = true;
		} else {
			throw new NivelInvalidoException("El alumno no tiene el nivel adecuado para inscribirse a este salon");
		}
		return resultado;
	}

	public Boolean estaEscolarizado(Alumno alumno) {
		Boolean sinEscolarizar = false;
		if (alumno.getNivelAprobado() == Niveles.NINGUNO || alumno.getNivelAprobado() == Niveles.AZUL
				|| alumno.getNivelAprobado() == Niveles.CELESTE || alumno.getNivelAprobado() == Niveles.ROJO
				|| alumno.getNivelAprobado() == Niveles.VERDE) {
			sinEscolarizar = true;
			return sinEscolarizar;
		}
		return sinEscolarizar;
	}

}
