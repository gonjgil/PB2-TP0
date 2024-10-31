package ar.edu.unlam.pb2.enums;

public enum Niveles {

	NINGUNO(1), CELESTE(2), VERDE(3), AZUL(4), ROJO(5), PRIMERO_P(6), SEGUNDO_P(7), TERCERO_P(8), CUARTO_P(9),
	QUINTO_P(10), SEXTO_P(11), PRIMERO_S(12), SEGUNDO_S(14), TERCERO_S(14), CUARTO_S(15), QUINTO_S(16), SEXTO_S(17);

	private final Integer edad;

	Niveles(Integer edad) {
		this.edad = edad;
	}

	public Integer getEdadRequerida() {
		return this.edad;
	}
}
