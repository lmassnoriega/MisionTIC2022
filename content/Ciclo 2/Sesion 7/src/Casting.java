
public class Casting{

    int variable;

    public static void main(String[] args) {
        
        
        // TiPOS DE DATOS PRIMITIVOS
        // Conversión implícita  - Widening Casting (Estrecha)
        int a = 45;
        double b = a;
        System.out.println(b);

        // Conversión explícita - Narrowing Casting (Amplia)
        double c = Math.PI;
        System.out.println(c);
        int d = (int) c;
        System.out.println(d);

        // CONVERSION CON CLASES ENVOLVENTES
        /* Clases envolventes - Wrappers
                      String - caso especial
            boolean = Boolean
            int = Integer
            float = Float
            double = Double
        */

        String cadena = "56";
        int e = Integer.parseInt(cadena);
        System.out.println(e);
        double f = Double.parseDouble(cadena) ;
        System.out.println(f);

        int matriz[][] = { {1, 2}, {3, 4}};
        System.out.println("Matriz");
        App app = new App(100, "Cualquier valor", matriz);
        int m2[][] = new int[2][2];
        m2 =  app.getMatriz();
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                System.out.print(m2[i][j] + "\t");
            }
            System.out.println();
        }


    }

}