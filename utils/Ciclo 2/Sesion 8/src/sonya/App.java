package sonya;

import java.util.Scanner;

public class App {

    /* ECLARACIÓN DE DATOS */
    static Scanner read;
    static int cantidadProductos;
    static Producto productos[];
    static String menu = 
        "\n" + "----------------------" + "\n" +
        "1. Verificar Productos a pedir" + "\n" +
        "2. Producto con mayor cantidad de unidades" + "\n" +
        "3. Total a pagar por pedido a realizar" + "\n" +
        "4. Modificar cantidad mínima requerida en bodega" + "\n" +
        "5. Vender producto" + "\n" +
        "6. Salir"
        ;

    public static void main(String[] args) throws Exception {
        read = new Scanner(System.in);

        /* 1. LECTURA DE DATOS */
        System.out.print("Ingrese el numero de productos a manejar: ");
        cantidadProductos = read.nextInt();
        productos = new Producto[cantidadProductos];

        /* creación de productoos */
        for (int p = 0; p < productos.length; p++) {
            System.out.println("=/=/=/=/=/=/=/=/=/=/=/ Producto " + p + "=/=/=/=/=/=/=/=/=/=/=/");
            Producto nuevoProducto = new Producto();

            System.out.print("Codigo:" + "\t\t");
            nuevoProducto.setCodigo(read.nextInt());

            System.out.print("Precio de compra:" + "\t\t");
            nuevoProducto.setPrecioCompra(read.nextFloat());

            System.out.print("Precio de venta:" + "\t\t");
            nuevoProducto.setPrecioVenta(read.nextFloat());

            System.out.print("Cantidad en bodega:" + "\t\t");
            nuevoProducto.setCantidadBodega(read.nextInt());

            System.out.print("Cantidad minima requerida:" + "\t\t");
            nuevoProducto.setCantidadMinima(read.nextInt());

            System.out.print("Cantidad máxima de inventario:" + "\t\t");
            nuevoProducto.setCantidadMaxima(read.nextInt());

            productos[p] = nuevoProducto;
        }
 
        /* 2. PROCESO */
        while (true) {
            System.out.println(menu);
            System.out.print("=/=/=/=/=/=/=/=/=/=/=/ SU OPCIÓN: ");
            int opcion = read.nextInt();

            if (opcion == 6) break;

            switch (opcion) {
                case 1:
                    verificarProductos();
                    break;

                case 2:
                    productoMayorCantidad();
                    break;
                case 3:
                    totalPagarPedido();

                    break;
                case 4:
                    modificarCantidadMinima();
                    break;
                case 5:
                    venderProducto();
                    break;
                default:
                    System.out.println("No es una opción valida");
                    break;
            }

            System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/ \n");
        } 
        
        read.close();
    }

    private static void verificarProductos() {
        for (Producto producto : productos) {
            if (producto.generarPedido()) {
                System.out.println("¡Alerta! El producto " + producto.getCodigo() + " se esta quedando sin unidades.");
            }
        }
    }

    private static void productoMayorCantidad() {
        int mayor = 0;

        for (int p = 1; p < productos.length; p++) {
            if (productos[p].getCantidadBodega() > productos[mayor].getCantidadBodega()) {
                mayor = p;
            }
        }

        System.out.println("El mayor es: " + productos[mayor].getCodigo() + " con " + productos[mayor].getCantidadBodega() + " unidades en bodega.");
    }

    private static void totalPagarPedido() {

        System.out.print("Ingrese el codigo de un producto: ");
        int codigoProducto = read.nextInt();

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigoProducto) {

                System.out.print("Ingrese el núemero de unidades a comprar: ");
                int cantidadUnidades = read.nextInt();

                if (producto.getCantidadBodega() + cantidadUnidades > producto.getCantidadMaxima()) {
                    System.out.println("No se puede realizar esta compra porque supera la cantidad maxima en bodega.");
                    return;
                }

                System.out.println("El total a pagar es: " + producto.calcularTotalPagar(cantidadUnidades));

                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    private static void modificarCantidadMinima() {
        System.out.print("Ingrese el codigo del producto: ");
        int codigoProducto = read.nextInt(); 
        
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigoProducto) {
                
                System.out.println("La cantidad minima actual es " + producto.getCantidadMinima() + " ¿Seguro que quiere cambiarlo y/n?");

                if (read.next() == "y") {
                    System.out.print("\nIngrese la nueva cantidad minima del producto: ");
                    producto.setCantidadMaxima(read.nextInt());
                }

                return;
            }
        }
        
        System.out.println("Producto no encontrado");
    }

    private static void venderProducto() {
        System.out.print("Ingrese el codigo del producto: ");
        int codigoProducto = read.nextInt(); 
        
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigoProducto) {
                
                System.out.print("Ingrese el núemero de unidades a comprar: ");
                int cantidadUnidades = read.nextInt();

                if (cantidadUnidades > producto.getCantidadBodega()) {
                    System.out.println("No hay sufucientes cantidades en bodega para esta venta.");
                    return;
                }
                float valorFactura = producto.calcularTotalVenta(cantidadUnidades);

                System.out.println("Factura sin decuento" + "\t\t" + (valorFactura));
                System.out.println("Factura sin decuento" + "\t\t" + (valorFactura - valorFactura * (producto.getPorcentajeDescuento() / 100)));
                
                return;
            }
        }

        System.out.println("Producto no encontrado");
    }
}