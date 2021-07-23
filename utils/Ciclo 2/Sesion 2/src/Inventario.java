import java.util.*;

;public class Inventario {

    public static void main(String[] args) {
      
        

        // GENERAR ALEATORIOS CON LIMITES INF Y SUP
        /*int x, y;
        for(int i=1; i<6;i++)
        {
            x = (int)((Math.random()*5)+10-5);
            
            y = (int)((Math.random()*50)+1);
            
            
            System.out.println("random 1: " + x);
            System.out.println("random 2: " + y);
            System.out.println("____________________");
            
        }*/
        

        

        System.out.println("CANTIDAD DE PRODUCTOS: ");
        Scanner tamano = new Scanner(System.in);
        int t = tamano.nextInt();

        int codigos[] = new int[t];
        int cant_bodega[] = new int[t];
        int cant_minima[] = new int[t];

        //Leer datos en las 3 listas
        for(int i=0; i<t; i++){
            //codigos[i] = tamano.nextInt();
            codigos[i] = (int)(Math.random()*500);
            cant_bodega[i] = (int)(Math.random()*150);
            cant_minima[i] = (int)(Math.random()*500);
        }

        // Lista de códigos
        System.out.println("CODIGOS");
        for(int i=0; i<t; i++){
            System.out.print(codigos[i] + "\t");
        }
        System.out.println();
        System.out.println("BODEGA");
        // Lista de existencias en bodega
        for(int i=0; i<t; i++){
            System.out.print(cant_bodega[i] + "\t");
        }
        System.out.println();
        System.out.println("MINIMAS");
        // Lista de existencias minimas
        for(int i=0; i<t; i++){
            System.out.print(cant_minima[i] + "\t");
        }

        //
        int mayor=0, menor=0, pos_may=0, pos_men=0;
        System.out.println("\n Códigos que deben hacer pedido: ");
        for(int i=0; i<t; i++){
            // Códigos que necesitan hacer pedido
           
            if (cant_bodega[i]>cant_minima[i]){
                System.out.println(codigos[i]);
            }
            if (i==0){
                mayor=cant_bodega[i];
                menor=cant_bodega[i];
            }
            if (cant_bodega[i]>mayor) {
                mayor = cant_bodega[i];
                pos_may = i;
            }
            if (cant_minima[i]<menor) {
                menor = cant_minima[i];
                pos_men = i;
            }
        }
        System.out.println("CÓDIGO CON MAYOR NÚMERO EN BODEGA " + codigos[pos_may]);
        System.out.println("CÓDIGO CON MENOR NÚMERO EN BODEGA " + codigos[pos_men]);

        

    }
    
}
