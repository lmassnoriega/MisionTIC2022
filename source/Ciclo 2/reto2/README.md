# RETO 2.52

> Nombre del reto:	Lector del nivel de la calidad del agua en el Atlántico

## Descripción de reto con su respectiva solución:

En el año 2015, los líderes mundiales adoptaron un conjunto de objetivos globales para erradicar la pobreza, proteger el planeta y asegurar la prosperidad para todos como parte de una nueva agenda de desarrollo sostenible. Cada objetivo tiene metas específicas que deben alcanzarse en los próximos 15 años.

El departamento del Atlántico se ha comprometido con esta causa y por ello ha decidido adoptar estos retos, se lista uno de los principales relacionados con el agua potable:

De aquí a 2030, se busca lograr el acceso universal y equitativo al agua potable a un precio asequible para todos.

Algunas ONG’s se atribuyeron la tarea de poder diseñar un dispositivo para analizar la calidad del agua de poblaciones apartadas. Para comenzar, requieren que el dispositivo cuente con un lector de la calidad del agua. Después de la lectura, el dispositivo nos entrega el índice de riesgo de la calidad del agua, IRCA, y según este resultado debe indicar el nivel de riesgo.

|Clasificación IRCA (%)	| Nivel de riesgo	|Entidades a notificar|	Entidades a tomar acciones |
|:---:|:-----:|:-----:|:-----:|
|80.1 - 100 | INVIABLE SANITARIAMENTE | Persona prestadora, COVE, Alcaldía, Gobernación, SSPD, MPS, INS, MAVDT, Contraloría General, Procuraduría General | Persona prestadora, alcaldía, gobernación, entidades de orden territorial |
| 35.1 - 80 |  ALTO | Persona prestadora, COVE, Alcaldía, Gobernación, SSPD | Persona prestadora,alcaldía, gobernación |
| 14.1 - 35 | MEDIO | Persona prestadora, COVE, Alcaldía, Gobernación | Persona prestadora |
| 5.1 - 14 | BAJO |	Persona prestadora, COVE | Persona prestadora |
| 0 - 5 | SIN RIESGO | Continuar el control y la vigilancia | Continuar vigilancia

Se requiere que usted desarrolle un programa que debe realizar lo siguiente:

* Leer la cantidad de cuerpos de agua a analizar.
* Leer y almacenar el nombre de cada cuerpo de agua (siempre será una sola palabra), número con el que se identifica, el municipio del que forma parte (Siempre será una sola palabra) y la clasificación IRCA. Haga Split con espacio *“ ”* (Ver entrada y salida).

Una vez leídos los datos:

* Indicar la clasificación IRCA de cada cuerpo de agua.
* Indicar cuántos cuerpos de agua tienen un nivel de riesgo entre SIN RIESGO y BAJO.
* Indicar el nombre de los cuerpos de agua que tienen un nivel de riesgo SIN RIESGO separados por espacio, en caso de no haber ninguno devolver NA.
* Indicar la clasificación IRCA promedio de todos los cuerpos de agua ingresados.

En cuanto al diseño del programa se debe realizar lo siguiente:

* Implementar POO creando una clase llamada CuerpoDeAgua.
* Implementar un método dentro de la clase CuerpoDeAgua llamado nivel que calcule el nivel de riesgo de un cuerpo de agua de acuerdo con los valores de la instancia. 

Ejemplo: 

|Nombre | Id_cuerpo_agua | Municipio |IRCA |
| :--: | :--: | :--: | :--: |
| Mallorquin | 0 | Barranquilla | 30 |
| Magdalena | 1 |Barranquilla | 45.3 |

```
Cuerpo de agua 1:
IRCA: 30

Cuerpo de agua 2:
IRCA: 45.3

Número de cuerpos de agua que tienen un nivel de riesgo entre SIN RIESGO y BAJO: 0

Nombres de los cuerpos de agua que tienen un nivel de riesgo SIN RIESGO: NA

Clasificación IRCA promedio de todos los cuerpos de agua ingresados: 37.65
```

### Formato entrada y salida esperadas:

<table>
    <thead>
        <tr>
            <td align=center><b>Entrada esperada</b></td>
            <td align=center><b>Salida esperada</b></td>
        </tr>
    <thead>
    <tbody>
        <tr>
            <td rowspan=5 align=center>
                <p>2</p>
                <p>Mallorquin 0 Barranquilla 30</p>
                <p>Magdalena 1 Barranquilla 45.3</p>
            </td>
            <td align=center>30.00</td>
        </tr>
        <tr>
            <td align=center>45.30</td>
        </tr>
        <tr>
            <td align=center>0.00</td>
        </tr>
        <tr>
            <td align=center>NA</td>
        </tr>
        <tr>
            <td align=center>37.65</td>
        </tr>
    </tbody>
</table>

**Nota:** Por favor NO incluya mensajes en los inputs.

**Nota:** Las tildes y cualquier otro signo ortográfico han sido omitidos a propósito en las entradas y salidas del programa. Por favor NO use ningún signo ortográfico dentro del desarrollo de su solución ya que estos pueden representar errores en la calificación automática de Codegrade.

**Nota:** Leer todo como ```nextLine()``` y luego convertir los datos al tipo de variable necesario.

**Nota:** El archivo de la clase debe llamarse **```CuerpoDeAgua.java```** y el principal **```reto2.java```**, de lo contrario no podrán ser cargados en la plataforma de Codegrade.

**Nota:** En caso de haber salidas numéricas todas deben estar formateadas a dos cifras decimales.
