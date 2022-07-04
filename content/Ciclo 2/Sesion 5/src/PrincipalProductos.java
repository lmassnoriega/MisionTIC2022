import java.util.Scanner;

public class PrincipalProductos {

    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);
        System.out.println("Cantidad de productos: ");
        int cant_prod = lector.nextInt();

        Productos vector[] = new Productos[cant_prod];

        for (int i = 0; i < cant_prod; i++) {
            
            System.out.println("Id: ");
            int id = lector.nextInt();
            System.out.println("Precio: ");
            Double c = lector.nextDouble();
            System.out.println("Bodega: ");
            int b = lector.nextInt();
            System.out.println("Reuqerida: ");
            int m = lector.nextInt();
            vector[i] = new Productos(id, c, b, m);
        }
        // Muestra el estado del objeto por medio de toString
        System.out.println(vector[0]); 

        // Acceder a cada atributo de los objetos en el vector
        /*
        System.out.println(vector[0].getCodigo());
        System.out.println(vector[0].getPrecio());
        System.out.println(vector[1].getCodigo());
        System.out.println(vector[1].getPrecio());
        */

        // Modificamos y mostramos de nuevo el cambio en un atributo del objeto 2
        /*
        vector[1].setPrecio(3433);
        System.out.println(vector[1].getPrecio());
        */

        for (int i = 0; i < cant_prod; i++) {
    
            if(vector[i] .solicitarProducto())
            { System.err.println(" ALERTA " + vector[i].getCodigo());}
            else{  System.err.println( vector[i].getCodigo()+ " no necesita pedido");}
        }

    }
    
}
