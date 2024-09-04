package ar.edu.unlam.pb2.educacion;

public class Docente {

    private String nombre;
    private Integer dni;
    private Integer aniosExperiencia;
    private Competencias competenciaMaxima;

    public Docente(String nombre, Integer dni, Integer aniosExperiencia, Competencias competenciaMaxima) {
	this.nombre = nombre;
	this.dni = dni;
	this.competenciaMaxima = competenciaMaxima;
	this.aniosExperiencia = aniosExperiencia;
    }

    public String getNombre() {
	return this.nombre;
    }

    public Integer getAniosExperiencia() {
	return aniosExperiencia;
    }

    public Competencias getCompetenciaMaxima() {
	return competenciaMaxima;
    }
}