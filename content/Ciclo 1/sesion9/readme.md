# Sesión # 9: Componente Práctico

## Para

El ciclo Para o For en Python nos ayuda a ejecutar dentro de un rango determinado de iteraciones.  Esto es particularmente útil cuando usamos estructuras de datos que son inherentement "ordenadas"; listas, colecciones, cadenas de caracteres, etc.

En la semana uno exploramos el tipo de dato string (una cadena de caracteres). Los caracteres dentro de este tipo de dato en Python pueden ser recorridos con la posición en la que se encuentran dentro de la cadena. Veamos un ejemplo:

``` python
def ejemplo1():
    palabra = "Prueba"
    longitud = len(palabra)

    print("Primer ciclo")
    for i in range(longitud):
        print(palabra[i])

    print("Segundo ciclo")
    for x in "Prueba":
        print(x)
```

Vamos a modificar este ejemplo para conocer la longitud de la palabra y validar la ubicación de cada valor dentro de la cadena.

``` python
def ejemplo2():
    palabra = "Prueba"
    longitud = len(palabra)

    print("Longitud", longitud)

    for i in range(longitud):
        print(i,palabra[i])
```

### Actividades: 

**Actividad 1:** Vamos a realizar un algoritmo que nos calcule la serie de Fibonacci. La serie o secuencia de Fibonacci comienza con los números 0 y 1 y 1, y a partir de allí es posible calcular el siguiente valor como la suma de los dos valores anteriores. 

*Por ejemplo, 1+1=2, 1+2=3, 2+3=5, etc.*

Así, los primeros números de la secuencia son: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

Creemos un programa que a partir de un número N ingresado, imprima los primeros N números de la serie de Fibonacci.

**Actividad 2:** Escribe el código usando break que reciba una palabra e imprima el número de letras que tiene y las letras hasta que, o bien termine la palabra o encuentre la letra a.

**Actividad 3:** Escribe un algoritmo que lea 10 números e imprima cuantos son positivos, cuantos negativos y cuantos neutros(0).

**Actividad 4:** Usando tanto while como for, escribe el código que pida números al usuario hasta que este ingrese -1 y que retorne el factorial de cada número ingresado usando un ciclo Para (For).

