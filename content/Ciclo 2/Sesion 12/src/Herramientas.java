public class Herramientas extends Empleado implements Funciones{

    private String nombre;


    public Herramientas() {
    }

    public Herramientas(String nombre) {
        this.nombre = nombre;
    }

    /* public Operario(int codEmp, String nivel) {
        super(codEmp);
        this.nivel = nivel;
    } */
    
    public void funciones(){
        System.out.println("Esta herramienta sirve para cortar y se llama " + this.nombre);
    }

    public String jefeinmediato(){
        return "NA.";
    }

    public double conocerSalario(double sal ){
        return sal;

    }

    @Override
    public void compromisosComportamentales( ){
        System.err.println("NA ");;

    }


}