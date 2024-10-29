package ar.edu.unlam.pb2.educacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Docente {

    private String nombre;
    private Integer dni;
    private List<Competencias> competencias;

    public Docente(String nombre, Integer dni) {
	this.nombre = nombre;
	this.dni = dni;
	this.competencias = new ArrayList<Competencias>();
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
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Docente other = (Docente) obj;
	return Objects.equals(dni, other.dni);
    }

}