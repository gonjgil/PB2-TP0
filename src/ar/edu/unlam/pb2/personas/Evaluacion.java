           package ar.edu.unlam.pb2.personas;

import java.time.LocalDate;

import ar.edu.unlam.pb2.enums.Nivel;

public class Evaluacion {

    private Nivel salon;
    private Integer nota;
    private LocalDate fecha;
    
    public Evaluacion(Nivel salon, Integer nota, LocalDate fecha) {
	this.salon = salon;
	this.nota = nota;
	this.fecha = fecha;
    }
}
