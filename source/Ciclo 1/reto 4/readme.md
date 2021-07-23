# Reto 4.68

> Nombre del reto: Estudio de condiciones para plantaciones de cacao

> Autor reto: Jhon Jaime de Jesús Corro Pareja

## Descripción del reto con su respectiva solución:

En el año 2015, los líderes mundiales adoptaron un conjunto de objetivos globales para erradicar la pobreza, proteger el planeta y asegurar la prosperidad para todos como parte de una nueva agenda de desarrollo sostenible. Para el 2030, se busca luchar contra la desertificación, rehabilitar las tierras y los suelos degradados, incluidas de las tierras afectadas por la desertificación, la sequía y las inundaciones, y procurar lograr un mundo con una degradación neutra del suelo.

El Ministerio de Agricultura y Desarrollo Rural busca recuperar los suelos para el cultivo del cacao. Para poder cumplir con esto han iniciado el análisis para las características del entorno donde se tiene previsto iniciar las plantaciones. Para esta tarea lo requieren a usted y se facilita una tabla que describe si el entorno es apto o no.

| CARACTERISTICAS | SUMAMENTE APTO | MODERADAMENTE APTO | MARGINALMENTE APTO | NO APTO|
| :----:| :----:| :----:| :----:| :----:|
| **Altura sobre el nivel del mar (m.s.n.m)**| [400 - 800] | < 400 o (800 - 999] | (999 - 1200] | > 1200|
| **Temperatura media anual (°C)**| (24 - 28] | (28 - 30] o [24 - 20) | (30 - 32] o [20 - 18] | < 18 o > 32 |
| **Precipitación anual (mm)**| (1799 - 2599] | (2599 - 3199] o [1799 - 1499) | (3199 - 3800] o [1499 - 1200] | < 1200 o > 3800 |
| **Profundidad efectiva del suelo (cm)** | > 100 | (50 - 100] | [25 - 50] | < 25|

Para esta nueva fase se requiere un estudio más a fondo. Ahora se cuenta con dos matrices, estas llevan registros de diferentes medidas de una zona a lo largo de una semana de temperatura media anual y la profundidad efectiva del suelo. 

***Temperatura***

|Día 1|Día 2|Día 3|Día 4|Día 5|Día 6|Día 7|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Temperatura 1,1|Temperatura 1,2|Temperatura 1,3|Temperatura 1,4|Temperatura 1,5|Temperatura 1,6|Temperatura 1,7|
|Temperatura 2,1|Temperatura 2,2|Temperatura 2,3|Temperatura 2,4|Temperatura 2,5|Temperatura 2,6|Temperatura 2,7|
|...|...|...|...|...|...|...|
|Temperatura N,1|Temperatura N,2|Temperatura N,3|Temperatura N,4|Temperatura N,5|Temperatura N,6|Temperatura N,7|

***Profundidad***

|Día 1|Día 2|Día 3|Día 4|Día 5|Día 6|Día 7|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Profundidad 1,1|Profundidad 1,2|Profundidad 1,3|Profundidad 1,4|Profundidad 1,5|Profundidad 1,6|Profundidad 1,7|
|Profundidad 2,1|Profundidad 2,2|Profundidad 2,3|Profundidad 2,4|Profundidad 2,5|Profundidad 2,6|Profundidad 2,7|
|...|...|...|...|...|...|...|
|Profundidad N,1|Profundidad N,2|Profundidad N,3|Profundidad N,4|Profundidad N,5|Profundidad N,6|Profundidad N,7|

Las posiciones correspondientes en cada matriz hacen referencia a una misma lectura, es decir, temperatura 2,3 y profundidad 2,3 hacen referencia los valores obtenidos en la zona 2 en el día 3.

El número de zonas a analizar se debe leer como un parámetro de entrada, seguida la matriz de temperaturas y por último la matriz de profundidades.

Se debe mostrar por pantalla:

* El conteo total de las categorías, separados por espacio, a las que pertenecen las lecturas de las matrices en el siguiente orden: no apto, marginalmente apto, moderadamente apto, sumamente apto.
* La categoría que más se presentó por cada zona, separadas por coma. En caso de que existan dos, escoger la mejor categoría.
* La categoría que menos se presentó por cada zona, separadas por coma. En caso de que existan dos, escoger la mejor categoría.
* El criterio para la conclusión será el siguiente:
    * Si ambas variables se encuentran dentro de la misma categoría se escogerá la categoría.
    * Si están en categorías diferentes se escogerá la peor de ellas.

### Ejemplos:

<table>
    <thead>
        <tr>
            <td align=center><b>Entrada esperada</b></td>
            <td align=center><b>Salida esperada</b></td>
        </tr>
    <thead>
    <tbody>
        <tr>
            <td align=center>
                <p>3</p>
                <p>24 19 34 30 37 42 36</p>
                <p>31 20 26 24 30 24 42</p>
                <p>43 36 31 44 44 35 32</p>
                <p>71 59 100 103 95 38 62</p>
                <p>64 54 61 40 22 77 103</p>
                <p>39 27 66 46 63 26 46</p>
            </td>
            <td align=center>
                <p>11 6 4 0</p>
                <p>no apto,marginalmente apto,no apto</p>
                <p>marginalmente apto,moderadamente apto,marginalmente apto</p>
            </td>
        </tr>
    </tbody>
</table>

* **Nota:** tenga en cuenta que múltiples valores de entradas pueden estar en una misma línea separados por espacios.
* **Nota:** Por favor **NO** incluya mensajes en los inputs.
* **Nota:** Las tildes y cualquier otro signo ortográfico han sido omitidos a propósito en las entradas y salidas del programa. Por favor **NO** use ningún signo dentro del desarrollo de su solución ya que estos pueden representar errores en la calificación automática de Codegrade.
* **Nota:** El archivo debe llamarse ```reto4.py```, de lo contrario no podrá ser cargado en la plataforma de Codegrade.