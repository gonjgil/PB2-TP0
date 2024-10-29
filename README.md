# PB2-TP0

##### Trabajo práctico 0 - Nivelación

  1. El objetivo de este trabajo consiste en establecer una nivelación en el inicio de la cursada de PBII.
  2. Se debe presentar una solución escrita en el lenguaje Java, aplicando todos los conceptos vistos en Programación Básica I.
  3. No se puede utilizar los siguientes aspectos:
 
  a. ~Git~
  
  b. ~Junit~
  
  c. ~Herencia~
  
  d. Polimorfismo
  
  e. Interfaces
  
  f. Colecciones (~Lists, Sets~ o Maps)
  
  g. Excepciones
  

Enunciado
Nos contratan para desarrollar un software que permita gestionar una institución educativa que cuenta (o puede contar) con distintos niveles de educación:
    *** Jardín
    *** Primaria
    *** Secundaria

Cada tipo de “Curso” tiene características particulares:

#### Jardín (2 - 5)
  *** Condiciones de incorporación: Sin condiciones. 
  *** División: Los cursos se organizan en salas (Celeste, Verde, Azul y Roja) y si bien la organización es en función de la edad de los alumnos, si se observan salas de menos de 10 alumnos, podrían combinarse con alumnos de distintas edades. 
  *** Docente a cargo: Se cuenta con dos docente por salita, debiendo el docente ser competente para el cargo (Maestra o maestro jardinera/o).
  *** Evaluación: No hay.

#### Primaria (6 - 11)
  *** Condiciones de incorporación: La única condición es que el alumno cuente con la edad mínima requerida en cada curso (En condiciones normales los alumnos de la primaria tienen una edad de entre 6 y 11 años, pudiendo extenderse para el caso que un alumno requiera repetir la cursada de un grado en particular). 
  *** División: Los cursos se organizan en grados que van desde el primero al sexto. Si bien para poder inscribirse en un grado determinado, debería haber aprobado el grado inmediato anterior, por el momento la inscripción al grado será manual, pero debiéndose cumplir la edad mínima requerida para formar parte del grado. 
  *** Docente a cargo: Se cuenta con un docente por grado, debiendo el docente ser competente para el cargo (Debe haber presentado experiencia en el grado en particular, por ejemplo experiencia en chicos de tercer grado).
  *** Evaluación: A partir de la primaria, los alumnos pasan a ser evaluables, en el sentido que periódicamente deberán rendir una evaluación. La corrección de la evaluación puede estar a cargo del docente del curso, o cualquier otro docente que presente competencia para el grado en cuestión. (La evaluación deberá tener fecha, curso, nota)

#### Secundaria (12 -17)
  *** Condiciones de incorporación: Para inscribirse en un curso de la secundaria, primero se debe haber completado la primaria. Luego, se deben haber completado los cursos previos al que le corresponde. 
  *** División: Los cursos se organizan en divisiones que van desde el primer año al sexto. Si bien para poder inscribirse en un año determinado, debería haber aprobado el año inmediato anterior, por el momento la inscripción al grado será manual, pero debiéndose cumplir la edad mínima requerida para formar parte del año. 
  *** Docente a cargo: Se cuenta con un docente por cada materia que tendrá el curso, debiendo el docente ser competente para el cargo (Debe haber presentado experiencia en la materia para la que estará a cargo).
  *** Evaluación: Los alumnos son evaluables, en el sentido que periódicamente deberán rendir una evaluación por materia. La corrección de la evaluación puede estar a cargo del docente de la materia, o cualquier otro docente que presente competencia para la materia en cuestión. (La evaluación deberá tener fecha, curso, nota)

##### Sin prejuicio de en qué instancia del proceso educativo, el alumno se encuentre, siempre debe tener la posibilidad de asistir a clase. La asistencia debe quedar registrada y asociada a cada alumno, siendo la fecha la clave de identificación.

Además se pide:
  *** Obtener un listado de los alumnos por orden natural que están inscripto en los cursos, ordenado alfabéticamente A-Z por Apellido / nombre.
  *** Obtener un listado de los alumnos que están inscripto en los cursos, ordenado por dni de menor a mayor.
  *** Buscar a un alumno en una sala.
  *** Que la asistencia no se pueda registrar 2 veces para el mismo día / alumno.
  *** Utilizar herencia y polimorfismo en todos los casos que sean posibles. Implementar la clase Curso para contener alumnos y docentes.
  *** Utilizar las excepciones para los flujos no esperados de los métodos. Ejemplo: AlumnoInscriptoException, CantidadMaximaDocentesException, AlumnoNoEncontradoException.
  *** Tener en cuenta que los métodos de curso que tengan una característica única de sala, grado o división, debe tener su implementación en estas. Solo implementar en curso los métodos encomún, sino debería ser un método abstracto o estar definido en una interfaz. (aplicar esto a todo el trabajo)
  *** Además, una primaria tiene múltiples salas; y primaria es una Institución. Lo mismo para el resto.