# Sesión # 17: Componente Práctico

LactoCaribe Ltda. usa 5 camiones para la distribución de leche a sus 10 puntos de distribución.
La empresa se encuentra interesada en medir la eficiencia de cada uno de los 5 camiones. Por este motivo, LactoCaribe te solicita crear un sistema que dada una matriz de asignación con los siguientes campos: Punto de distribución, Identificación de camión, Cantidad de litros asignados, Tiempo de despacho asignado, y una matriz de registro con los siguientes campos: Punto de distribución, Identificación de camión, Cantidad de litros despachados y Tiempo de despacho registrado calcule los siguientes indicadores de desempeño para cada camión:

1. Eficiencia en tiempos de despacho = (Tiempo de despacho registrado) / Tiempo de despacho asignado x 100
2. Tasa de entrega (Lt/min) = Cantidad de litros despachados / Tiempo total de despacho
3. Nivel de Cumplimiento de los despachos = Litros despachados / Total de litros asignados x 100

### Actividad

Usando los conceptos aprendidos dentro del curso:

1. Diseña la solución al problema presentado
2. Codifica la solución
3. Durante la etapa de pruebas, el usuario requiere que modifiques la solución para incluir las siguientes validaciones
    * Que los valores de litros y tiempos asignados no sean 0 o negativos.
    * Que los valores de litros y tiempos de despache no sean 0 o negativos.
    * Si una de las condiciones no se cumple, el valor incluido para ese punto de distribución y para ese camión deberá ser ignorado en el cálculo.

