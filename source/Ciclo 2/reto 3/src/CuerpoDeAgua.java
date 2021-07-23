/**
 * 
 */
public class CuerpoDeAgua extends ObjetoGeografico{
    protected String nombre;
    private int id;
    private String municipio;
    protected float irca;

    /**
     * 
     * @param Nombre
     * @param ID
     * @param Municipio
     * @param IRCA_level
     */
    public CuerpoDeAgua(String Nombre, int ID, String Municipio, float IRCA_level) {
        this.nombre = Nombre;
        this.id = ID;
        this.municipio = Municipio;
        this.irca = IRCA_level;
    }

    /**
     * 
     * @return
     */
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

    /**
     * 
     * @return
     */
    public String nivel(){
        if (irca <= 5) {
            return "SIN RIESGO";
        } else {
            if (irca <= 14) {
                return "BAJO";
            } else {
                if (irca <= 35) {
                    return "MEDIO";
                } else {
                    if (irca <= 80) {
                        return "ALTO";
                    } else {
                        return "INVIABLE SANITARIAMENTE";
                    }
                }
            }
        }
    }
}
