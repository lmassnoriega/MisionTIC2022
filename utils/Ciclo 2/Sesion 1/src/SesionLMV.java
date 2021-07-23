import java.util.Scanner;

public class SesionLMV {

   // main + TAB para completar método principal
   public static void main(String[] args)
   {

       
        //Código indentado

        // VARIABLES

        int numero1 = 0;
        int numero2, numero3;
        long numero4;
        float estatura;
        double  temperatura;
        boolean casado = false;
        char letrica = 'p';
        String cadena = "Esta es una cadena de texto";

        // CONVERSION DE CADENAS A NUMEROS Y VICEVERSA

        String opcion = "5";
        int opcion_entero = Integer.parseInt(opcion);
        System.out.println(opcion_entero);

        int opcion2 = 56;
        String opcion2_string = Integer.toString(opcion2);
        System.out.println(opcion2_string);

        double estado = 34.84894898;
        String doble = Double.toString(estado);
        System.out.println(doble);

        // SALIDA
        // sysout + TAB para completar println
        System.out.println("\n Mensaje 1 con println");
        System.out.print("Mensaje 1 con print");
        System.out.println("Mensaje 1 con println");

        

        System.out.println(15.7/2 ); //float - double
        // (15/2)  int

        // 2^3
        System.out.println("Potencia " + Math.pow(2, 3));

        //!(false);

        //var = int(input("mensajito"))


        Scanner var1 = new Scanner(System.in);
        System.out.println("Digite un número: ");
        int entero1 = var1.nextInt();
        System.out.println("Entero1: " + entero1);

        Scanner var2 = new Scanner(System.in);
        System.out.println("Digite un texto: ");
        String texto_usuario = var2.nextLine();
        System.out.println(texto_usuario);

        //CONDICIONALES
        boolean existe = true;
        if(existe){
            System.out.println("Es verdadero");
        }else{
            System.out.println("Es falso");
        }

        // CONDICIONAL MÚLTIPLE
        /*   
        if(existe){
            System.out.println("Es verdadero");
        }else if (otracondicion){
                // instrucciones
            }
            else 
            {
                if(otracondicion1) {
                //instrucciones
                }else{

                }
            }
        */

        // CONDICIONAL ANIDADO
        /*
        if(existe)
        {
            if (color == 2){
                // instrucciones
            }
            
        }else {
            if (color == 3){
                // instrucciones
            }   
            // instrucciones
        }
        */

        // DEPENDIENDO DE O SEGUN - switch
        System.out.println("Día de la semana: ");
        Scanner dia = new Scanner(System.in);
        int dias = dia.nextInt();
        switch (dias) {
            case 1:
                System.out.println("Es lunes");
                break;
            
            case 5:
                System.out.println("Es Viernes y ya no importa");
                break;

            default:
                System.out.println("Día no válido");
                break;
        }
        
        System.out.println("Nombre de dúa de la semana: ");
        Scanner dia2 = new Scanner(System.in);
        String dias2 = dia2.nextLine();
        switch (dias2) {
            case "lunes":
                System.out.println("Es el día 1");
                break;
            
            case "viernes":
                System.out.println("Es el día 5");
                break;

            default:
                System.out.println("Irreconocible");
                break;
        }



    }

    


    
    


    
}