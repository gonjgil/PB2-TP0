package ar.edu.unlam.pb2.educacion;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.enums.Competencias;
import ar.edu.unlam.pb2.enums.Niveles;
import ar.edu.unlam.pb2.excepciones.AlumnoInscriptoException;
import ar.edu.unlam.pb2.excepciones.AlumnoNoEncontradoException;
import ar.edu.unlam.pb2.excepciones.CantidadMaximaDocentesException;
import ar.edu.unlam.pb2.excepciones.DocenteExistenteException;
import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.excepciones.NivelNoPermitidoException;
import ar.edu.unlam.pb2.excepciones.NoEvaluableException;
import ar.edu.unlam.pb2.institucion.Institucion;
import ar.edu.unlam.pb2.institucion.Jardin;
import ar.edu.unlam.pb2.institucion.Primaria;
import ar.edu.unlam.pb2.institucion.Secundaria;
import ar.edu.unlam.pb2.personas.Alumno;
import ar.edu.unlam.pb2.personas.Docente;

public class testsInstitucion {

    private Institucion escuela;
    private String nombreDocente1, nombreDocente2, nombreDocente3;
    private String nombreAlumno1, nombreAlumno2, nombreAlumno3, nombreAlumno4;
    private Integer dniD1, dniD2, dniD3, dniA1, dniA2, dniA3, dniA4;
    private Integer edad3, edad5, edad6, edad7, edad8, edad15;
    private Niveles ninguno, nivelCeleste, nivelRojo, nivel1P, nivel2P, nivel3P, nivel1S, nivel2S, nivel3S, nivel4S, nivel5S;
    private LocalDate fecha1;
    private Competencias jardinerx, primero, tercero, materia1, materia3;

    @Before
    public void inicializaciones() {
	escuela = new Institucion();
	nombreDocente1 = "Marcelo";
	nombreDocente2 = "Ramon";
	nombreDocente3 = "Martin";
	nombreAlumno1 = "Quintero";
	nombreAlumno2 = "Martinez";
	nombreAlumno3 = "Alvarez";
	nombreAlumno4 = "Enzo";
	dniD1 = 10100100;
	dniD2 = 10200200;
	dniD2 = 10300300;
	dniA1 = 20100100;
	dniA2 = 20200200;
	dniA3 = 20300300;
	dniA4 = 20400400;
	edad3 = 3;
	edad5 = 5;
	edad6 = 6;
	edad7 = 7;
	edad8 = 8;
	edad15 = 15;
	ninguno = Niveles.NINGUNO;
	nivelCeleste = Niveles.CELESTE;
	nivelRojo = Niveles.ROJO;
	nivel1P = Niveles.PRIMERO_P;
	nivel2P = Niveles.SEGUNDO_P;
	nivel3P = Niveles.TERCERO_P;
	nivel1S = Niveles.PRIMERO_S;
	nivel2S = Niveles.SEGUNDO_S;
	nivel3S = Niveles.TERCERO_S;
	nivel4S = Niveles.CUARTO_S;
	nivel5S = Niveles.QUINTO_S;
	fecha1 = LocalDate.of(2018, 12, 9);
	jardinerx = Competencias.MAESTRX_JARDINERX;
	primero = Competencias.PRIMERO;
	tercero = Competencias.TERCERO;
	materia1 = Competencias.MATERIA_1;
	materia3 = Competencias.MATERIA_3;
    }

    @Test // Curso:Jardin
    public void queSePuedaCrearUnCursoDeSalitaRoja() throws NivelNoPermitidoException {
	Jardin jardin = new Jardin(nivelRojo);

	assertNotNull(jardin);
    }

    @Test // Institucion -> Curso:Jardin
    public void queSePuedaAgregarUnCursoDeSalitaRojaALaInstitucion() throws NivelNoPermitidoException {
	Jardin jardin = new Jardin(nivelRojo);

	escuela.agregarCurso(jardin);

	assertEquals(1, escuela.getSalones().size());
    }

    @Test // Institucion -> Curso
    (expected = NivelNoPermitidoException.class)
    public void queNoSePuedaAgregarAUnaInstitucionUnCursoDeJardinDeUnNivelQueNoCorresponde() throws NivelNoPermitidoException {
	Jardin jardin = new Jardin(nivel2P);

	escuela.agregarCurso(jardin);
    }

    @Test // Docente
    public void queSePuedaAgregarUnaCompetenciaAUnDocente() {
	Competencias competencia = Competencias.MATERIA_2;

	Docente docente1 = new Docente(nombreDocente1, dniD1);
	docente1.agregarCompetencia(competencia);

	assertTrue(docente1.getCompetencias().contains(competencia));
    }

    @Test // Curso:Jardin & Docente
    (expected = CantidadMaximaDocentesException.class)
    public void queNoSePuedaAgregarMasDeDosDocentesAUnJardin()
	    throws CantidadMaximaDocentesException, NivelNoPermitidoException, DocenteExistenteException {
	Jardin jardin = new Jardin(nivelRojo);
	Docente docente1 = new Docente(nombreDocente1, dniD1);
	Docente docente2 = new Docente(nombreDocente2, dniD2);
	Docente docente3 = new Docente(nombreDocente3, dniD3);

	docente1.agregarCompetencia(jardinerx);
	jardin.agregarDocente(docente1);
	docente2.agregarCompetencia(jardinerx);
	jardin.agregarDocente(docente2);
	docente3.agregarCompetencia(jardinerx);
	jardin.agregarDocente(docente3);
    }

    @Test // Curso -> Primaria & Docente
    (expected = CantidadMaximaDocentesException.class)
    public void queNoSePuedaAgregarMasDeUnDocenteAUnCursoDePrimaria()
	    throws NivelNoPermitidoException, CantidadMaximaDocentesException, DocenteExistenteException {
	Primaria curso = new Primaria(nivel3P);
	Docente docente = new Docente(nombreDocente1, dniD1);
	Docente docente2 = new Docente(nombreDocente2, dniD2);
	docente.agregarCompetencia(tercero);
	docente2.agregarCompetencia(tercero);

	curso.agregarDocente(docente);
	curso.agregarDocente(docente2);
    }

    @Test(expected = NivelNoPermitidoException.class)
    public void queNoSePuedaAgregarUnDocenteAUnCursoDePrimariaParaElCualNoEstaCalificado()
	    throws NivelNoPermitidoException, CantidadMaximaDocentesException, DocenteExistenteException {
	Primaria primaria = new Primaria(nivel3P);
	Docente docente = new Docente(nombreDocente1, dniD1);
	docente.agregarCompetencia(jardinerx);
	docente.agregarCompetencia(materia1);

	primaria.agregarDocente(docente);
    }

    @Test // Curso -> Primaria & Alumno
    public void queSePuedaCargarUnAlumnoConSegundoGradoDePrimariaAprobadoEnTercerGradoDePrimaria()
	    throws NivelNoPermitidoException, AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException {
	Primaria curso = new Primaria(nivel3P);
	Alumno alumno = new Alumno(nombreAlumno1, dniA1, edad8, nivel2P);

	curso.inscribirAlumno(alumno);

	assertTrue(curso.getAlumnos().contains(alumno));
    }

    @Test // Alumno
    public void queQuinteroPuedaMarcarAsistenciaUnDiaDeClases() {
	Alumno alumno = new Alumno(nombreAlumno1, dniA1, edad3, nivelRojo);

	alumno.marcarAsistencia(fecha1);

	assertTrue(alumno.asistio(fecha1));
    }

    @Test // Alumno
    public void queQuinteroNoPuedaMarcarAsistenciaDosVecesEnUnMismoDia() { // Alumno
	Alumno alumno = new Alumno(nombreAlumno1, dniA1, edad3, nivelRojo);

	alumno.marcarAsistencia(fecha1);
	alumno.marcarAsistencia(LocalDate.of(2018, 12, 9));

	assertEquals(1, alumno.contarAsistencias());
    }

    @Test(expected = DocenteExistenteException.class) // Curso -> Jardin & Docente
    public void queNoSePuedaAgregarAUnDocenteConElMismoDniDosVecesAlMismoCursoDeUnJardin()
	    throws NivelNoPermitidoException, CantidadMaximaDocentesException, DocenteExistenteException { // Curso -> Jardin & Docente
	Docente docente1 = new Docente(nombreDocente1, dniD1);
	docente1.agregarCompetencia(jardinerx);
	Docente docente2 = new Docente(nombreDocente2, dniD1);
	docente2.agregarCompetencia(jardinerx);

	Jardin curso = new Jardin(nivelRojo);
	curso.agregarDocente(docente1);
	curso.agregarDocente(docente2);
    }

    @Test // Curso -> Primaria & Docente
    public void queSePuedaAgregarUnDocenteAPrimeroDePrimaria()
	    throws NivelNoPermitidoException, CantidadMaximaDocentesException, DocenteExistenteException { // Curso -> Primaria & Docente
	Primaria curso = new Primaria(nivel1P);
	Docente docente1 = new Docente(nombreDocente1, dniD1);
	docente1.agregarCompetencia(primero);

	curso.agregarDocente(docente1);

	assertTrue(curso.getDocentes().contains(docente1));
    }

    @Test // Curso -> Secundaria & Docente
    public void queSePuedaAgregarUnDocenteAPrimeroDeSecundaria() throws NivelNoPermitidoException { // Curso -> Secundaria & Docente
	Secundaria curso = new Secundaria(nivel1S);
	Docente alumno = new Docente(nombreDocente1, dniD1);
	alumno.agregarCompetencia(materia3);

	curso.agregarDocente(alumno, materia3);

	assertTrue(curso.getDocentes().contains(alumno));
    }

    @Test // Curso -> Secundaria & Docente
    public void queNoSePuedaInscribrUnDocenteEnQuintoDeSecundariaSiNoTieneExperienciaEnEsaMateria() throws NivelNoPermitidoException { // Curso -> Secundaria & Docente
	Secundaria curso = new Secundaria(nivel5S);
	Docente docente = new Docente(nombreDocente1, dniD1);
	docente.agregarCompetencia(materia1);

	curso.agregarDocente(docente, materia3);

	assertEquals(0, curso.getDocentes().size());
    }

    @Test // Curso -> Jardin & Alumno
    (expected = AlumnoInscriptoException.class)
    public void queNoSePuedaCargarDosVecesUnAlumnoConElMismoDniEnSalitaCeleste()
	    throws NivelNoPermitidoException, AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException { // Curso -> Jardin & Alumno
	Jardin curso = new Jardin(nivelCeleste);
	Alumno alumno1 = new Alumno(nombreAlumno1, dniA1, edad5, ninguno);
	Alumno alumno2 = new Alumno(nombreAlumno2, dniA1, edad5, ninguno);

	curso.inscribirAlumno(alumno1);
	curso.inscribirAlumno(alumno2);
    }

    @Test // Curso -> Primaria & Alumno
    (expected = EdadNoPermitidaException.class)
    public void queNoSePuedaCargarUnAlumnoCon5AñosEnPrimerGradoDePrimaria()
	    throws NivelNoPermitidoException, AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException { // Curso -> Primaria & Alumno
	Primaria curso = new Primaria(nivel1P);
	Alumno alumno = new Alumno(nombreAlumno1, dniA1, edad5, ninguno);

	curso.inscribirAlumno(alumno);
    }

    @Test // Curso -> Primaria & Alumno
    public void queNoSePuedaAgregarAlPitiAUnCursoDeTerceroPrimariaSiNoTieneAprobadoSegundoDePrimaria() throws NivelNoPermitidoException { // Curso -> Primaria & Alumno
	Primaria curso = new Primaria(nivel3P);

	assertEquals(0, curso.getAlumnos().size());
    }

    @Test // Curso -> Secundaria & Alumno
    public void queSePuedaInscribirEnCuartoDeSecundariaUnAlumnoQueAproboTerceroDeSecundaria()
	    throws NivelNoPermitidoException, AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException { // Curso -> Secundaria & Alumno
	Secundaria curso = new Secundaria(nivel4S);
	Alumno alumno = new Alumno(nombreAlumno3, dniA3, edad15, nivel3S);

	curso.inscribirAlumno(alumno);

	assertTrue(curso.getAlumnos().contains(alumno));
    }

    @Test // Curso -> Secundaria & Alumno
    public void queNoSePuedaInscribirUnAlumnoDe15AñosEnSegundoDeSecundaria()
	    throws NivelNoPermitidoException, AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException { // Curso -> Secundaria & Alumno
	Secundaria curso = new Secundaria(nivel2S);
	Alumno alumno = new Alumno(nombreAlumno3, dniA3, edad15, nivel1S);

	curso.inscribirAlumno(alumno);

	assertTrue(curso.getAlumnos().contains(alumno));
    }

    @Test // Curso -> Primaria & Alumno & Docente
    public void queElAlumnoJuanferSeaEvaluadoConUn10()
	    throws AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException, NoEvaluableException, NivelNoPermitidoException { // Curso -> Primaria & Alumno & Docente
	Alumno alumno = new Alumno(nombreAlumno3, dniA3, edad6, ninguno);
	Docente docente = new Docente(nombreDocente1, dniD1);
	docente.agregarCompetencia(primero);
	Primaria curso = new Primaria(nivel1P);

	Integer nota = 10;

	curso.inscribirAlumno(alumno);
	curso.evaluarAlumno(alumno, docente, nota);

	assertEquals(nota, alumno.getEvaluacion());
    }

    @Test // Curso -> Primaria & Alumno & Docente
    public void queElAlumnoJuanferNoPuedaSerEvaluadoPorUnDocenteNoCalificado()
	    throws AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException, NoEvaluableException, NivelNoPermitidoException { // Curso -> Primaria & Alumno & Docente
	Alumno alumno = new Alumno(nombreAlumno3, dniA3, edad6, ninguno);
	Docente docente = new Docente(nombreDocente1, dniD1);
	docente.agregarCompetencia(materia3);
	Primaria curso = new Primaria(nivel1P);

	Integer nota = 10;
	curso.inscribirAlumno(alumno);
	curso.evaluarAlumno(alumno, docente, nota);

	assertNotEquals(nota, alumno.getEvaluacion());
    }

    @Test // Curso -> Primaria & Alumno & Docente
    (expected = NoEvaluableException.class)
    public void queNoSePuedaEvaluarUnAlumnoDeJardin()
	    throws NivelNoPermitidoException, AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException, NoEvaluableException { // Curso -> Primaria & Alumno & Docente
	Alumno alumno = new Alumno(nombreAlumno3, dniA3, edad5, nivelRojo);
	Docente docente = new Docente(nombreDocente1, dniD1);
	docente.agregarCompetencia(jardinerx);
	Jardin curso = new Jardin(nivelRojo);

	Integer nota = 10;

	curso.inscribirAlumno(alumno);
	curso.evaluarAlumno(alumno, docente, nota);
    }

    @Test // Institucion -> Curso -> Alumno
    public void queSePuedaEncontrarUnAlumnoEnCualquierCursoDeUnaInstitucion() throws AlumnoInscriptoException, EdadNoPermitidaException,
	    NivelInvalidoException, NivelNoPermitidoException, AlumnoNoEncontradoException {
	Alumno alumno1 = new Alumno(nombreAlumno3, dniA3, edad5, nivelRojo);
	Jardin curso = new Jardin(nivelRojo);

	curso.inscribirAlumno(alumno1);
	escuela.agregarCurso(curso);

	assertEquals(alumno1, escuela.buscarAlumno(dniA3));
    }

    @Test(expected = AlumnoNoEncontradoException.class) // Institucion -> Curso -> Alumno
    public void queAlBuscarUnAlumnoQueNoExisteEnUnaInstitucionDevuelvaUnaExcepcionDeAlumnoNoEncontrado() throws AlumnoInscriptoException,
	    EdadNoPermitidaException, NivelInvalidoException, NivelNoPermitidoException, AlumnoNoEncontradoException {
	Alumno alumno1 = new Alumno(nombreAlumno3, dniA3, edad5, nivelRojo);
	Jardin curso = new Jardin(nivelRojo);

	curso.inscribirAlumno(alumno1);
	escuela.agregarCurso(curso);
	escuela.buscarAlumno(dniA2);
    }

    @Test // Curso -> Alumno
    public void queSePuedaObtenerElListadoDeAlumnosOrdenadoPorNombre()
	    throws NivelNoPermitidoException, AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException {
	Alumno alumno1 = new Alumno(nombreAlumno1, dniA1, edad7, nivel1P);
	Alumno alumno2 = new Alumno(nombreAlumno2, dniA2, edad7, nivel1P);
	Alumno alumno3 = new Alumno(nombreAlumno3, dniA3, edad7, nivel1P);
	Alumno alumno4 = new Alumno(nombreAlumno4, dniA4, edad7, nivel1P);

	Primaria curso = new Primaria(nivel2P);
	curso.inscribirAlumno(alumno1);
	curso.inscribirAlumno(alumno2);
	curso.inscribirAlumno(alumno3);
	curso.inscribirAlumno(alumno4);

	Set<Alumno> alumnosOrdenadosPorNombre = curso.getAlumnosOrdenadosPorNombre();

	int posicion = 0;
	for (Alumno cada : alumnosOrdenadosPorNombre) {
	    switch (posicion) {
	    case 0:
		assertEquals(nombreAlumno3, cada.getNombre());
		break;
	    case 1:
		assertEquals(nombreAlumno4, cada.getNombre());
		break;
	    case 2:
		assertEquals(nombreAlumno2, cada.getNombre());
		break;
	    case 3:
		assertEquals(nombreAlumno1, cada.getNombre());
		break;
	    default:
	    }
	    posicion++;
	}
    }

    @Test
    public void queSePuedaObtenerElListadoDeAlumnosOrdenadoPorDni()
	    throws AlumnoInscriptoException, EdadNoPermitidaException, NivelInvalidoException, NivelNoPermitidoException {
	Alumno alumno1 = new Alumno(nombreAlumno1, dniA1, edad7, nivel1P);
	Alumno alumno2 = new Alumno(nombreAlumno2, dniA2, edad7, nivel1P);
	Alumno alumno3 = new Alumno(nombreAlumno3, dniA3, edad7, nivel1P);
	Alumno alumno4 = new Alumno(nombreAlumno4, dniA4, edad7, nivel1P);

	Primaria curso = new Primaria(nivel2P);
	curso.inscribirAlumno(alumno1);
	curso.inscribirAlumno(alumno2);
	curso.inscribirAlumno(alumno3);
	curso.inscribirAlumno(alumno4);

	Set<Alumno> alumnosOrdenadosPorDni = curso.getAlumnosOrdenadosPorDni();

	int posicion = 0;
	for (Alumno cada : alumnosOrdenadosPorDni) {
	    switch (posicion) {
	    case 0:
		assertEquals(dniA1, cada.getDni());
		break;
	    case 1:
		assertEquals(dniA2, cada.getDni());
		break;
	    case 2:
		assertEquals(dniA3, cada.getDni());
		break;
	    case 3:
		assertEquals(dniA4, cada.getDni());
		break;
	    default:
	    }
	    posicion++;
	}
    }

}
