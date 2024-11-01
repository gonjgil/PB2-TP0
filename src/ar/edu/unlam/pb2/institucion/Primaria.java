package ar.edu.unlam.pb2.institucion;

import java.util.Set;

import ar.edu.unlam.pb2.enums.Competencias;
import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.excepciones.NivelNoPermitidoException;
import ar.edu.unlam.pb2.personas.Alumno;

public class Primaria extends Curso {

    public Primaria(Niveles salon) throws NivelNoPermitidoException {
	super(salon);
	DOCENTES_MAX = 1;
	COMPETENCIAS_REQUERIDAS = Set.of(Competencias.PRIMERO, Competencias.SEGUNDO, Competencias.TERCERO, Competencias.CUARTO, Competencias.QUINTO, Competencias.SEXTO);
    }

    @Override
    public Boolean validarEdad(Alumno alumno) throws EdadNoPermitidaException {
	boolean resultado = false;
	if (alumno.getEdad() == this.edadRequerida() || alumno.getEdad() == this.edadRequerida() + 1) {
	    resultado = true;
	} else {
	    throw new EdadNoPermitidaException(alumno.getNombre() + " no tiene la edad adecuada para inscribirse en Secundaria");
	}
	return resultado;
    }

    @Override
    public Boolean validarNivel(Alumno alumno) throws NivelInvalidoException {
	boolean resultado = false;
	if (alumno.getNivelAprobado().equals(nivelRequeridoPorEdad()) || (this.salon == Niveles.PRIMERO_P && estaEscolarizado(alumno))) {
	    resultado = true;
	} else {
	    throw new NivelInvalidoException(alumno.getNombre() + " no tiene el nivel adecuado para inscribirse a este salon");
	}
	return resultado;
    }

    public Boolean estaEscolarizado(Alumno alumno) {
	Set<Niveles> inicial = Set.of(Niveles.NINGUNO, Niveles.AZUL, Niveles.CELESTE, Niveles.ROJO, Niveles.VERDE);
	return inicial.contains(alumno.getNivelAprobado());
    }

}
