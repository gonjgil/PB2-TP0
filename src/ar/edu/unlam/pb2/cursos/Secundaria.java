package ar.edu.unlam.pb2.cursos;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ar.edu.unlam.pb2.enums.Competencias;
import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.excepciones.NivelNoPermitidoException;
import ar.edu.unlam.pb2.personas.Alumno;
import ar.edu.unlam.pb2.personas.Docente;

public class Secundaria extends Curso {

    private Map<Competencias, Docente> materias;
    
    public Secundaria(Niveles salon) throws NivelNoPermitidoException {
	super(salon);
	this.materias = new TreeMap<Competencias, Docente>(); 
	DOCENTES_MAX = COMPETENCIAS_REQUERIDAS.size();
	COMPETENCIAS_REQUERIDAS = Set.of(Competencias.MATERIA_1, Competencias.MATERIA_2, Competencias.MATERIA_3, Competencias.MATERIA_4, Competencias.MATERIA_5, Competencias.MATERIA_6, Competencias.MATERIA_7);
    }

    @Override
    public Boolean validarEdad(Alumno alumno) throws EdadNoPermitidaException {
	boolean resultado = false;
	if (alumno.getEdad() >= this.edadRequerida() && alumno.getEdad() < 18) {
	    resultado = true;
	} else {
	    throw new EdadNoPermitidaException("No tiene la edad adecuada para inscribirse en Secundaria");
	}
	return resultado;
    }

    @Override
    public Boolean validarNivel(Alumno alumno) throws NivelInvalidoException {
	boolean resultado = false;
	if (alumno.getNivelAprobado().equals(nivelRequeridoPorEdad())) {
	    resultado = true;
	} else {
	    throw new NivelInvalidoException("El alumno no tiene el nivel adecuado para inscribirse a este curso");
	}
	return resultado;
    }
    

// NOTE no es override porque sobrecarga el metodo al agregar la materia
    public void agregarDocente(Docente docente, Competencias materia) {
	if (docente.getCompetencias().contains(materia)) {
	    docentes.add(docente);
	    materias.put(materia, docente);
	}
    }

}
