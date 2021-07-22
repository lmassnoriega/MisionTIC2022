public class Animal {
    
    // Atributos
    private int id;
    private String nombre;
    private int ingreso;
    private boolean endemico; 

    // Constructor(es)
    public Animal(){

    }
    
    public Animal(int cod, String nom, int ing, boolean end){
        this.id = cod;
        this.nombre = nom;
        this.ingreso = ing;
        this.endemico = end;
    }

    // Métodos accesodores (get/ set)

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getIngreso(){
        return this.ingreso;
    }

    public void setIngreso(int ingreso){
        this.ingreso = ingreso;
    }

    public boolean getEndemico(){
        return this.endemico;
    }

    public void setEndemico(boolean endemico){
        this.endemico = endemico;
    }


    
    // Otros métodos
    public int retornarIngreso(){
        return this.ingreso - 2021;
    }

    public String toString(){
        return "{Id: " + this.id + ", Nombre: " +  this.nombre  
        + ", Ingreso: " + this.ingreso + ", Endémico:  "  + this.endemico + " }";
    }

}
