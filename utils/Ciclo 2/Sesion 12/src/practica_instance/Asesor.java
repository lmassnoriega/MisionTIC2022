package practica_instance;

public class Asesor extends Empleado {

    private String nivel;


    public Asesor() {
    }


    public Asesor(String nivel) {
        this.nivel = nivel;
    }

    public Asesor(int cod, String name, String nivel) {
        super(cod, name);
        this.nivel = nivel;
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void detalle(){
        System.out.println("Detalle del asesor " + this.name);
    }


    
}
