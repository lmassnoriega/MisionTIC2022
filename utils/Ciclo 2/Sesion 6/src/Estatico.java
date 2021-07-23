public class Estatico{

    private int codigo;
    private String nombre;
    private static String codigoPostal;
    private static int contadorEstaticos;

    public Estatico() {
        contadorEstaticos++;
    }

    public Estatico(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        contadorEstaticos++;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public static String codigoPostal(){
        codigoPostal = "hola";
        return codigoPostal;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }



}