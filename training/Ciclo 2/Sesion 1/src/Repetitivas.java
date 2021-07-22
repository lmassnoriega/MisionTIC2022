import java.util.Scanner;

public class Repetitivas {

    public static void main(String[] args) {
        
        //WHILE
        System.out.println("__WHILE___");

        boolean condicion = true;
        int contador = 0;
        while(condicion){
            contador++;
            System.out.println("El contador: " + contador);
            System.out.println("Continuar?");
            Scanner cont = new Scanner(System.in);
            String continuara = cont.nextLine(); 

            if (continuara.equals("No")) {
                condicion = false;
            }

        }
        System.out.println("__DO WHILE___");
        int contador2 = 0;
        boolean condicion2 = true;
        do{
            contador2++;
            System.out.println("El contador: " + contador2);
            System.out.println("Continuar?");
            Scanner conti = new Scanner(System.in);
            String continuar = conti.nextLine(); 
            if (continuar.equals("No")) {
                condicion2 = false;
            }

        }while(condicion2 != false );

        System.out.println("__FOR___");
        
        for(int i=1; i<=10; i++){
            System.out.println(i);
        }

        //Ejemplo 5: componente práctico sesión 1

        Scanner num_dia = new Scanner(System.in);
        Scanner sin_dcto = new Scanner(System.in);
        System.out.println("Número del día: ");
        int dia_sem = num_dia.nextInt();
        System.out.println("Valor sin descuento: ");
        double valor = sin_dcto.nextDouble();
        double total_pagar;
        // sw + TAB
        switch (dia_sem) {
            case 1:
                total_pagar = valor - (valor * 0.05);   
                System.out.println("Total a pagar con descuento: " + total_pagar);
                break;
            
            case 3:
                total_pagar = valor - (valor * 0.1);   
                System.out.println("Total a pagar con descuento: " + total_pagar);
                break;
        
            case 5:
                total_pagar = valor - (valor * 0.06);   
                System.out.println("Total a pagar con descuento: " + total_pagar);
                break;
                
            default:
                System.out.println("DÍA NO VÁLIDO");
                break;
        }






    }
    
}
