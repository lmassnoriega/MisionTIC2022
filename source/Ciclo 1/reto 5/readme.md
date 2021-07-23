# Reto 5.68

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

Para esta nueva etapa del desarrollo se consolidaron las características del suelo de distintas zonas de las capitales del país. Estas se encuentran en un archivo llamado ```data.csv``` que cuenta con las siguientes columnas:

* Capital: nombre de la ciudad capital
* ID Zona: identificador de la zona, numerado de 0 – 3124 por cada ciudad
* Altura sobre el nivel del mar: el valor obtenido de la altura en esa zona
* Temperatura media anual: el valor obtenido de la temperatura en esa zona
* Precipitación anual: el valor obtenido de la precipitación en esa zona
* Profundidad efectiva del suelo: el valor obtenido de la profundidad en esa zona
* Aptitud: si la zona es sumamente, marginalmente, moderadamente o no apta

La aptitud se calculó analizando los valores para:
* Temperatura media anual
* Profundidad efectiva del suelo

Y se tuvo en cuenta el siguiente criterio para la conclusión:
* Si ambas variables se encuentran dentro de la misma categoría se escogerá la categoría.
* Si están en categorías diferentes se escogerá la peor de ellas.

El estudiante deberá:

* Leer una ciudad

Y para esta ciudad deberá:

* Imprimir el promedio de las variables analizadas separadas por espacio, y formateadas a dos cifras decimales
* Imprimir el mínimo de ambas variables separadas por un espacio
* Imprimir el máximo de ambas variables separadas por un espacio
* Imprimir el conteo de cada categoría. Se deberán imprimir las categorías de mayor a menos conteo. Si se encuentran dos categorías con el mismo valor se imprimirán de manera alfabética ascendente

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
                Barranquilla
            </td>
            <td align=center>
                <p>28.98 61.72</p>
                <p>14 15</p>
                <p>44 109</p>
                <p>no apto 1789</p>
                <p>marginalmente apto 724</p>
                <p>moderadamente apto 574</p>
                <p>sumamente apto 38</p>
            </td>
        </tr>
    </tbody>
</table>

* **Nota:** tenga en cuenta que múltiples valores de entradas pueden estar en una misma línea separados por espacios.
* **Nota:** Por favor **NO** incluya mensajes en los inputs.
* **Nota:** Las tildes y cualquier otro signo ortográfico han sido omitidos a propósito en las entradas y salidas del programa. Por favor **NO** use ningún signo dentro del desarrollo de su solución ya que estos pueden representar errores en la calificación automática de Codegrade.
* **Nota:** El archivo debe llamarse **```reto5.py```**, de lo contrario no podrá ser cargado en la plataforma de Codegrade.
* **Nota:** El archivo **```data.csv```** debe encontrarse en la misma carpeta donde se encuentra el archivo **```reto5.py```** y debe leerse usando la ruta relativa del mismo