public class Operario extends Empleado {

    private int nivel_salario;

    // Constructores
    public Operario() {

    }

    public Operario(int id, int nivel_salario){
        super(id);
        this.nivel_salario = nivel_salario;
    }


    // GET y SET
    public int getNivel() {
        return this.nivel_salario;
    }

    public void setNivel(int nivel_salario) {
        this.nivel_salario = nivel_salario;
    }

    public void departamento(){
        System.out.println("Pertenezo al área de laborario de materiales. ");
    }

    @Override
    public String toString() {
        return "{" + "id_empresa = " + super.id + 
            ", nivel = '" + getNivel() + "'" +
            "}";
    }


    
}
