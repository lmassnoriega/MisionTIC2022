import java.io.NotActiveException;
import java.util.Scanner;

public class Sesion1 {

    public static void main(String[] args){

        // Comentario de una sola línea

        /* Comentario multilinea... 
        comentarios */

        // Declaración de variables
        int numero1, numero2, numero3;
        float decimales1;
        double decimales2;
        char letrica = 'c';
        boolean sexo;
        
        // Convertir cadena a numero y viceversa
        String cadena = "345";
        int numero_cadena = Integer.parseInt(cadena);

        int valor = 123;
        String valor_cadena = Integer.toString(valor);
        
        //
        //float v1 = 15.45;
        int v2 = 2;


        int expo = 2^3;
        Math.pow(23, 2);

        
        // Salidas por pantalla
        // syssout + TAB
        System.out.print("Este es un mensaje con print only"); //En una sola linea
        System.out.println("Este es un mensaje con print y ln"); //En una nueva línea
        
        // Entrada por teclado
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite un numero: "); //En una sola linea
        int unEntero = entrada.nextInt();
        System.out.println(unEntero);
        
        System.out.print("Digite un texto: ");
        Scanner entrada_texto = new Scanner(System.in); 
        String texto = entrada_texto.nextLine();
        System.out.println(texto);



    }

}