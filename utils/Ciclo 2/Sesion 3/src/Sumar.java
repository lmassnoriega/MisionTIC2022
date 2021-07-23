import java.util.Scanner;

public class Sumar {

    /**
     * Crear dos matrices de nxn y sumar sus valores, 
     * los resultados se deben almacenar en otra matriz. 
     * Los valores y la longitud, serán insertados por el usuario. 
     * Mostrar las matrices originales y el resultado.
     */

    


    public static void main(String[] args) {

        //USO DEL SPLIT
        String cadena_codigos = "12 23 32";
        String[] vector_codigos = cadena_codigos.split(" ");
        int t = vector_codigos.length;
        int [] vector_codigos_entero = new int[t];
        
        System.out.println("VECTOR CADENA");
        for(int i = 0; i<vector_codigos.length; i++){
            System.out.print(vector_codigos[i] + "\t");
            vector_codigos_entero[i] = Integer.parseInt(vector_codigos[i] );
        }

        System.out.println();
        System.out.println("VECTOR NUMERICO: ");

        for(int i = 0; i<vector_codigos.length; i++){
            System.out.print(vector_codigos_entero[i] + "\t");
        }
        
        /*
        Scanner lector = new Scanner(System.in);
        System.out.print("Rows: ");
        int f = lector.nextInt();
        System.out.print("Cols: ");
        int c = lector.nextInt();
        System.out.println();
        // Creación y dimensión de la matriz
        int Sumando1[][] = new int[f][c];
        int Sumando2[][] = new int[f][c];
        int Resultado[][] = new int[f][c];

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {   
                Sumando1[i][j] = (int)(Math.random()*10)+1;
                Sumando2[i][j] = (int)(Math.random()*10)+1;
            }
        }   
        // Matriz resultante
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {   
                Resultado[i][j] = Sumando1[i][j] + Sumando2[i][j];
            }
        } 
        //
        System.out.println("MATRIZ 1");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {   
                System.out.print(Sumando1[i][j] + "\t" );
            }
            System.out.println();
        } 

        System.out.println();
        System.out.println("MATRIZ 2");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {   
                System.out.print(Sumando2[i][j] + "\t" );
            }
            System.out.println();
        } 

        System.out.println();
        System.out.println("MATRIZ RESULTANTE");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {   
                System.out.print(Resultado[i][j] + "\t" );
            }
            System.out.println();
        } 
        */


    }
    
}
