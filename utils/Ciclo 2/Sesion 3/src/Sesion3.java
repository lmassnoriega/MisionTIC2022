import java.util.Scanner;

public class Sesion3 {

	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);

		// leer los códigos
		System.out.println("códigos de los prductos:");
		String codigos[] = leer.nextLine().split(" ");
		int cant_codigo = codigos.length;
		double promedios[] = new double[cant_codigo];

		// leer cantidades
		System.out.println("cantidades en bodega:");
		String b[] = leer.nextLine().split(";");
		int cant_sedes = b.length;
		int[][] bodega = new int[cant_sedes][cant_codigo];
		int minimos[][] = new int[cant_sedes][cant_codigo];
		
		System.out.println("cantidades mínimas:");
		String m[] = leer.nextLine().split(";");

		leer.close();
		
		for (int i = 0; i < cant_sedes; i++) {
			String auxbod[]=b[i].split(" ");
			String auxmin[]=m[i].split(" ");
			for (int j = 0; j < cant_codigo; j++) {
				bodega[i][j]=Integer.parseInt(auxbod[j]);
				minimos[i][j]=Integer.parseInt(auxmin[j]);
				promedios[j]+=bodega[i][j];
				if (bodega[i][j]<minimos[i][j]) {
					System.out.println("Debe solicitar producto "+codigos[j]+" en la sede: "+i);
				}
			}
		}

		for (int i = 0; i < cant_codigo; i++) {
			System.out.format("Promedio producto "+codigos[i]+" es: %.2f%n", promedios[i]/cant_codigo);
		}

	}

}
