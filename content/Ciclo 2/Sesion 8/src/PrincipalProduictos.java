import java.util.Scanner;



public class PrincipalProduictos {

    public static void verificarPedido(Productos lista_productos[]){
        for (Productos p: lista_productos){
            if(p.solicitarPedido()){
                System.out.println("ALERTA: PEDIDO AL CÓDIGO [" + p.getCodigo() + "]");
            }
        }
    
    }


    public static void productoCantidadMayor(Productos lista_productos[]){
        
        int mayor = -1, pos = 0, primer = 0;

        for (int i = 0; i < lista_productos.length; i++) {
            int cant = lista_productos[i].getCant_bodega();
            if(cant > mayor){
                mayor = lista_productos[i].getCant_bodega();
                pos = i;
                primer = pos;
            }
            if (cant == mayor){
                pos = i;
            }
        }
        if (primer < pos){
            System.out.println("El producto con maypr cantidad de unidades es " + lista_productos[primer].getCodigo() );
        }
    }

    public static void totalPagar(Productos lista_Productos[], int cantidad){
        Scanner lector = new Scanner(System.in);
        System.out.println("Códiho del producto: ");
        int codigo = lector.nextInt();
        int i = 0, sw = 0;
        while( i< cantidad && sw == 0 ){
            int cd = lista_Productos[i].getCodigo();
            if (cd == codigo){
                System.out.println("Cantidad a pagar: ");
                int cant = lector.nextInt();
                System.out.println("Total a pagar: " + lista_Productos[i].totalAPagar(cant));
                sw = 1;
            }
            i++;
        }



    }


    public static void main(String[] args) throws Exception {

        Scanner lector = new Scanner(System.in);
        System.out.println("Cantidad de productos: ");
        int cantidad = lector.nextInt();

        Productos vector_productos[] = new Productos[cantidad];

        for (int i = 0; i < vector_productos.length; i++) {
            System.out.println("Código: ");
            int cod = lector.nextInt();
            System.out.println("Precio compra: ");
            double p_compra = lector.nextDouble();
            System.out.println("Precio venta: ");
            double p_venta = lector.nextDouble();
            System.out.println("Cantidad bodega: ");
            int bodega = lector.nextInt();
            System.out.println("Cantidad mínima: ");
            int minima = lector.nextInt();
            System.out.println("Cantidad máxima: ");
            int maxima = lector.nextInt();

            // Guardamos en el vector de Productos cada instancia con sus datos
            vector_productos[i] = new Productos(cod, p_compra, p_venta, bodega, minima, maxima);
        }

        // Creación del menú
        int opcion = 0;
        do {
            System.out.println("Menú principal");
            System.out.println("1 - Verificar productos a pedir. ");
            System.out.println("2 - Producto con mayor cantidad de unidades");
            System.out.println("3 - Total a pagar por pedido. ");
            System.out.println("4 - Modificar cantidad mínima requerida en bodega. ");
            System.out.println("5 - Vender producto");
            System.out.println("6 - Salir");
            System.out.println("Elija una opción [1 - 6] ");
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    verificarPedido(vector_productos);
                    break;

                case 2:
                    productoCantidadMayor(vector_productos);
                    break;

                case 3:
                    totalPagar(vector_productos, cantidad);
                    break;

                case 6:
                    System.out.println("Gracias por participar");
                    break;

                default:
                    break;
            }

        } while (opcion != 6);

    }
}
