package ar.edu.unlam.pb2.educacion;

public class Secundaria extends Curso {

    private static final Competencias[] MATERIAS = { Competencias.MATERIA_1, Competencias.MATERIA_2,
	    Competencias.MATERIA_3, Competencias.MATERIA_4, Competencias.MATERIA_5, Competencias.MATERIA_6,
	    Competencias.MATERIA_7 };

    public Secundaria(Nivel salon) {
	super(salon);
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
	if (!esMismoAlumno(alumno)) {
	    if ((alumno.getEdad() >= this.edadRequerida() && alumno.getEdad() < 18)
		    && alumno.getNivelAprobado().equals(nivelRequeridoPorEdad())) {
		alumnos.add(alumno);
	    }
	}
    }

    /* no es Override porque sobrecarga el metodo */
    public void agregarDocente(Docente docente, Competencias materia) {
	if (esMateriaValida(materia)) {
	    if (docente.tieneCompetencia(materia)) {
		docentes.add(docente);
	    }
	}
    }

    public Boolean esMateriaValida(Competencias materia) {
	Boolean valida = false;
	for (int i = 0; i < MATERIAS.length; i++) {
	    if (MATERIAS[i].equals(materia)) {
		valida = true;
		return valida;
	    }
	}
	return valida;
    }

}
