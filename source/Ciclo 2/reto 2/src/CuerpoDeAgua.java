public class CuerpoDeAgua {
    protected String nombre;
    private int id;
    private String municipio;
    protected float irca;

    public CuerpoDeAgua(String Nombre, int ID, String Municipio, float IRCA_level) {
        this.nombre = Nombre;
        this.id = ID;
        this.municipio = Municipio;
        this.irca = IRCA_level;
    }

    public int category(){
        if (irca <= 5) {
            return 0;
        } else {
            if (irca <= 14) {
                return 1;
            } else {
                if (irca <= 35) {
                    return 2;
                } else {
                    if (irca <= 80) {
                        return 3;
                    } else {
                        return 4;
                    }
                }
            }
        }
    }
}
