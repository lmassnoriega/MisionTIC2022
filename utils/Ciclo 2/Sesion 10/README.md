# Sesión # 10: Componente Práctico

Implementar una super clase llamada Producto, la cual tenga los siguientes atributos y métodos:

### Atributos:

* Código.
* Descripción.
* Precio de compra.
* Precio de venta.
* Cantidad en bodega.
* Cantidad mínima requerida en bodega.
* Cantidad máxima de inventario permitida.
* Porcentaje de Descuento.

### Métodos:

* Solicitar pedido: devuelva true si debe solicitar el producto al proveedor y false en caso contrario.
* Calcular total a pagar : devuelva la cantidad total a pagar al proveedor dado una cantidad de unidades de compra.
* Mostrar: devuelva una cadena descriptiva con la información del producto separada por guión medio (-).

Adicionalmente se desea dos subclases para los siguientes tipos de productos:

* Prendas de vestir (como lo son blusas, jeans, camisas, etc) el cual debe tener los siguientes parámetros adicionales:
    * Talla: S, M, L, etc
    * Permite planchado: verdadero o falso.

* Calzado (como lo son tenis, calzado formal, sandalias, etc) el cual debe tener el siguiente parámetro adicional:
    * Talla: 35, 36, 37, etc

Cada subclase debe sobreescribir el método mostrar de la super clase Producto, adicionando los parámetros adicionales a mostrar en cada subclase.


Diseñar un programa que:

* Consulte el número de productos de tipo de prendas de vestir a manejar.
* Consulte el número de productos de tipo calzado a manejar.
* Cree un vector de productos de prendas de vestir en el cual se guardarán las instancias de cada uno de ellos.
* Cree un vector de productos de calzado en el cual se guardarán las instancias de cada uno de ellos.
* Solicite los datos requeridos para cada tipo de producto a guardar.

Implementar en la clase principal un menú con las siguientes opciones:

* Consultar producto: solicite el código de un producto a vender, el tipo (calzado o prenda) y muestre la información del mismo.
* Verificar productos a pedir: recorrer los vectores de productos y arrojar una alerta en caso tal se deba solicitar el pedido al proveedor.
* Calzado con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.
* Prenda con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.
* Modificar cantidad mínima requerida en bodega: leer código de producto, el tipo (calzado o prenda) y el nuevo valor para la cantidad de unidades mínimas requeridas, validar en el método set de la variable correspondiente que la nueva cantidad no sea menor a 0, en caso de serlo establecer la cantidad mínima como 0.
* Vender producto: solicite el código de un producto a vender, el tipo (calzado o prenda), y las unidades correspondientes, calcule el valor de la factura con descuento y sin descuento. Validar que existan las unidades necesarias para la venta y modificar las unidades existentes después de la venta utilizando el método set de la variable correspondiente.

*Para tener en cuenta: el porcentaje de descuento es el mismo para todos los productos, y es del 1%.*


