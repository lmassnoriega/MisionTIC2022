public class Vehiculo{

    protected int matricula;
    protected String modelo;
    protected double potencia;
    private int codEmpresa;


    public Vehiculo(){

    }


    public int getCodEmpresa() {
        return this.codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }


    public Vehiculo(int matricula, double potencia){
        this.matricula = matricula;
        this.potencia = potencia;
    }


    public Vehiculo(int matricula, String modelo, double potencia) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.potencia = potencia;
    }
    

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return this.potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }
    


    @Override
    public String toString() {
        return "{" +
            " matricula='" + getMatricula() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", potencia='" + getPotencia() + "'" +
            ", codEmpresa='" + getCodEmpresa() + "'" +
            "}";
    }
    



}