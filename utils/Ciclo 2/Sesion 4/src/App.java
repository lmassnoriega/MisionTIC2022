
public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");

        String nombre = "hola";
        int valor = 1;
        int vector[] = new int[6];

        // Creamos dos instancias del objeto Calculadora
        Calculadora calc1 = new Calculadora();
        Calculadora calc2 = new Calculadora();
        Calculadora calc3 = new Calculadora(9, 9);
            
        // Modificación de atributos
        //calc1.numero1 = 50;
        //calc1.numero2 = 100;

        // Llamado de métodos
        calc1.saludo();
        calc2.saludo();

        System.out.println(calc1.sumar());
        System.out.println(calc2.sumar());
        System.out.println(calc3.sumar());

        System.out.println(calc1.sumar(10, 10));
        System.out.println(calc2.sumar(7, 7));
        System.out.println(calc3.sumar(3, 3));

       
        


    }
}
