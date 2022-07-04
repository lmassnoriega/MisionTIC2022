public class Empleado{

    protected int id;

    // Constructores
    public Empleado() {
    }

    public Empleado(int id) {
        this.id = id;
    }

    // GET y SET
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void departamento(){
        System.out.println("No tengo un area específica. ");
    }
    

    // toString
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            "}";
    }




}