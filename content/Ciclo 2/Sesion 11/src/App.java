public class App {
    public static void main(String[] args) throws Exception {

        // Concepto de polimorfismo

        Empleado empleado1 = new Empleado(101);
        System.out.println(empleado1);
        definirArea(empleado1);

        /* Operario operario1 = new Operario(102, 6);
        System.out.println(operario1); */

        empleado1 = new Operario(102, 6);
        System.out.println(empleado1);
        definirArea(empleado1);

    }

    public static void definirArea(Empleado empleado){
        empleado.departamento();
    }

}