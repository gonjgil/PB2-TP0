package ar.edu.unlam.pb2.institucion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.pb2.excepciones.AlumnoNoEncontradoException;
import ar.edu.unlam.pb2.excepciones.NivelNoPermitidoException;
import ar.edu.unlam.pb2.personas.Alumno;

public class Institucion {

    private List<Curso> salones;

    public Institucion() {
	this.salones = new LinkedList<>();
    }

    public Alumno buscarAlumno(Integer dni) throws AlumnoNoEncontradoException {
	for (Curso curso : salones) {
	    for (Alumno alumno : curso.getAlumnos()) {
		if (alumno.getDni().equals(dni)) {
		    return alumno;
		}
	    }
	}
	throw new AlumnoNoEncontradoException("El alumno no fue encontrado");
    }

    public String evaluarNivel(Curso curso) {
	String nivel = "";
	switch (curso.getSalon()) {
	case AZUL, CELESTE, ROJO, VERDE:
	    nivel = "Jardin";
	    break;
	case PRIMERO_P, SEGUNDO_P, TERCERO_P, CUARTO_P, QUINTO_P, SEXTO_P:
	    nivel = "Primaria";
	    break;
	case PRIMERO_S, SEGUNDO_S, TERCERO_S, CUARTO_S, QUINTO_S, SEXTO_S:
	    nivel = "Secundaria";
	    break;
	default:
	}
	return nivel;
    }

    public Boolean agregarCurso(Curso curso) throws NivelNoPermitidoException {
	Boolean resultado = false;
	if (curso instanceof Jardin && evaluarNivel(curso) == "Jardin") {
	    salones.add((Jardin) curso);
	    resultado = true;
	} else if (curso instanceof Primaria && evaluarNivel(curso) == "Primaria") {
	    salones.add((Primaria) curso);
	    resultado = true;
	} else if (curso instanceof Secundaria && evaluarNivel(curso) == "Secundaria") {
	    salones.add((Secundaria) curso);
	    resultado = true;
	} else
	    throw new NivelNoPermitidoException("El nivel no corresponde");
	return resultado;
    }

    public List<Curso> getSalones() {
	return salones;
    }
}
