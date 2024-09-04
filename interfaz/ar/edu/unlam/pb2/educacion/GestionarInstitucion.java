package ar.edu.unlam.pb2.educacion;

import java.util.Scanner;

public class GestionarInstitucion {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

	OpcionMenuPrincipal opcionMenu = null;
	Institucion laInstitucion = new Institucion("ESLAM");

	do {
	    System.out.println("INSTITUCIÓN EDUCATIVA MODELO");
	    cargaInicialAlumnos();
	    cargaInicialDocentes();
	    opcionMenu = obtenerOpcionParaMenuPrincipal();

	    switch (opcionMenu) {
	    case PRIMERA:
		cargaInicialAlumnos();;
		break;
	    case SEGUNDA:
		cargaInicialDocentes();
		break;
	    case SALIR:
		System.out.println("Terminó");
		break;
		default: return;
	    }
	} while (opcionMenu != OpcionMenuPrincipal.SALIR);
    }

    private static void cargaInicialAlumnos() {
	Alumno alumno01 = new Alumno("Gulp", 12345678, 2);
	Alumno alumno02 = new Alumno("Oktubre", 45678901, 2);
	Alumno alumno03 = new Alumno("Bajon", 23456789, 2);
    }

    private static void cargaInicialDocentes() {
	Docente docente01 = new Docente("Patricio", 12345678, 40, Competencias.MAESTRX_JARDINERX);
	Docente docente02 = new Docente("Rey", 87654321, 40, Competencias.MAESTRX_JARDINERX);
    }

    private static OpcionMenuPrincipal obtenerOpcionParaMenuPrincipal() {
	int opcion = 0;
	OpcionMenuPrincipal menuPrincipal;
	while (true) {
	    mostrarMenuPrincipal();
	    System.out.println("\nIngrese opción");
	    opcion = teclado.nextInt();
	    if (opcion >= OpcionMenuPrincipal.min() && opcion <= OpcionMenuPrincipal.max()) {
		menuPrincipal = OpcionMenuPrincipal.obtenerOpcion(opcion);
		return menuPrincipal;
	    } else {
		System.out.println("Opción inexsistente");
	    }
	}
    }

    private static void mostrarMenuPrincipal() {
	String menu = "";
	for (OpcionMenuPrincipal opcion : OpcionMenuPrincipal.values()) {
	    menu += "\n" + opcion;
	}
	System.out.println(menu);
    }
}