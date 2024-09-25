package ar.edu.unlam.pb2.educacion;

import java.util.LinkedList;
import java.util.List;

public abstract class Curso {

    protected Nivel salon;
    protected List<Docente> docentes;
    protected List<Alumno> alumnos;
    protected static Integer DOCENTES_MAX;

    public Curso(Nivel salon) {
	this.salon = salon;
	this.docentes = new LinkedList<Docente>();
	this.alumnos = new LinkedList<Alumno>();
    }

    public void evaluarAlumno(Alumno alumno, Docente docente, Integer nota) {
	if (nota >= 1 || nota <= 10) {
	    if (docente.getCompetencias().contains(competenciaRequerida())) { 
		for (int i = 0; i < alumnos.size(); i++) {
		    alumnos.get(i).setEvaluacion(nota);
		}
	    }
	}
    }

    // PREGUNTAR ver si es necesario asi vacio, ya que todos tienen override
    public void agregarAlumno(Alumno alumno) {
    }

    public void agregarDocente(Docente docente) {
	if (!esMismoDocente(docente)) {
	    if (this.docentes.size() != DOCENTES_MAX && docente.getCompetencias().contains(competenciaRequerida())) {
		docentes.add(docente);
	    }
	}
    }

    public Integer edadRequerida() {
	Integer edad = 0;
	switch (salon) {
	case CELESTE:
	    edad = 2;
	    break;
	case VERDE:
	    edad = 3;
	    break;
	case AZUL:
	    edad = 4;
	    break;
	case ROJO:
	    edad = 5;
	    break;
	case PRIMERO_P:
	    edad = 6;
	    break;
	case SEGUNDO_P:
	    edad = 7;
	    break;
	case TERCERO_P:
	    edad = 8;
	    break;
	case CUARTO_P:
	    edad = 9;
	    break;
	case QUINTO_P:
	    edad = 10;
	    break;
	case SEXTO_P:
	    edad = 11;
	    break;
	case PRIMERO_S:
	    edad = 12;
	    break;
	case SEGUNDO_S:
	    edad = 13;
	    break;
	case TERCERO_S:
	    edad = 14;
	    break;
	case CUARTO_S:
	    edad = 15;
	    break;
	case QUINTO_S:
	    edad = 16;
	    break;
	case SEXTO_S:
	    edad = 17;
	    break;
	default:
	    break;
	}
	return edad;
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

    public Nivel nivelRequeridoPorEdad() {
	Nivel[] niveles = Nivel.values();
//	System.out.println(Arrays.toString(niveles));
	Nivel requerido = null;
	for (int i = 1; i < Nivel.values().length; i++) {
	    if (this.salon.equals(niveles[i])) {
		requerido = niveles[i - 1];
	    }
	}
	return requerido;
    }

// PREGUNTAR ver como unir estos dos metodos

    public Boolean esMismoDocente(Docente docente) {
	Boolean esMismo = false;
	for (int i = 0; i < docentes.size(); i++) {
	    if (docentes.get(i).equals(docente)) {
		esMismo = true;
		return esMismo;
	    }
	}
	return esMismo;
    }

    public Nivel getSalon() {
	return salon;
    }

    public List<Docente> getDocentes() {
	return docentes;
    }

    public List<Alumno> getAlumnos() {
	return alumnos;
    }
}