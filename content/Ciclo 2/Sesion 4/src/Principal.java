import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        

        Scanner producto = new Scanner(System.in);
        System.out.println("Codigo: ");
        int prod = producto.nextInt();

        System.out.println("Precio: ");
        double prec = producto.nextDouble();

        System.out.println("Bodega: ");
        int bod = producto.nextInt();
        
        System.out.println("Minima: ");
        int min = producto.nextInt();

        Productos producto1 = new Productos(prod, prec, bod, min);
        if(producto1.solicitarPedido()){
            System.out.println("ALERTA HACER PEDIDO EN " + prod);
        }
        else{
            System.out.println("CONTROLADO");
        }

    }
    
}
