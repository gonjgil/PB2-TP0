package ar.edu.unlam.pb2.cursos;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.pb2.excepciones.NivelNoPermitidoException;

public class Institucion {

    private List<Curso> salones;

    public Institucion() {
	this.salones = new LinkedList<>();
    }

    public String evaluarInstancia(Curso curso) {
	String instancia = "";
	switch (curso.getSalon()) {
	case AZUL, CELESTE, ROJO, VERDE:
	    instancia = "Jardin";
	    break;
	case PRIMERO_P, SEGUNDO_P, TERCERO_P, CUARTO_P, QUINTO_P, SEXTO_P:
	    instancia = "Primaria";
	    break;
	case PRIMERO_S, SEGUNDO_S, TERCERO_S, CUARTO_S, QUINTO_S, SEXTO_S:
	    instancia = "Secundaria";
	    break;
	default:
	}
	return instancia;
    }

    public Boolean agregarCurso(Curso curso) throws NivelNoPermitidoException {
	Boolean resultado = false;
	if (curso instanceof Jardin && evaluarInstancia(curso) == "Jardin") {
	    salones.add((Jardin) curso);
	    resultado = true;
	} else if (curso instanceof Primaria && evaluarInstancia(curso) == "Primaria") {
	    salones.add((Primaria) curso);
	    resultado = true;
	} else if (curso instanceof Secundaria && evaluarInstancia(curso) == "Secundaria") {
	    salones.add((Secundaria) curso);
	    resultado = true;
	} else
	    throw new NivelNoPermitidoException("El nivel no corresponde a Jardin");
	return resultado;
    }

    public List<Curso> getSalones() {
	return salones;
    }
}
