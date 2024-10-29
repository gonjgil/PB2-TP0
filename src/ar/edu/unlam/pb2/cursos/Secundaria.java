package ar.edu.unlam.pb2.cursos;

import ar.edu.unlam.pb2.enums.Competencias;
import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.personas.Alumno;
import ar.edu.unlam.pb2.personas.Docente;

public class Secundaria extends Curso {

    private static final Competencias[] MATERIAS = { Competencias.MATERIA_1, Competencias.MATERIA_2, Competencias.MATERIA_3, Competencias.MATERIA_4,
	    Competencias.MATERIA_5, Competencias.MATERIA_6, Competencias.MATERIA_7 };

    public Secundaria(Niveles salon) {
	super(salon);
    }

    @Override
    public Boolean validarEdad(Alumno alumno) throws EdadNoPermitidaException {
	Boolean resultado = false;
	if (alumno.getEdad() >= this.edadRequerida() && alumno.getEdad() < 18) {
	    resultado = true;
	} else {
	    throw new EdadNoPermitidaException("No tiene la edad adecuada para inscribirse en Secundaria");
	}
	return resultado;
    }
    
    @Override
    public Boolean validarNivel(Alumno alumno) throws NivelInvalidoException {
	Boolean resultado = false;
	if (alumno.getNivelAprobado().equals(nivelRequeridoPorEdad())) {
	    resultado = true;
	} else {
	    throw new NivelInvalidoException("El alumno no tiene el nivel adecuado para inscribirse a este curso");
	}
	return resultado;
    }

// NOTE no es Override porque sobrecarga el metodo
    public void agregarDocente(Docente docente, Competencias materia) {
	if (docente.getCompetencias().contains(materia))
	    docentes.add(docente);
    }

}
