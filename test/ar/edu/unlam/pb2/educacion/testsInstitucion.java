package ar.edu.unlam.pb2.educacion;

import static org.junit.Assert.*;
import org.junit.Test;

import ar.edu.unlam.pb2.cursos.Jardin;
import ar.edu.unlam.pb2.cursos.Primaria;
import ar.edu.unlam.pb2.cursos.Secundaria;
import ar.edu.unlam.pb2.enums.Competencias;
import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.AlumnoInscriptoException;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.personas.Alumno;
import ar.edu.unlam.pb2.personas.Docente;

import java.time.*;

public class testsInstitucion {

    @Test // Curso
    public void queSePuedaCrearUnCursoDeSalitaRojaEnLaClasePadre() { // Curso
	Niveles salon = Niveles.ROJO;

	Jardin nuevoCurso = new Jardin(salon);

	assertNotNull(nuevoCurso);
    }

    @Test // Docente
    public void queSePuedaAgregarUnaCompetenciaAUnDocente() { // Docente
	String nombre = "Muñeco";
	Integer dni = 20181209;
	Competencias competencia = Competencias.MATERIA_2;

	Docente docente = new Docente(nombre, dni);
	docente.agregarCompetencia(competencia);

	assertTrue(docente.getCompetencias().contains(competencia));
    }

    @Test // Alumno
    public void queQuinteroPuedaMarcarAsistenciaAUnaClase() { // Alumno
	String nombre = "Quintero";
	Integer dni = 12345678, edad = 3;
	Niveles nivel = Niveles.ROJO;
	LocalDate diaDeClase = LocalDate.of(2018, 12, 9);
	Alumno nuevo = new Alumno(nombre, dni, edad, nivel);

	nuevo.marcarAsistencia(diaDeClase);

	assertTrue(nuevo.asistio(diaDeClase));
    }

    @Test // Alumno
    public void queQuinteroNoPuedaMarcarAsistenciaDosVecesEnUnMismoDia() { // Alumno
	String nombre = "Quintero";
	Integer dni = 12345678, edad = 3;
	LocalDate diaDeClase = LocalDate.of(2024, 12, 9);
	Niveles nivel = Niveles.ROJO;
	Alumno nuevo = new Alumno(nombre, dni, edad, nivel);

	nuevo.marcarAsistencia(diaDeClase);
	nuevo.marcarAsistencia(LocalDate.of(2024, 12, 9));

	assertEquals(1, nuevo.contarAsistencias());
    }

    @Test // Curso -> Jardin & Docente
    public void queNoSePuedaAgregarAUnDocenteConElMismoDniDosVecesAlMismoCursoDeUnJardin() { // Curso -> Jardin & Docente
	String nombre = "Marcelo", nombre2 = "Ramon";
	Integer dni = 9122018;
	Competencias competencia = Competencias.MAESTRX_JARDINERX;
	Docente docente = new Docente(nombre, dni);
	docente.agregarCompetencia(competencia);
	Docente docente2 = new Docente(nombre2, 9122018);
	docente2.agregarCompetencia(competencia);

// PREGUNTAR ver como limitar los valores del constructor que puede tomar del enum cada clase !!!!

	Jardin curso = new Jardin(Niveles.ROJO);
	curso.agregarDocente(docente);
	curso.agregarDocente(docente2);

	assertEquals(1, curso.getDocentes().size());
    }

    @Test // Curso -> Primaria & Docente
    public void queSePuedaAgregarUnDocenteAPrimeroDePrimaria() { // Curso -> Primaria & Docente
	String nombre = "Muñeco";
	Integer dni = 20181209;
	Competencias competencia = Competencias.PRIMERO;

	Primaria curso = new Primaria(Niveles.PRIMERO_P);
	Docente nuevo = new Docente(nombre, dni);
	nuevo.agregarCompetencia(competencia);

	curso.agregarDocente(nuevo);

	assertTrue(curso.getDocentes().contains(nuevo));
    }

    @Test // Curso -> Primaria & Docente
    public void queNoSePuedaAgregarMasDeUnDocenteAUnCursoDePrimaria() { // Curso -> Primaria & Docente
	String nombre = "Muñeco", nombre2 = "Micho";
	Integer dni = 20181209, dni2 = 11111111;
	Competencias competencia = Competencias.TERCERO, competencia2 = Competencias.TERCERO;

	Primaria curso = new Primaria(Niveles.TERCERO_P);
	Docente docente = new Docente(nombre, dni);
	Docente docente2 = new Docente(nombre2, dni2);
	docente.agregarCompetencia(competencia);
	docente2.agregarCompetencia(competencia2);

	curso.agregarDocente(docente);
	curso.agregarDocente(docente2);

	assertEquals(1, curso.getDocentes().size());
    }

    @Test // Curso -> Secundaria & Docente
    public void queSePuedaAgregarUnDocenteAPrimeroDeSecundaria() { // Curso -> Secundaria & Docente
	String nombre = "Marcelo";
	Integer dni = 20181209;
	Competencias materia = Competencias.MATERIA_3;
	Competencias competencia = Competencias.MATERIA_3;

	Secundaria curso = new Secundaria(Niveles.PRIMERO_S);
	Docente nuevo = new Docente(nombre, dni);
	nuevo.agregarCompetencia(competencia);

	curso.agregarDocente(nuevo, materia);

	assertTrue(curso.getDocentes().contains(nuevo));
    }

    @Test // Curso -> Secundaria & Docente
    public void queNoSePuedaInscribrUnDocenteEnQuintoDeSecundariaSiNoTieneExperienciaEnEsaMateria() { // Curso -> Secundaria & Docente
	String nombre = "Muñeco";
	Integer dni = 20181209;
	Competencias competencia = Competencias.MATERIA_2;
	Competencias materia = Competencias.MATERIA_1;

	Secundaria curso = new Secundaria(Niveles.QUINTO_S);
	Docente docente = new Docente(nombre, dni);
	docente.agregarCompetencia(competencia);

	curso.agregarDocente(docente, materia);

	assertEquals(0, curso.getDocentes().size());
    }

    @Test // Curso -> Jardin & Alumno
    public void queNoSePuedaCargarDosVecesUnMismoAlumnoEnSalitaCeleste() { // Curso -> Jardin & Alumno
	String nombre = "Quintero";
	Integer dni = 12345678;
	Integer edad = 5;
	Niveles nivel = Niveles.NINGUNO;

	Jardin curso = new Jardin(Niveles.CELESTE);
	Alumno nuevo = new Alumno(nombre, dni, edad, nivel);
	Alumno nuevo2 = new Alumno(nombre, dni, edad, nivel);

	    try {
		curso.inscribirAlumno(nuevo);
		curso.inscribirAlumno(nuevo2);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }


	assertTrue(curso.getAlumnos().contains(nuevo));
	assertEquals(1, curso.getAlumnos().size());
    }

    @Test // Curso -> Primaria & Alumno
    public void queNoSePuedaCargarUnAlumnoCon5AñosEnPrimerGradoDePrimaria() { // Curso -> Primaria & Alumno
	String nombre = "Quintero";
	Integer dni = 12345678;
	Integer edad = 5;
	Niveles nivel = Niveles.NINGUNO;

	Primaria curso = new Primaria(Niveles.PRIMERO_P);
	Alumno nuevo = new Alumno(nombre, dni, edad, nivel);

	    try {
		curso.inscribirAlumno(nuevo);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }
	    
	assertFalse(curso.getAlumnos().contains(nuevo));
    }

    @Test // Curso -> Primaria & Alumno
    public void queNoSePuedaAgregarAlPitiAUnCursoDeTerceroPrimariaSiNoTieneAprobadoSegundoDePrimaria() { // Curso -> Primaria & Alumno
	String nombre = "Martinez";
	Integer dni = 20181209;
	Integer edad = 8;
	Niveles nivel = Niveles.PRIMERO_P;

	Alumno alumno = new Alumno(nombre, dni, edad, nivel);
	Primaria curso = new Primaria(Niveles.TERCERO_P);
	
	try {
	    curso.inscribirAlumno(alumno);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }
	
	assertEquals(0, curso.getAlumnos().size());
    }

    @Test // Curso -> Primaria & Alumno
    public void queNoSePuedaAgregarADosAlumnosConElMismoDniEnUnCursoDePrimaria() { // Curso -> Primaria & Alumno
	String nombre = "Martinez", nombre2 = "Juanfer";
	Integer dni = 20181209;
	Integer edad = 8, edad2 = 9;
	Niveles nivel = Niveles.SEGUNDO_P;

	Alumno alumno = new Alumno(nombre, dni, edad, nivel);
	Alumno alumno2 = new Alumno(nombre2, 20181209, edad2, nivel);
	Primaria curso = new Primaria(Niveles.TERCERO_P);
	
	try {
	    curso.inscribirAlumno(alumno);
	    curso.inscribirAlumno(alumno2);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }

	assertEquals(1, curso.getAlumnos().size());
    }

    @Test // Curso -> Primaria & Alumno
    public void queSePuedaCargarUnAlumnoConEnTercerGradoDePrimaria() { // Curso -> Primaria & Alumno
	String nombre = "Quintero";
	Integer dni = 12345678;
	Integer edad = 8;
	Niveles nivel = Niveles.SEGUNDO_P;

	Primaria curso = new Primaria(Niveles.TERCERO_P);
	Alumno nuevo = new Alumno(nombre, dni, edad, nivel);

	try {
	    curso.inscribirAlumno(nuevo);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }

		assertTrue(curso.getAlumnos().contains(nuevo));
    }

    @Test // Curso -> Secundaria & Alumno
    public void queSePuedaInscribirEnCuartoDeSecundariaUnAlumnoQueAproboTerceroDeSecundaria() { // Curso -> Secundaria & Alumno
	String nombre = "Quintero";
	Integer dni = 12345678;
	Integer edad = 15;
	Niveles nivel = Niveles.TERCERO_S;

	Secundaria curso = new Secundaria(Niveles.CUARTO_S);
	Alumno nuevo = new Alumno(nombre, dni, edad, nivel);

	try {
	    curso.inscribirAlumno(nuevo);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }

	assertTrue(curso.getAlumnos().contains(nuevo));
    }

    @Test // Curso -> Secundaria & Alumno
    public void queNoSePuedaInscribirUnAlumnoDe15AñosEnSegundoDeSecundaria() { // Curso -> Secundaria & Alumno
	String nombre = "Quintero";
	Integer dni = 12345678;
	Integer edad = 15;
	Niveles nivel = Niveles.PRIMERO_S;

	Secundaria curso = new Secundaria(Niveles.SEGUNDO_S);
	Alumno nuevo = new Alumno(nombre, dni, edad, nivel);

	try {
	    curso.inscribirAlumno(nuevo);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }

	assertTrue(curso.getAlumnos().contains(nuevo));
    }

    @Test // Curso -> Primaria & Alumno & Docente
    public void queElAlumnoJuanferSeaEvaluadoConUn10() { // Curso -> Primaria & Alumno & Docente
	String nombre = "Quintero";
	Integer dni = 9122018;
	Integer edad = 6;
	Niveles nivel = Niveles.NINGUNO;
	Alumno alumno = new Alumno(nombre, dni, edad, nivel);
	Docente docente = new Docente("Gallardo", 9122018);
	docente.agregarCompetencia(Competencias.PRIMERO);
	Primaria curso = new Primaria(Niveles.PRIMERO_P);

	Integer nota = 10;
	
	try {
	    curso.inscribirAlumno(alumno);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }
	
	curso.evaluarAlumno(alumno, docente, nota);

	assertEquals(nota, alumno.getEvaluacion());
    }

    @Test // Curso -> Primaria & Alumno & Docente
    public void queElAlumnoJuanferNoPuedaSerEvaluadoPorUnDocenteNoCalificado() { // Curso -> Primaria & Alumno & Docente
	String nombre = "Quintero";
	Integer dni = 9122018;
	Integer edad = 6;
	Niveles nivel = Niveles.NINGUNO;
	Alumno alumno = new Alumno(nombre, dni, edad, nivel);
	Docente docente = new Docente("Gallardo", 9122018);
	docente.agregarCompetencia(Competencias.MATERIA_3);
	Primaria curso = new Primaria(Niveles.PRIMERO_P);

	Integer nota = 10;
	try {
	    curso.inscribirAlumno(alumno);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }
	
	curso.evaluarAlumno(alumno, docente, nota);

	assertNotEquals(nota, alumno.getEvaluacion());
    }

    @Test // Curso -> Primaria & Alumno & Docente
    public void queNoSePuedaEvaluarUnAlumnoDeJardin() { // Curso -> Primaria & Alumno & Docente
	String nombre = "Quintero";
	Integer dni = 9122018;
	Integer edad = 5;
	Niveles nivel = Niveles.ROJO;
	Alumno alumno = new Alumno(nombre, dni, edad, nivel);
	Docente docente = new Docente("Gallardo", 9122018);
	docente.agregarCompetencia(Competencias.MAESTRX_JARDINERX);
	Jardin curso = new Jardin(Niveles.ROJO);

	Integer nota = 10;
	try {
	    curso.inscribirAlumno(alumno);
	    } catch (AlumnoInscriptoException e) {
		e.getMessage();
	    } catch (EdadNoPermitidaException e) {
		e.getMessage();
	    } catch (NivelInvalidoException e) {
		e.getMessage();
	    }
	
	curso.evaluarAlumno(alumno, docente, nota);

	assertEquals((Integer) 1, alumno.getEvaluacion());
    }

}
