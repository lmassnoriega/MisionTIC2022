import java.util.*;

public class Inventarios {
    int tam;

    public static void main(String[] args) {
        System.err.println("CANTIDAD DE PRODUCTOS: ");
        Scanner tam = new Scanner(System.in);
        int t = tam.nextInt();

        int codigos[] = new int[t];
        int cant_bodega[] = new int[t];
        int cant_minima[] = new int[t];

        for (int i = 0; i < t; i++) {

            codigos[i] = (int) (Math.random() * 500) + 1;
            cant_bodega[i] = (int) (Math.random() * 100) + 1;
            cant_minima[i] = (int) (Math.random() * 60) + 1;
            System.out.println(
                    "Codigo:" + codigos[i] + " Cant Bodega: " + cant_bodega[i] + " Cant Min: " + cant_minima[i]);
        }

        int mayor, menor, imayor, imenor;
        mayor = cant_bodega[1];
        imayor = 1;
        menor = cant_bodega[1];
        imenor = 1;
        for (int i = 0; i < t; i++) {

            if (cant_minima[i] > cant_bodega[i]) {
                System.out
                        .println("Del codigo: " + codigos[i] + " debe ordenarse " + (cant_minima[i] - cant_bodega[i]));
            }
            if (mayor < cant_bodega[i]) {
                mayor = cant_bodega[i];
                imayor = i;
            }

            if (menor > cant_bodega[i]) {
                menor = cant_bodega[i];
                imenor = i;
            }
        }
        System.out.println("Codigo Menor Inv: " + imenor + " Cantidad: " + menor + "     " + "Codigo Menor Inv: "
                + imayor + " Cantidad: " + mayor);
    }

}
