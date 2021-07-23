# Reto 3.68

> Nombre del reto: Estudio de condiciones para plantaciones de cacao

> Autor reto: Jhon Jaime de Jesús Corro Pareja

## Descripción del reto con su respectiva solución:

En el año 2015, los líderes mundiales adoptaron un conjunto de objetivos globales para erradicar la pobreza, proteger el planeta y asegurar la prosperidad para todos como parte de una nueva agenda de desarrollo sostenible. Para el 2030, se busca luchar contra la desertificación, rehabilitar las tierras y los suelos degradados, incluidas de las tierras afectadas por la desertificación, la sequía y las inundaciones, y procurar lograr un mundo con una degradación neutra del suelo.

El Ministerio de Agricultura y Desarrollo Rural busca recuperar los suelos para el cultivo del cacao. Para poder cumplir con esto han iniciado el análisis para las características del entorno donde se tiene previsto iniciar las plantaciones. Para esta tarea lo requieren a usted y se facilita una tabla que describe si el entorno es apto o no.

| CARACTERISTICAS | SUMAMENTE APTO | MODERADAMENTE APTO | MARGINALMENTE APTO | NO APTO|
| :----:| :----:| :----:| :----:| :----:|
| **Altura sobre el nivel del mar (m.s.n.m)**| 400 - 800 | < 400 o 801 - 999 | 1000 - 1200 | > 1200|
| **Temperatura media anual (°C)**| 25 - 28 | 29 - 30 o 24 - 21 | 31 - 32 o 20 - 18 | < 18 o > 32 |
| **Precipitación anual (mm)**| 1800 - 2599 | 2600 - 3199 o 1799 - 1500 | 3200 - 3800 o 1499 - 1200 | < 1200 o > 3800 |
| **Profundidad efectiva del suelo (cm)** | > 100 | 50 - 100 | 25 - 50 | < 25|

Para esta nueva fase se requiere un estudio más a fondo. Ahora programa leerá dos listados por zonas estudiadas. El primer listado serán valores correspondientes a la temperatura media anual y el segundo serán valores correspondientes a la profundidad efectiva del suelo. Para cada listado usted deberá:

* Calcular el promedio y formatearlo a dos cifras decimales
* Imprimir los promedios calculados en una misma línea separados por espacio

A partir de los promedios se debe realizar el análisis de la calidad del suelo e indicar el conteo de los resultados obtenidos.

* El número de zonas que el programa tendrá en cuenta debe ser una variable de entrada.
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
                <p>17 28 15 20</p>
                <p>44 100 48 83</p>
                <p>37 38 22 39</p>
                <p>23 69 109 46</p>
                <p>29 34 21 31</p>
                <p>81 33 40 109</p>
            </td>
            <td align=center>
                <p>20.00 34.00 28.75</p>
                <p>68.75 61.75 65.75</p>
                <p>sumamente apto 0</p>
                <p>moderadamente apto 1</p>
                <p>marginalmente apto 1</p>
                <p>no apto 1</p>
            </td>
        </tr>
        <tr>
            <td align=center>
                <p>5</p>
                <p>17 30 34 37 39 17 19 37</p>
                <p>81 47 36 39 44 38 41 108</p>
                <p>15 37 36 39 39 20 38 29</p>
                <p>61 21 24 47 50 56 46 86</p>
                <p>27 17 26 16 16 23 28 25</p>
                <p>33 92 73 77 27 86 17 67</p>
                <p>23 32 17 23 23 19 36 33</p>
                <p>53 81 94 67 58 40 58 106</p>
                <p>36 30 29 29 36 15 29 19</p>
                <p>43 24 35 88 71 87 15 23</p>
            </td>
            <td align=center>
                <p>28.75 31.62 22.25 25.75 27.88</p>
                <p>54.25 48.88 59.00 69.62 48.25</p>
                <p>sumamente apto 0</p>
                <p>moderadamente apto 3</p>
                <p>marginalmente apto 2</p>
                <p>no apto 0</p>
            </td>
        </tr>
    </tbody>
</table>

* **Nota:** tenga en cuenta que múltiples valores de entradas pueden estar en una misma línea separados por espacios.
* **Nota:** Por favor **NO** incluya mensajes en los inputs.
* **Nota:** Las tildes y cualquier otro signo ortográfico han sido omitidos a propósito en las entradas y salidas del programa. Por favor **NO** use ningún signo dentro del desarrollo de su solución ya que estos pueden representar errores en la calificación automática de Codegrade.
* **Nota:** El archivo debe llamarse ```reto3.py```, de lo contrario no podrá ser cargado en la plataforma de Codegrade.