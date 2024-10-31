package ar.edu.unlam.pb2.personas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.enums.Niveles;

public class Alumno implements Comparable {

	private String nombre;
	private Integer dni;
	private Integer edad;
	private Niveles nivelAprobado;
	private LocalDate[] asistencias;
	private static final int DIAS_DE_CLASE = 190;
	private Integer evaluacion;

	public Alumno(String nombre, Integer dni, Integer edad, Niveles nivelAprobado) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.nivelAprobado = nivelAprobado;
		this.asistencias = new LocalDate[DIAS_DE_CLASE];
		this.evaluacion = 1;
	}

	public void marcarAsistencia(LocalDate fecha) {
		for (LocalDate element : asistencias) {
			if (element != null && element.equals(fecha)) {
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
		boolean asistio = false;
		for (LocalDate fechas : asistencias) {
			if (fecha == fechas) {
				asistio = true;
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

	public Niveles getNivelAprobado() {
		return nivelAprobado;
	}

	public void setEvaluacion(Integer nota) {
		this.evaluacion = nota;
	}

	public Integer getEvaluacion() {
		return evaluacion;
	}

	// para que me permita no duplicar objetos (HashSet y HashMap)
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
		    return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
		    return false;
		}
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}
	
	@Override
	public String toString() {
		return "Alumno: " + nombre + ", DNI " + dni + ", " + edad + " años";
	}

	// para que me permita ordenar (TreeSet y TreeMap)
	@Override
	public int compareTo(Object object) {
	    return this.dni.compareTo(((Alumno)object).getDni());
	}
}