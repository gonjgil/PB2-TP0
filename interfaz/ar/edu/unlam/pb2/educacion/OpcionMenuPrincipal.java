package ar.edu.unlam.pb2.educacion;

public enum OpcionMenuPrincipal {
    PRIMERA("Primera opción"),
    SEGUNDA("Segunda opción"),
    TERCERA("Tercera opción"),
    SALIR("TERMINAR");
    private String texto;
    
    private OpcionMenuPrincipal(String texto) {
	this.texto = texto;
    }
    
    public String getTexto() {
	return texto;
    }
    
    public static OpcionMenuPrincipal obtenerOpcion(int opcion) {
	return OpcionMenuPrincipal.values()[opcion-1];
    }
    
    public static int min() {
	int minIndex =1;
	for(OpcionMenuPrincipal d: OpcionMenuPrincipal.values()) {
	    minIndex = Math.min(d.ordinal() + 1, minIndex);
	}
	return minIndex;
    }
    
    public static int max() {
	int maxIndex =1;
	for(OpcionMenuPrincipal d: OpcionMenuPrincipal.values()) {
	    maxIndex = Math.max(d.ordinal() + 1, maxIndex);
	}
	return maxIndex;
    }
    
    public String toString() {
	return (this.ordinal() + 1) + ") " + this.texto;
    }
}
