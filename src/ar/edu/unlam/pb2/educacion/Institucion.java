package ar.edu.unlam.pb2.educacion;

public class Institucion {

    private String nombreInstitucion;
    private Curso[] cursos;
    private final static int CANTIDAD_DE_CURSOS = 16;

    public Institucion(String nombreInstitucion) {
	this.nombreInstitucion = nombreInstitucion;
	this.cursos = new Curso[CANTIDAD_DE_CURSOS];
    }

    public void crearCursos() {
	for (Salon salon : Salon.values()) {
	    cursos[salon.ordinal()] = new Curso(salon);
	}
    }

    public Curso buscarSalon(Salon tipoSalon) {
	Curso buscado = null;
	for (int i = 0; i < cursos.length; i++) {
	    if (cursos[i] != null && cursos[i].getSalon() == tipoSalon) {
		buscado = cursos[i];
		return buscado;
	    }
	}
	return buscado;
    }

    public Curso buscarCursoPorEdades(Integer edad) {
	Curso buscado = null;
	Salon tipoCurso = null;
	switch (edad) {
	case 2:
	    tipoCurso = Salon.CELESTE;
	    break;
	case 3:
	    tipoCurso = Salon.VERDE;
	    break;
	case 4:
	    tipoCurso = Salon.AZUL;
	    break;
	case 5:
	    tipoCurso = Salon.ROJO;
	    break;
	case 6:
	    tipoCurso = Salon.PRIMERO_P;
	    break;
	case 7:
	    tipoCurso = Salon.SEGUNDO_P;
	    break;
	case 8:
	    tipoCurso = Salon.TERCERO_P;
	    break;
	case 9:
	    tipoCurso = Salon.CUARTO_P;
	    break;
	case 10:
	    tipoCurso = Salon.QUINTO_P;
	    break;
	case 11:
	    tipoCurso = Salon.SEXTO_P;
	    break;
	case 12:
	    tipoCurso = Salon.PRIMERO_S;
	    break;
	case 13:
	    tipoCurso = Salon.SEGUNDO_S;
	    break;
	case 14:
	    tipoCurso = Salon.TERCERO_S;
	    break;
	case 15:
	    tipoCurso = Salon.CUARTO_S;
	    break;
	case 16:
	    tipoCurso = Salon.QUINTO_S;
	    break;
	case 17:
	    tipoCurso = Salon.SEXTO_S;
	    break;
	default:
	    tipoCurso = null;
	}
	buscado = buscarSalon(tipoCurso);
	return buscado;
    }

    // falta armar condiciones para primaria y secundaria (hacer un metodo aparte?)
    public void asignarDocente(Docente nuevo) {
	int contador = 0;
	for (Curso curso : cursos) {
	    contador++;
	    switch (curso.getNivel()) {
	    case JARDIN:
		if (nuevo.getCompetenciaMaxima() == Competencias.MAESTRX
			|| nuevo.getCompetenciaMaxima() == Competencias.MAESTRX_JARDINERX) {
		    for (int i = 0; i < cursos.length; i++) {
			cursos[contador].agregarDocente(nuevo);
		    }
		}
		break;
	    case PRIMARIA:
		cursos[contador].agregarDocente(nuevo);
		break;
	    case SECUNDARIA:
		cursos[contador].agregarDocente(nuevo);
		break;
	    default:
		break;
	    }
	}
    }

    /* buscarCursoAdecuado */

    /* inscribirAlumno */
    
    public String getNombreInstitucion() {
	return nombreInstitucion;
    }

}