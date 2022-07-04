# Sesión # 8: Componente Práctico

Implementar una clase llamada Producto, la cual tenga los siguientes atributos y métodos:

### Atributos:

* Código
* Precio de compra
* Precio de venta
* Cantidad en bodega
* Cantidad mínima requerida en bodega.
* Cantidad máxima de inventario permitida.
* Porcentaje de Descuento.

### Métodos:

* Solicitar pedido: devuelva true si debe solicitar el producto al proveedor y false en caso contrario.
* Calcular total a pagar : devuelva la cantidad total a pagar al proveedor dado una cantidad de unidades de compra.


Diseñar un programa que:

* Consulte el número de productos a manejar.
* Cree un vector de productos en el cual se guardarán las instancias de cada uno de ellos.
* Solicite por consola el código, el precio de compra, el precio de venta, la cantidad en bodega, la cantidad mínima requerida y la cantidad máxima de inventario permitida para cada uno de los productos a manejar.

Implemente en la clase principal un menú con las siguientes opciones:

* Verificar productos a pedir: recorrer el vector de productos y arrojar una alerta en caso tal se deba solicitar el pedido al proveedor.
* Producto con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.
* Total a pagar por pedido a realizar: leer un código de producto y una cantidad de unidades de compra, indicar el total a pagar por ese pedido al proveedor. Para ello utilice el método creado en la clase Producto pasando por parámetro la cantidad de unidades de compra.
* Modificar cantidad mínima requerida en bodega: leer código de producto y el nuevo valor para la cantidad de unidades mínimas requeridas, validar en el método set de la variable correspondiente que la nueva cantidad no sea menor a 0, en caso de serlo establecer la cantidad mínima como 0.
* Vender producto: solicite el código de un producto a vender y las unidades correspondientes, calcule el valor de la factura con descuento y sin descuento. Validar que existan las unidades necesarias para la venta y modificar las unidades existentes después de la venta utilizando el método set de la variable correspondiente.

**Para tener en cuenta:** *el porcentaje de descuento es el mismo para todos los productos, y es del 1%.*
