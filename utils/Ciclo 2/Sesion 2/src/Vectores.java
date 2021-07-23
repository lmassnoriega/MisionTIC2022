import java.util.Scanner;
public class Vectores {

    public static void main(String[] args) {
        
        // tipoDato nombre , instanciando

        int [] vector = new int[100];
        //LECTURA DE DATOS
        System.out.println("Digite un número: ");
        Scanner num = new Scanner(System.in);
        int var = num.nextInt();

        for (int i=0; i<var; i++ ){
            System.out.println("Valor en la posición " + i + " : ");
            vector[i] = num.nextInt();
        }

        //ESCRITURA DE DATOS
        for (int i=0; i<var; i++ ){
            System.out.print(vector[i] + "\t");
        }

    }
    
}
