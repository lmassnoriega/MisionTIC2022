import java.util.*;

public class Promedio {

    int tam;

    public static void main(String[] args) {
        System.out.println("Cuantos numeros: ");
        Scanner cnum = new Scanner(System.in);
        int cn = cnum.nextInt();

        int numeros[] = new int[cn];
        int totnum;
        totnum = 0;
        float avgnum;
        for (int i = 0; i < cn; i++) {
            System.out.println("Introduce numero entero y presiona ENTER ");
            Scanner consonum = new Scanner(System.in);
            int numin = consonum.nextInt();
            numeros[i] = numin;
            totnum = totnum + numin;
        }
        avgnum = totnum / cn;

        int menor, mayor, prom;
        menor = 0;
        mayor = 0;
        prom = 0;
        for (int i = 0; i < cn; i++) {
            if (numeros[i] < avgnum) {
                menor++;
            } else if (numeros[i] > avgnum) {
                mayor++;
            } else {
                prom++;
            }
        }
        System.out.println("Total: " + totnum);
        System.out.println("Promedio: " + avgnum);
        System.out.println("Menores al promedio: " + menor);
        System.out.println("Iguales al promedio: " + prom);
        System.out.println("Mayores al promedio: " + mayor);
    }
}
