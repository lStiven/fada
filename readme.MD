# Proyecto FADA
- Voraz: https://es.wikipedia.org/wiki/Algoritmo_voraz
- Dinamica https://es.wikipedia.org/wiki/Programaci%C3%B3n_din%C3%A1mica
- BackTracking https://es.wikipedia.org/wiki/Vuelta_atr%C3%A1s


 ### Facultad de Ingeniería
<p>
 Curso de Fundamentos de Análisis y Diseño de Algoritmo
 Proyecto de Curso Período Agosto – Diciembre de 2018
 Profesor Mauricio López Benítez 
</p>


__Objetivo:__
El proyecto final de este curso tiene
como propósito que el estudiante
aplique, mediante la aplicación de un
caso práctico, diferentes conceptos
aprendidos durante el desarrollo del
período académico y, de ésta manera,
lograr la consolidación de los objetivos
de formación del curso.

__Condiciones de entrega:__

La realización del proyecto se calificará
en una escala de 1 a 5, esta calificación
será grupal; también habrá una
sustentación individual del mismo que
será calificada en un rango entre 0 y 1.
La calificación final del proyecto
corresponde al producto de las dos
calificaciones obtenidas (la grupal y la
individual).

__Planteamiento del caso a tratar:__
Con motivo de la celebración de unas
justas deportivas mundiales a realizarse
en un pequeño país de Oriente Medio,
se requiere la construcción de villas
deportivas para alojar a las diferentes
selecciones participantes teniendo en
cuenta que:

    -Por cuestiones de logística varias selecciones se deben hospedar en la misma villa
    deportiva.
     
    -Dados los diferendos políticos, sociales, religiosos y de otra índole entre algunos países, por
    seguridad no es posible hospedar en una misma villa deportiva dos o más selecciones de países que no tengan
    relaciones diplomáticas amistosas.

    -Por cuestiones económicas y de disponibilidad de espacios, no es posible asignar una villa a una sola selección,
    a menos que sea estrictamente necesario. Por lo anterior requiere que usted, junto con su equipo de trabajo,
    implemente una herramienta computacional a la que se le suministren los datos de todas las selecciones,
    junto con sus restricciones (los países con los que no manejan relaciones diplomáticas amistosas); la
    aplicación deberá determinar la forma en que se deben asignar las selecciones en las diferentes villas teniendo en
    cuenta que el número mínimo de villas deportivas que se deben construir sea el mínimo.
    
__Formato de entrada:__
La entrada debe ser suministrada a través de una matriz cuadrada (M) de 1’s y 0’s en archivo de texto plano, donde
M[i,j] = 1 si los países i y j no tienen relaciones amistosas, en otro caso M[i,j]=0.

__Formato de salida:__
La salida debe expresarse en una matriz (S) de n x m (filas y columnas), tal que n representa las 
villas a construir y m las diferentes selecciones, y donde S[i,j]= 1 si en la villa i se aloja
la selección j, en otro caso S[i,j] = 0.


__Construcción de la solución y
presentación de resultados:__
Se requiere que usted implemente tres
soluciones utilizando tres estrategias de
programación diferentes, entre las que
deben estar la programación dinámica y
la Programación voraz.
