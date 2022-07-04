import java.util.Scanner;

public class PrincipalProductos {
    
    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);

        System.out.println("Cantidad productos: ");
        int cant_prod = lector.nextInt();
        // Definición del vector de Productos
        Productos vector_Productos[] = new Productos[cant_prod];

        // Ingresar objetos al vector de Productos
        for (int i = 0; i < vector_Productos.length; i++) {
            
            System.out.println("Código: ");
            int codigo = lector.nextInt();
            System.out.println("Precio: ");
            double precio = lector.nextDouble();
            System.out.println("Bodega: ");
            int bodega = lector.nextInt();
            System.out.println("Mínimma: ");
            int minima = lector.nextInt();
            System.out.println("Máxima: ");
            int maxima = lector.nextInt();

            // Asignación de objetos al vector de Prductos
            vector_Productos[i] = new Productos(codigo, precio, bodega, minima, maxima);
        }
        System.out.println("_________MOSTRAR CON FOR EACH____________");
        for (Productos p : vector_Productos) {
            System.out.println(p.getCantidad_bodega());
        }
        System.out.println("_____________________");

        

        // Verificar el producto con mayor cantidad en bodega
        int cant_nax = -1, cant = 0, pos = 0;
        for (int i = 0; i < vector_Productos.length; i++) {

            // Verificar si se solicita pedido al proveedor

            if(vector_Productos[i].solicitarPedido())
            { System.out.println("CODIGO " + vector_Productos[i].getCodigo() + " ALERTA!!");
            }else{ System.out.println("CODIGO " + vector_Productos[i].getCodigo() + " OK");}

            cant = vector_Productos[i].getCantidad_bodega();
            if( cant > cant_nax){ cant_nax = cant; pos = i;}


        }
        System.out.println("El producto con mayor cantidad en bodega es " + vector_Productos[pos].getCodigo());

        // 
        System.out.println("Código: ");
        int codigo = lector.nextInt();
        
        int i = 0, sw = 0;
        while ((i<cant_prod) && (sw == 0)){
            int c = vector_Productos[i].getCodigo();
            if (c == codigo){
                System.out.println("Unidades de compra: ");
                int unidades = lector.nextInt();
                //vector_Productos[i].totalPagar(vector_Productos[i].getPrecio_compra(), unidades);
                System.out.println("Total a pagar por el producto " + vector_Productos[i].getCodigo() + "  es : " + vector_Productos[i].totalPagar(vector_Productos[i].getPrecio_compra(), unidades));
                sw =1;
            }
            else{ sw = 0; }
            i++;
        }
        if (sw == 0){
            System.out.println("Producto " + codigo + " NO existe.");
        }

    }
}
