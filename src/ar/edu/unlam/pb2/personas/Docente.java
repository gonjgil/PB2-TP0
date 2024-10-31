package ar.edu.unlam.pb2.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ar.edu.unlam.pb2.enums.Competencias;

public class Docente {

    private Integer dni;
    private String nombre;
    private List<Competencias> competencias;

    public Docente(String nombre, Integer dni) {
	this.dni = dni;
	this.nombre = nombre;
	this.competencias = new ArrayList<>();
    }

    public void agregarCompetencia(Competencias competencia) {
	if(!competencias.contains(competencia)) {
	competencias.add(competencia);
	}
    }

    public String getNombre() {
	return this.nombre;
    }

    public Integer getDni() {
	return this.dni;
    }

    public List<Competencias> getCompetencias() {
	return competencias;
    }

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
	Docente other = (Docente) obj;
	return Objects.equals(dni, other.dni);
    }

}