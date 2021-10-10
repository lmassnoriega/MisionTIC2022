package model;

public class Tipo {


    private int id;
    private String descripcion;



    public Tipo() {
    }

    public Tipo(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            "}";
    }
    
    
}
