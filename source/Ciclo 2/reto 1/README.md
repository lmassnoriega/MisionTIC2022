# RETO 1.52

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


Se requiere leer un vector de tamaño n de entrada en el que cada elemento indique el porcentaje de la clasificación IRCA.

El algoritmo debe ser capaz de responder a las siguientes preguntas:

* ¿Cuál es en promedio el nivel de riesgo de la calidad del agua según los datos ingresados?
* ¿Cuál es la clasificación IRCA promedio?
* ¿Cuál es el nivel de riesgo de la calidad del agua más común encontrado? En caso de haber dos o más niveles igual de comunes tomar el más bajo.

Para el caso donde el porcentaje del IRCA tenga una lectura entre 0 - 5, el programa debe devolver el siguiente mensaje: “Continuar el control y la vigilancia”.

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
            <td rowspan=3 align=center>
                <p>6</p>
                <p>5.1 36 25 70 55 18</p>
            </td>
            <td align=center>MEDIO</td>
        </tr>
        <tr>
            <td align=center>34.85</td>
        </tr>
        <tr>
            <td align=center>ALTO</td>
        </tr>
    </tbody>
</table>

## Instrucciones Reto 1

* **Nota:** *Por favor NO incluya mensajes en los inputs.*
* **Nota:** *Las tildes y cualquier otro signo ortográfico han sido omitidos a propósito en las entradas y salidas del programa. Por favor NO use ningún signo ortográfico dentro del desarrollo de su solución ya que estos pueden representar errores en la calificación automática de Codegrade.*
* **Nota:** *El archivo debe llamarse reto1.java, de lo contrario no podrá ser cargado en la plataforma de Codegrade*
* **Nota:** *En caso de haber salidas numéricas todas deben estar formateadas a dos cifras decimales.*
