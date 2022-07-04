import java.util.Random;
import java.util.stream.IntStream;
import java.util.Scanner;
public class Aleatorios {

    public static void main(String[] args) {
        
       
       /*  int x;
        for (int j=0; j<30;j++){
            x = (int)((Math.random()*2)+5);
            System.out.print(x + "\t");
        } */
        
        /*
        Random rnd = new Random();
        IntStream res = rnd.ints(5, 10);
        System.out.println("NUMERO GENERADO: " + (Integer) res);
        */

        
        System.out.println();

        


        Random ran = new Random();
  
        // generate next random number
        for (int i=0; i<36; i++){
            System.out.print(ran.nextInt(101)+ 1 + "\t");
        }


        System.err.println("\n MATH");
        int max = 60;
        int min = 5;
        int range = max - min + 1;
        System.out.println("RANGE: "+ range);
        // generate random numbers within 1 to 10
        for (int i = 1; i < 45; i++) {
            int rand = (int)(Math.random() * range) + 5;
  
            // Output is different everytime this code is executed
            System.out.print(rand + " ");
        }
        System.err.println("END MATH");



        /*
        System.out.print("Digite el tamaño del vector: ");
        Scanner dato = new Scanner(System.in);
        int numero = dato.nextInt();

        
        int [] Vector = new int[numero];
        System.out.println();
        System.out.println("RANGE: "+ range);
        System.out.println("- - - - - ");;
        for (int i=0; i<Vector.length; i++){
            // Ingreso manual
            // int numero = dato.nextInt();
            // Vector[i] = numero;
            //Vector[i] = (int)(Math.random()*2)+100;
            //System.out.print(Vector[i] + "\t");
            System.out.println("_______________");
            System.out.println("* * * * * * * * ");
            System.out.println(Math.random());
            System.out.println((int)(Math.random()*range));
            System.out.println("* * * * * * * * ");
            System.out.println("_______________");;
        }
        */
    }
    
}
