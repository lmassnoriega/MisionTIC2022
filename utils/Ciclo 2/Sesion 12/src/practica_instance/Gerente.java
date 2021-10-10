package practica_instance;


public class Gerente extends Empleado {

    private String area;


    public Gerente() {
    }

    public Gerente(String area) {
        this.area = area;
    }

    public Gerente(int cod, String name, String area) {
        super(cod, name);
        this.area = area;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void detalle(){
        System.out.println("Detalle del hijo " + this.name);
    }

    public void soloGerente(){
        System.err.println("Soy el gerente del area" + this.area);
    }
    
}
