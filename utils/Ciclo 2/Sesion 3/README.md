# Sesión # 3: Componente Práctico

Una determinada empresa con varias sedes en una ciudad tiene dentro de su información 1 lista, y 2 tablas que  corresponden a:

1. Lista con el código del producto.
2. Tabla con la cantidad en bodega del producto para el conjunto de sedes.
3. Tabla con la cantidad mínima requerida del producto para el mismo conjunto de sedes.

Es decir

A continuación se detallan los datos para 3 productos en 4 sedes.

Lista de códigos

<table>
    <thead>
    </thead>
    <tbody>
        <tr>
            <td> 354 </td>
            <td> 256 </td>
            <td> 127 </td>
        </tr>
    </tbody>
</table>

Tabla de la cantidad en bodega

<table>
    <thead>
    </thead>
    <tbody>
        <tr>
            <td> 17 </td>
            <td> 34 </td>
            <td> 60 </td>
        </tr>
        <tr>
            <td> 14 </td>
            <td> 31 </td>
            <td> 65 </td>
        </tr>
        <tr>
            <td> 45 </td>
            <td> 23 </td>
            <td> 2 </td>
        </tr>
        <tr>
            <td> 56 </td>
            <td> 43 </td>
            <td> 8 </td>
        </tr>
    </tbody>
</table>

Tabla de la cantidad mínima requerida

<table>
    <thead>
    </thead>
    <tbody>
        <tr>
            <td> 14 </td>
            <td> 44 </td>
            <td> 76 </td>
        </tr>
        <tr>
            <td> 10 </td>
            <td> 51 </td>
            <td> 15 </td>
        </tr>
        <tr>
            <td> 46 </td>
            <td> 23 </td>
            <td> 2 </td>
        </tr>
        <tr>
            <td> 89 </td>
            <td> 4 </td>
            <td> 18 </td>
        </tr>
    </tbody>
</table>

Para el sistema de inventario es importante conocer si es necesario solicitar un determinado producto a su proveedor de acuerdo a la cantidad mínima requerida. 

Se solicita diseñar un algoritmo que:

* Lea la lista de los códigos.
* Lea las dos tablas mencionadas.
* Almacene la lista en un vector y cada tabla en una matriz.

Una vez leídos los datos:

* Indique los códigos de los productos de los cuales se deben realizar los pedidos, especificando el número de la sede. El número de sede corresponde al número de la fila en la tabla.
* El promedio de las cantidades de cada producto en bodega y su respectivo código.

*Nota: para facilitar el proceso de lectura, leer los códigos en una sola línea separados por coma, la tabla de cantidad en bodega leerla en una sola línea separando las filas por punto y coma y números por espacio.*

Es decir, para el ejemplo anteriormente descrito las entradas serán 3:

```
354 256 127

17 34 60;14 31 65;45 2 12;56 43 8

14 44 76;10 51 15;46 23 2;89 4 18
``` 
Y las salidas serán:

```
Se debe solicitar producto 256 en sede 0
Se debe solicitar producto 127 en sede 0
Se debe solicitar producto 256 en sede 1
Se debe solicitar producto 354 en sede 2
Se debe solicitar producto 256 en sede 2
Se debe solicitar producto 354 en sede 3
Se debe solicitar producto 127 en sede 3

El promedio de productos del codigo 354 es 27.75
El promedio de productos del codigo 256 es 27.5
El promedio de productos del codigo 127 es 14.75
```
