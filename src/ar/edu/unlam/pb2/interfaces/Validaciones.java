package ar.edu.unlam.pb2.interfaces;

import ar.edu.unlam.pb2.excepciones.EdadNoPermitidaException;
import ar.edu.unlam.pb2.excepciones.NivelInvalidoException;
import ar.edu.unlam.pb2.personas.Alumno;

public interface Validaciones {

// PREGUNTAR ver si es correcta la forma de implementar estas interfaces, y el criterio para hacerlo (TODAS las clases hijas tiene un metodo que actua diferente)
    Boolean validarEdad(Alumno alumno) throws EdadNoPermitidaException;
    
    Boolean validarNivel(Alumno alumno) throws NivelInvalidoException;
}


