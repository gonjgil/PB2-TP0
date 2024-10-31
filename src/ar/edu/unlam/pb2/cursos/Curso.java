package ar.edu.unlam.pb2.cursos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.enums.Competencias;
import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.AlumnoInscriptoException;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.excepciones.NivelNoPermitidoException;
import ar.edu.unlam.pb2.excepciones.NoEvaluableException;
import ar.edu.unlam.pb2.interfaces.Validaciones;
import ar.edu.unlam.pb2.personas.Alumno;
import ar.edu.unlam.pb2.personas.Docente;
import ar.edu.unlam.pb2.personas.OrdenDeAlumnosPorNombre;

public abstract class Curso implements Validaciones {

    protected Niveles salon;
    protected Set<Docente> docentes;
    protected Set<Alumno> alumnos;
    protected static Set<Competencias> COMPETENCIAS_REQUERIDAS;
    protected static Set<Niveles> NIVELES_PERMITIDOS;
    protected static Integer DOCENTES_MAX;

    public Curso(Niveles salon) {
	this.salon = salon;
	this.docentes = new HashSet<>();
	this.alumnos = new HashSet<>();
	this.COMPETENCIAS_REQUERIDAS = new TreeSet<Competencias>();
    }

    public void agregarDocente(Docente docente) {
	if (!docentes.contains(docente)) {
	    if (this.docentes.size() != DOCENTES_MAX && docente.getCompetencias().contains(competenciaRequerida())) {
		docentes.add(docente);
	    }
	}
    }

    public void inscribirAlumno(Alumno alumno) throws AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException {
	if (alumnos.contains(alumno)) {
	    throw new AlumnoInscriptoException("El alumno ya esta inscripto");
	} else if (validarEdad(alumno) && validarNivel(alumno)) {
	    alumnos.add(alumno);
	}
    }

    // NOTE rehacer
    public void evaluarAlumno(Alumno alumno, Docente docente, Integer nota) throws NoEvaluableException {
	if (nota >= 1 && nota <= 10 && docente.getCompetencias().contains(competenciaRequerida())) {
	    alumno.setEvaluacion(nota);
	}
    }

    public Integer edadRequerida() {
	return salon.getEdadRequerida();
    }

// PREGUNTAR como solo se usa localmente, esta bien asignarlo privado?
    private Competencias competenciaRequerida() {
	Competencias requerida = null;
	switch (this.salon) {
	case CELESTE, VERDE, AZUL, ROJO:
	    requerida = Competencias.MAESTRX_JARDINERX;
	    break;
	case PRIMERO_P:
	    requerida = Competencias.PRIMERO;
	    break;
	case SEGUNDO_P:
	    requerida = Competencias.SEGUNDO;
	    break;
	case TERCERO_P:
	    requerida = Competencias.TERCERO;
	    break;
	case CUARTO_P:
	    requerida = Competencias.CUARTO;
	    break;
	case QUINTO_P:
	    requerida = Competencias.QUINTO;
	    break;
	case SEXTO_P:
	    requerida = Competencias.SEXTO;
	    break;
	default:
	    requerida = null;
	    break;
	}
	return requerida;
    }

    // NOTE refactorizar
    public Niveles nivelRequeridoPorEdad() {
	Niveles[] niveles = Niveles.values();
//	System.out.println(Arrays.toString(niveles));
	Niveles requerido = null;
	for (int i = 1; i < Niveles.values().length; i++) {
	    if (this.salon.equals(niveles[i])) {
		requerido = niveles[i - 1];
	    }
	}
	return requerido;
    }

    public Niveles getSalon() {
	return salon;
    }

    public Set<Docente> getDocentes() {
	return docentes;
    }

    public Set<Alumno> getAlumnos() {
	return alumnos;
    }

    // alumnos ordenados por nombre
    public Set<Alumno> getAlumnosOrdenadosPorDni() {
	Set<Alumno> alumnosOrdenados = new TreeSet<Alumno>();
	alumnosOrdenados.addAll(alumnos);
	return alumnosOrdenados;
    }

    // alumnos ordenados por dni
    public Set<Alumno> getAlumnosOrdenadosPorNombre() {
	Set<Alumno> alumnosOrdenados = new TreeSet<Alumno>(new OrdenDeAlumnosPorNombre());
	alumnosOrdenados.addAll(alumnos);
	return alumnosOrdenados;
    }
}