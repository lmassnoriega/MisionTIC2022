import java.util.Scanner;

public class Dias {

    public static void main(String[] args) {

        Scanner dias = new Scanner(System.in);
        Scanner total_pagar = new Scanner(System.in);

        System.out.println("Digite el día: ");
        int numero = dias.nextInt();
        System.out.println("Total a pagar: ");
        double total = total_pagar.nextDouble();

        switch (numero) {
            case 1:
                total = total - (total*0.05);
                System.out.println("Total a pagar con descuento: " + total);
                break;
            
            case 2:
                total = total - (total*0.03);
                System.out.println("Total a pagar con descuento: " + total);
                break;
        
            default:
                System.out.println("NO SE PUDO PROCESAR, día no válido");
                break;
        }

        
    }
    
}
