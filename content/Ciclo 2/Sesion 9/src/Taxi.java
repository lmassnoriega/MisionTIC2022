import java.lang.StringBuilder;

public class Taxi extends Vehiculo{

    private int numeroLicencia;


    public Taxi() {   }
    
    
    public Taxi(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    
    
    public Taxi(int numeroLicencia, int matricula, String modelo, double potencia, int codigoEmpresa){
        super(matricula, modelo, potencia);
        super.setCodEmpresa(codigoEmpresa);
        this.numeroLicencia = numeroLicencia;
    }


    public Taxi(int numeroLicencia, int matricula, String modelo, double potencia){
        super(matricula, modelo, potencia);
        this.numeroLicencia = numeroLicencia;
    }


    public int getNumeroLicencia() {
        return this.numeroLicencia;
    }

    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }


    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("{ numeroLicencia= ").append(getNumeroLicencia());
        stb.append(", ").append(super.toString()).append(" }");
        return stb.toString();
    }
    
}