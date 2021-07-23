# Reto 2.68

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

Para esta nueva fase se requiere un estudio más a fondo, por lo cual, el programa debe tener múltiples lecturas de la temperatura media anual y profundidad efectiva del suelo de las zonas que se están analizando y arroje los siguientes resultados:

* Promedio de la temperatura media anual formateado a dos cifras decimales
* Promedio de la profundidad efectiva del suelo formateado a dos cifras decimales
* Conteo de las categorías resultantes

El número de lecturas que el programa tendrá en cuenta debe ser una variable de entrada. El criterio para la conclusión será el siguiente:

* Si ambas variables se encuentran dentro de la misma categoría se escogerá la categoría.
* Si están en categorías diferentes se escogerá la peor de ellas.

Ejemplos:

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
                <p>29 73</p>
                <p>45 40</p>
                <p>26 150</p>
            </td>
            <td align=center>
                <p>33.33</p>
                <p>87.67</p>
                <p>sumamente apto 1</p>
                <p>moderadamente apto 1</p>
                <p>marginalmente apto 0</p>
                <p>no apto 1</p>
            </td>
        </tr>
        <tr>
            <td align=center>
                <p>2</p>
                <p>22 67</p>
                <p>9 20</p>
            </td>
            <td align=center>
                <p>15.50</p>
                <p>43.50</p>
                <p>sumamente apto 0</p>
                <p>moderadamente apto 1</p>
                <p>marginalmente apto 0</p>
                <p>no apto 1</p>
            </td>
        </tr>
    </tbody>
</table>

**Nota:** Ten en cuenta que cada variable debe ser manejada como una entrada diferente. A continuación, ejemplificamos cómo debes hacerlo y cómo no.

***No lo hagas así:***

```python
var_1 = valor1 valor2 valor3
```

***Hazlo así:***

```python
var_1 = valor1
var_2 = valor2
var_3 = valor3
```
* **Nota:** Por favor **NO** incluya mensajes en los inputs.
* **Nota:** Las tildes y cualquier otro signo ortográfico han sido omitidos a propósito en las entradas y salidas del programa. Por favor **NO** use ningún signo dentro del desarrollo de su solución ya que estos pueden representar errores en la calificación automática de Codegrade.
* **Nota:** El archivo debe llamarse ```reto2.py```, de lo contrario no podrá ser cargado en la plataforma de Codegrade.