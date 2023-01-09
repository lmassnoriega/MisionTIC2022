# RETO 3.52

> Nombre del reto:	Lector del nivel de la calidad del agua en el Atlántico

## Instrucciones del Desarrollador

Para ejecutar este programa con minimos cambios, establezca la ruta de las librerias de JavaFX a la siguiente ubicación.

> C:/JavaFX/lib/

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
* Leer y almacenar el tipo de agua (dulce o salada), tipo de cuerpo de agua (arroyo, laguna, lago, rio, oceano, etc), nombre de cada cuerpo de agua (siempre será una sola palabra), número con el que se identifica, el municipio del que forma parte (Siempre será una sola palabra) y la clasificación IRCA. Haga Split con espacio *“ ”* (Ver entrada y salida).

Una vez leídos los datos:

* Indicar la clasificación IRCA de cada cuerpo de agua.
* Indicar cuántos cuerpos de agua tienen un nivel de riesgo entre SIN RIESGO y BAJO.
* Indicar el nombre de los cuerpos de agua que tienen un nivel de riesgo SIN RIESGO separados por espacio, en caso de no haber ninguno devolver NA.
* Indicar la clasificación IRCA promedio de todos los cuerpos de agua ingresados.

En cuanto al diseño del programa se debe realizar lo siguiente:

1. Implementar POO creando una superclase llamada **ObjetoGeografico**.
2. Implementar POO creando una subclase llamada **CuerpoDeAgua** que extienda de *ObjetoGeografico*.
3. Implementar un método dentro de la clase *CuerpoDeAgua* llamado nivel que calcule el nivel de riesgo de un cuerpo de agua de acuerdo con los valores de la instancia. 
4. Implementar una clase llamada ***```reto3```*** en donde se encuentre el método principal de ejecución del programa, y donde se instancien los objetos de tipo CuerpoDeAgua.

### Ejemplo: 

| Nombre | Tipo_agua | Tipo_cuerpo | Id	Municipio | IRCA |
| :----: | :----: | :----: | :----: | :----: |
| Mallorquin | Dulce | Cienaga 0 | Barranquilla | 30|
| Magdalena | Dulce | Rio 1 | Barranquilla | 45.3 |

*Cuerpo de agua 1:*

IRCA: 30

*Cuerpo de agua 2:*

IRCA: 45.3

Número de cuerpos de agua que tienen un nivel de riesgo entre SIN RIESGO y BAJO: 0

Nombres de los cuerpos de agua que tienen un nivel de riesgo SIN RIESGO: NA

Clasificación IRCA promedio de todos los cuerpos de agua ingresados: 37.65

### Formato entrada y salida esperadas:

|Entrada Esperada | Salida Esperada |
|:----:|:-----:|
| <p>2</p> <p>Mallorquin 0 Barranquilla 30</p> <p>Magdalena 1 Barranquilla 45.3</p>| <p>30.00</p> <p>45.30</p> <p>0.00</p><p>NA</p><p>37.65</p>|

Adicionalmente se debe diseñar una interfaz de usuario grafica por medio de la cual se ingresen los datos al programa y cuyos requerimientos mínimos sean:

* Utilizar campos de texto para ingresar los datos.
* Utilizar labels para identificar correctamente las entradas o cualquier información que se desee brinda.
* Utilizar botones para procesas los datos ingresados.

### Ejemplo de posible interfaz 🚀

 ![Interfaz Sugerida](img/reto3.png)

En la interfaz presentada, el botón Ingresar incluye los datos en el campo de Datos ingresados y el botón procesar calcula la salida esperada y la muestra en el campo de Salidas.

**NOTA:** Es importante seleccionar los tipos adecuados para cada método, ya que esto puede generar errores a la hora de calificar.

**NOTA:** Tener en cuenta que esto es solo una sugerencia y no es necesario replicarla al con exactitud. Usted puede presentar su propio diseño que cumpla con los requerimientos mínimos solicitados para la interfaz de usuario grafica.
