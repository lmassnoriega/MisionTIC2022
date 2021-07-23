import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {

        Animal especimen1 = new Animal();
        especimen1.setId(20);
        especimen1.setNombre("Armadillo");
        especimen1.setIngreso(1999);
        especimen1.setEndemico(false);

        System.out.println(especimen1.toString());
        /*
        // Impresión uno a uno //
        System.out.println(especimen1.getId());
        System.out.println(especimen1.getNombre());
        System.out.println(especimen1.getIngreso());
        System.out.println(especimen1.getEndemico());
        */
        System.out.println(especimen1.retornarIngreso());

        //Leyecto los datos por teclado
        Scanner lector = new Scanner(System.in);
        System.out.println("Codigo: ");
        int c = lector.nextInt();
        lector.nextLine();
        System.out.println("Nombre: ");
        String n = lector.nextLine();
        System.out.println("Ingreso: ");
        int i = lector.nextInt();
        System.out.println("Endémico?: ");
        boolean e = lector.nextBoolean();
        
        Animal especimen2 = new Animal(c, n, i, e);
        System.out.println(especimen2.toString());
        
        System.out.println(especimen2.retornarIngreso());

         
    }
   
}
