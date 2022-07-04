import java.util.Scanner;
import java.util.Random;

public class Matrices {

    public static void main(String[] args) {
        
        int filas, columnas;
        Scanner lector = new Scanner(System.in);

        System.out.print("Rows: ");
        int f = lector.nextInt();
        System.out.print("Cols: ");
        int c = lector.nextInt();
        System.out.println();
        // Creación y dimensión de la matriz
        int Matriz1[][] = new int[f][c];
        // Lectura de datos<
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {

                Random rnd = new Random();
                int minimo; // 1
                int maximo; // 100
                
                //int rnd = (int)(Math.random(maximo - minimo + 1) ) + 1;
                
                Matriz1[i][j] = rnd.nextInt(100) + 1; // 1 to 10 0
                //System.out.print("Data: ");
                //Matriz1[i][j] = lector.nextInt();

            }
        }
        // Escritura de datos por filas
        System.out.println("FILAS");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) { 
                System.out.print(Matriz1[i][j] + "\t");
            }
            System.out.println();
        }
        // Escritura de datos por columnas
        System.out.println("COLUMNAS");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < f; j++) { 
                System.out.print(Matriz1[j][i] + "\t");
            }
            System.out.println();
        }


	 }


 

    
}
