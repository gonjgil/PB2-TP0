package ar.edu.unlam.pb2.educacion;

public class Curso {

    private Salon salon;
    private Nivel nivel;
    private Docente[] docentes;
    private Alumno[] alumnos;
    private final static int ALUMNOS_MAX = 25;
    
    public Curso(Salon salon) {
	this.salon = salon;
	this.nivel = asignarNivel();
	this.docentes = new Docente[cantidadDocentes()];
	this.alumnos = new Alumno[ALUMNOS_MAX];
    }
    
    public Boolean agregarDocente(Docente docente) {
	Boolean resultado = Boolean.FALSE;
	for (Docente cada : docentes) {
	    if (cada != null && cada.equals(docente)) {
		resultado = Boolean.FALSE;
		return resultado;
	    }
	    for (int i = 0; i < docentes.length; i++) {
		if (docentes[i] == null) {
		    docentes[i] = docente;
		    resultado = Boolean.TRUE;
		    return resultado;
		}
	    }
	}
	return resultado;
    }
    
    public boolean agregarAlumno(Alumno alumno) {
	for (Alumno cada : alumnos) {
	    if (cada != null && cada.equals(alumno)) {
		return false;
	    }
	    for (int i = 0; i < alumnos.length; i++) {
		if (alumnos[i] == null) {
		    alumnos[i] = alumno;
		    return true;
		}
	    }
	}
	return false;
    }
    
    public Docente buscarDocente(Integer dni) {
	Docente buscado = null;
	for(int i = 0; i < docentes.length; i++) {
	    buscado = docentes[i];
	    return buscado;
	}
	return buscado;
    }

    public Alumno buscarAlumno(Integer dni) {
	Alumno buscado = null;
	for (Alumno alumnos : alumnos) {
	    buscado = alumnos;
	}
	return buscado;
    }

    public Salon preAsignarSalon(Alumno alumno) {
	Salon preAsignación = null;
	switch (alumno.getEdad()){
	case 2:
	    preAsignación = Salon.CELESTE;
	    break;
	case 3:
	    preAsignación = Salon.VERDE;
	    break;
	case 4:
	    preAsignación = Salon.AZUL;
	    break;
	case 5:
	    preAsignación = Salon.ROJO;
	    break;
	case 6:
	    preAsignación = Salon.PRIMERO_P;
	    break;
	case 7:
	    preAsignación = Salon.SEGUNDO_P;
	    break;
	case 8:
	    preAsignación = Salon.TERCERO_P;
	    break;
	case 9:
	    preAsignación = Salon.CUARTO_P;
	    break;
	case 10:
	    preAsignación = Salon.QUINTO_P;
	    break;
	case 11:
	    preAsignación = Salon.SEXTO_P;
	    break;
	case 12:
	    preAsignación = Salon.PRIMERO_S;
	    break;
	case 13:
	    preAsignación = Salon.SEGUNDO_S;
	    break;
	case 14:
	    preAsignación = Salon.TERCERO_S;
	    break;
	case 15:
	    preAsignación = Salon.CUARTO_S;
	    break;
	case 16:
	    preAsignación = Salon.QUINTO_S;
	    break;
	case 17:
	    preAsignación = Salon.SEXTO_S;
	    break;
	    default: preAsignación = null;
	}
	return preAsignación;
    }
    
    public Boolean definirSalon() {
	return Boolean.FALSE;
    }
    
    private Nivel asignarNivel() {
	Nivel nivelAsignado = null;
	switch(salon) {
	case CELESTE, VERDE, AZUL, ROJO:
	    nivelAsignado = Nivel.JARDIN;
	break;
	case PRIMERO_P, SEGUNDO_P, TERCERO_P, CUARTO_P, QUINTO_P, SEXTO_P:
	    nivelAsignado = Nivel.PRIMARIA;
	break;
	case PRIMERO_S, SEGUNDO_S, TERCERO_S, CUARTO_S, QUINTO_S, SEXTO_S:
	    nivelAsignado = Nivel.SECUNDARIA;
	break;
	default: 
	    nivelAsignado = null;
	}
	return nivelAsignado;
    }

    private int cantidadDocentes() {
	int cantidad = 0;
	switch (this.nivel) {
	case JARDIN:
	    cantidad = 2;
	    break;
	case PRIMARIA:
	    cantidad = 1;
	    break;
	case SECUNDARIA:
	    cantidad = 12;
	    break;
	}
	return cantidad;
    }

    public Docente[] obtenerListadoDeDocentessOrdenadosPorNombre() {
	Docente [] docentesOrdenado;
	docentesOrdenado = new Docente[docentes.length];
	for (int i = 0; i < docentes.length; i++) {
	    docentesOrdenado[i] = docentes[i];
	}
	for (int i = 0; i < docentes.length - 1; i++) {
	    for (int j = 0; j < (docentesOrdenado.length - i - 1); j++) {
		if  (docentesOrdenado[j]!=null && docentesOrdenado[j+1]!=null && docentesOrdenado[j].getNombre().compareTo(docentesOrdenado[j+1].getNombre()) > 0 ) {
		    Docente aux = docentesOrdenado[j];
		    docentesOrdenado[j] = docentesOrdenado[j+1];
		    docentesOrdenado[j+1] = aux;
		}
	    }
	}
	return docentesOrdenado;
    }

    
    public Alumno[] obtenerListadoDeAlumnosOrdenadosPorNombre() {
	Alumno [] alumnosOrdenado;
	alumnosOrdenado = new Alumno[alumnos.length];
	for (int i = 0; i < alumnos.length; i++) {
	    alumnosOrdenado[i] = alumnos[i];
	}
	for (int i = 0; i < alumnos.length - 1; i++) {
	    for (int j = 0; j < (alumnosOrdenado.length - i - 1); j++) {
		if  (alumnosOrdenado[j]!=null && alumnosOrdenado[j+1]!=null && alumnosOrdenado[j].getNombre().compareTo(alumnosOrdenado[j+1].getNombre()) > 0 ) {
		    Alumno aux = alumnosOrdenado[j];
		    alumnosOrdenado[j] = alumnosOrdenado[j+1];
		    alumnosOrdenado[j+1] = aux;
		}
	    }
	}
	return alumnosOrdenado;
    }

    public Salon getSalon() {
	return this.salon;
    }
    
    public Nivel getNivel() {
	return this.nivel;
    }

    public Docente[] getDocentes() {
	return docentes;
    }

    public int contarDocentes() {
	int contador = 0;
	for (Docente docente : docentes) {
	    if (docente != null) {
		contador++;
	    }
	}
	return contador;
    }

    public int contarAlumnos() {
	int contador = 0;
	for (Alumno alumno : alumnos) {
	   if (alumno != null) {
	       contador++;
	   }
	}
	return contador;
    }
}