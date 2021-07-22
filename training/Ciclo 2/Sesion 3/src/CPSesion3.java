import java.util.Random;

public class CPSesion3 {

    public static void main(String[] args) {
        
        int codigos[] = new int[3];
        int bodega[][] = new int[4][3];
        int minima[][] = new int[4][3];

        Random rnd = new Random();
        //Lectura del vector  de códigos
        for (int i = 0; i < 3; i++) {
            codigos[i] = rnd.nextInt(400) + 1;
        }
        //Escritura del vector de códigos
        System.out.println("CODIGOS");
        for (int i = 0; i < 3; i++) {
            System.out.print(codigos[i]  + "\t");
        }
        System.out.println();

        Random rnd2 = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                bodega[i][j] = rnd2.nextInt(400) + 1;
                minima[i][j] = rnd2.nextInt(400) + 1;
                
            }
        }

        //Escritura de matriz de bodega
        System.out.println("BODEGA");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
               System.out.print( bodega[i][j]  + "\t");
            }
            System.out.println();
        }

        System.out.println();
        //Escritura de matriz de minimos
        System.out.println("MINIMO");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
               System.out.print( minima[i][j]  + "\t");
            }
            System.out.println();
        }
        System.out.println();

        //Validar información
        for (int i = 0; i < 4; i++) { // Filas = sedes
            for (int j = 0;  j < 3; j++) { // Columnas = corresponden al producto (Vector)
                if(bodega[i][j] < minima[i][j]){
                    System.out.println("Se debe solicitar producto " + codigos[j] + "en sede " + i);
                }
                
            }
        }

        // Promedio de productos
        int sum = 0;
        for (int i = 0; i < 3; i++) { // Filas = sedes
            for (int j = 0;  j < 4; j++) { // Columnas = corresponden al producto (Vector)
                sum += bodega[j][i];
            }
            System.out.println("El promedio de productos del codigo " + codigos[i] + " es " + (sum/4));                
            sum = 0;
        }



    }
    
}
