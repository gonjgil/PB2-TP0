package ar.edu.unlam.pb2.educacion;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.*;

public class testsInstitucion {

    @Test // Alumno
    public void queSePuedaCrearUnAlumno() {
	String nombre = "Quintero";
	Integer dni = 12345678;
	Integer edad = 3;

	Alumno nuevo = new Alumno(nombre, dni, edad);

	assertNotNull(nuevo);
	assertEquals(nombre, nuevo.getNombre());
	assertEquals(dni, nuevo.getDni());
	assertEquals(edad, nuevo.getEdad());
    }

    @Test // Alumno
    public void queQuinteroPuedaMarcarAsistenciaAUnaClase() {
	String nombre = "Quintero";
	Integer dni = 12345678, edad = 3;
	LocalDate diaDeClase = LocalDate.of(2018, 12, 9);
	Alumno nuevo = new Alumno(nombre, dni, edad);

	nuevo.marcarAsistencia(diaDeClase);

	assertTrue(nuevo.asistio(diaDeClase));
    }

    @Test // Alumno
    public void queQuinteroNoPuedaMarcarAsistenciaDosVecesEnUnaMismaClase() {
	String nombre = "Quintero";
	Integer dni = 12345678, edad = 3;
	LocalDate diaDeClase = LocalDate.of(2024, 12, 9);
	Alumno nuevo = new Alumno(nombre, dni, edad);

	nuevo.marcarAsistencia(diaDeClase);
	nuevo.marcarAsistencia(diaDeClase);

	assertEquals(1, nuevo.contarAsistencias());
    }

    @Test // Curso
    public void queSePuedaCrearUnCursoDeSalitaRoja() {
	Salon salon = Salon.ROJO;

	Curso nuevoCurso = new Curso(salon);

	assertNotNull(nuevoCurso);
    }

    @Test // Curso
    public void queSePuedaAgregarAlDocenteMarceloAUnCursoDeSalitaRoja() {
	String nombre = "Marcelo";
	Integer dni = 9122018;
	Integer aniosExperiencia = 8;
	Competencias competenciaMaxima = Competencias.MAESTRX;
	Docente nuevoDocente = new Docente(nombre, dni, aniosExperiencia, competenciaMaxima);

	Curso nuevoCurso = new Curso(Salon.ROJO);

	assertTrue(nuevoCurso.agregarDocente(nuevoDocente));
    }

    @Test // Curso
    public void queNoSePuedaAgregarAMarceloDosVecesAlMismoCursoDeSalitaRoja() {
	String nombre = "Marcelo";
	Integer dni = 9122018;
	Integer aniosExperiencia = 8;
	Competencias competenciaMaxima = Competencias.MAESTRX;
	Docente nuevoDocente = new Docente(nombre, dni, aniosExperiencia, competenciaMaxima);

	Curso nuevoCurso = new Curso(Salon.ROJO);
	nuevoCurso.agregarDocente(nuevoDocente);
	nuevoCurso.agregarDocente(nuevoDocente);

	assertEquals(1, nuevoCurso.contarDocentes());
    }

    @Test 
    public void queSePuedaAgregarAlPitiAUnCursoDeTerceroPrimaria() {
	String nombre = "Martinez";
	Integer dni = 20181209;
	Integer edad = 3;
	Alumno nuevoAlumno = new Alumno(nombre, dni, edad);
	
	Curso nuevoCurso = new Curso(Salon.TERCERO_P);

	assertTrue(nuevoCurso.agregarAlumno(nuevoAlumno));
    }
    
    @Test
    public void queNoSePuedaAgregarAlPitiDosVecesAlMismoCursoDeTerceroPrimaria() {
	String nombre = "Martinez";
	Integer dni = 20181209;
	Integer edad = 3;
	Alumno nuevoAlumno = new Alumno(nombre, dni, edad);
	
	Curso nuevoCurso = new Curso(Salon.TERCERO_P);
	nuevoCurso.agregarAlumno(nuevoAlumno);
	nuevoCurso.agregarAlumno(nuevoAlumno);
	
	assertEquals(1, nuevoCurso.contarAlumnos());
    }

    @Test
    public void quePuedaBuscarUnDocentePorSuDni() {
	String nombre = "Marcelo";
	Integer dni = 9122018;
	Integer aniosExperiencia = 8;
	Competencias competenciaMaxima = Competencias.MAESTRX;
	Docente nuevoDocente = new Docente(nombre, dni, aniosExperiencia, competenciaMaxima);
	
	Docente segundoDocente = new Docente("yo", 26071413, 47, Competencias.SEXTO);

	Curso nuevoCurso = new Curso(Salon.ROJO);
	nuevoCurso.agregarDocente(nuevoDocente);
	nuevoCurso.agregarDocente(segundoDocente);

	assertEquals(nuevoDocente, nuevoCurso.buscarDocente(dni));
	assertEquals(segundoDocente, nuevoCurso.buscarDocente(26071413));
    }
}
