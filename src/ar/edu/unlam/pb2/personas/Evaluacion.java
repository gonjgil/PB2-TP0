package ar.edu.unlam.pb2.personas;

import java.time.LocalDate;

import ar.edu.unlam.pb2.enums.Niveles;

public class Evaluacion {

	private Niveles salon;
	private Integer nota;
	private LocalDate fecha;

	public Evaluacion(Niveles salon, Integer nota, LocalDate fecha) {
		this.salon = salon;
		this.nota = nota;
		this.fecha = fecha;
	}
}
