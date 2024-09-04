package ar.edu.unlam.pb2.educacion;

import java.time.LocalDate;

public class Alumno {

    private String nombre;
    private Integer dni;
    private Integer edad;
    private LocalDate[] asistencias;
    private static final int DIAS_DE_CLASE = 190;

    public Alumno(String nombre, Integer dni, Integer edad) {
	this.nombre = nombre;
	this.dni = dni;
	this.edad = edad;
	this.asistencias = new LocalDate[DIAS_DE_CLASE];
    }

    // testear asignando al menos dos fechas, e intentar asistir la misma
    public void marcarAsistencia(LocalDate fecha) {
	for (int i = 0; i < asistencias.length; i++) {
	    if (asistencias[i] != null && asistencias[i].equals(fecha)) {
		return;
	    }
	}
	for (int i = 0; i < asistencias.length; i++) {
	    if (asistencias[i] == null) {
		asistencias[i] = fecha;
		return;
	    }
	}
    }
    
    public Boolean asistio(LocalDate fecha) {
	Boolean asistio = Boolean.FALSE;
	for (LocalDate fechas : asistencias) {
	    if (fecha == fechas) {
		asistio = Boolean.TRUE;
		return asistio;
	    }
	}
	return asistio;
    }
    
    public int contarAsistencias() {
	int contador = 0;
	for (LocalDate fechas : asistencias) {
	    if (fechas != null) {
		contador++;
	    }
	}
	return contador;
    }
    
    public String getNombre() {
	return this.nombre;
    }
    
    public Integer getDni() {
	return this.dni;
    }
    
    public Integer getEdad() {
	return this.edad;
    }

    @Override
    public String toString() {
	return "Alumno: " + nombre + ", DNI " + dni + ", " + edad + " años";
    }
}