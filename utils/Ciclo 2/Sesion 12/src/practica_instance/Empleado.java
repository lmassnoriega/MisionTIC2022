package practica_instance;

public class Empleado {

    protected int cod;
    protected String name;

    public Empleado() {
    }

    public Empleado(int cod, String name) {
        this.cod = cod;
        this.name = name;
    }


    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void detalle(){
        System.out.println("Detalle del padre " + this.name);
    }

    
}
