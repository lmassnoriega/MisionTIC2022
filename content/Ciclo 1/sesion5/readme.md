# Sesión # 5: Componente Práctico

Cada ejemplo y actividad será definida como una función independiente. La función principal será definida al final del archivo.

## Si-Sino-Finsi:

Recuerda que los condicionales múltiples y anidados nos permiten evaluar múltiples casos.  El condicional Si-Sino-Si-Finsi tiene la siguiente estructura:

    Si (condición) Entonces
        instrucción(es)
    Sino Si
        instrucción(es)
    Fin Si

En Python, esto se escribe un poco diferente y la estructura general depende de las tabulaciones. Por ejemplo:

``` python
def ejemplo1():
    x = int(input("Por favor ingresa un número: "))
    if x < 0:
        print('El número es Negativo')
    elif x > 0:
        print('El número es positivo')
    elif x == 0:
        print('El número es cero')
```

## Actividades: 

**Actividad 1:** Escribe el código que imprima un comando dada la luz del semáforo

* Verde = Siga
* Amarillo = Precaución
* Rojo = Pare

**Actividad 2:**  Escribe el código que basado en la actividad 1 y una variable que nos indica si hay peatón o no (hayPeaton), imprima:

* Verde -------- Si hay peatón: Pare, Sino: Siga
* Amarillo ----------- Si hay peatón: Pare, Sino: Precaución
* Rojo = Pare

**Actividad 3:** Escribe el código para dos números a y b, el usuario va a seleccionar una opción: 1 para sumar, 2 para multiplicar, 3 para restar (a-b) y 4 para dividir (a/b) y retornar el resultado de la operación indicada.

