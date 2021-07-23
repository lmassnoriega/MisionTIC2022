# Sesión # 4: Componente Práctico

## Ejercicio 1

Implementar una clase llamada Producto, la cual tenga los siguientes atributos y métodos:

### Atributos:

* Código
* Precio de compra
* Cantidad en bodega
* Cantidad mínima requerida en bodega.

### Métodos:

* Solicitar pedido: devuelva true si debe solicitar el producto al proveedor y false en caso contrario.

Diseñar un programa que:

* Solicite por consola el código del producto, el precio de compra, la cantidad en bodega y la cantidad mínima requerida.
* Instancie un producto dentro de la clase principal.
* Arroje una alerta en caso tal se deba solicitar el pedido al proveedor.

## Ejercicio 2

Cree una clase llamada Persona que cumpla las siguientes condiciones:

1. Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura. Añada un atributo de libre elección.
2. Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0 números, cadena vacía para String, etc.). Sexo será hombre por defecto.
3. Se implantarán varios constructores:
    * Un constructor por defecto.
    * Un constructor con el nombre, edad.
    * Un constructor con todos los atributos como parámetro.
4. Los métodos que se implementarán son:
    * calcularIMC(): calculara si la persona está en su peso ideal (peso en kg/(altura^2 en m)), si ésta fórmula devuelve un valor menor que 20, la función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos), significa que está por debajo de su peso ideal y la función devuelve un 0 y si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. Puede usar constantes para devolver estos valores.
    * esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
    * generaDNI(): genera un número aleatorio de 8 cifras.