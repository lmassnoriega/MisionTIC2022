/**
 * @version 1.1 07/27/2021
 * @author Spartan Locke
 */
public class CuerpoDeAgua {

    private static final String[] IRCA_CA_STRINGS = {"SIN RIESGO", "BAJO", "MEDIO", "ALTO", "INVIABLE SANITARIAMENTE"};


    protected String nombre;
    private int id;
    private String municipio;
    protected float irca;

    /**
     * Constuctor basico que toma el nombre, identificador, nombre del municipio y clasificacion numerica IRCA.
     * @param Nombre Cadena de caracteres que representa el nombre del cuerpo de agua a crear.
     * @param ID Identificador numerico entero del cuerpo de agua a crear. No es autogenerado.
     * @param Municipio Cadena de caracteres que especifica el municipio en el que esta inscrito el cuerpo de agua a crear.
     * @param IRCA_level Valor de punto flotante con el valor IRCA del cuerpo de agua a crear. Este valor oscila entre 0 y 100.
     */
    public CuerpoDeAgua(String Nombre, int ID, String Municipio, float IRCA_level) {
        this.nombre = Nombre;
        this.id = ID;
        this.municipio = Municipio;
        this.irca = IRCA_level;
    }

    /**
     * Convierte la medida numerica IRCA en un valor agrupado entero segun esta primera clasificacion.
     * @param category_name Representa una cadena con el nombre de la categoria. Debe estar especificado en mayusculas.
     * @return Un numero entero entre 0 y 4 para las clasificaciones "SIN RIESGO", "BAJO", "MEDIO", "ALTO", "INVIABLE SANITARIAMENTE" respectivamente.
     * @see #IRCA_CA_STRINGS
     * @since 1.1
     */
    public static int index(String category_name) {
        for (int i = 0; i < IRCA_CA_STRINGS.length; i++) {
            if (IRCA_CA_STRINGS[i].equals(category_name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Convierte el valor numerico IRCA especificado al momento de crear el objeto en una etiqueta para presentacion visual.
     * @see #IRCA_CA_STRINGS
     * @since 1.0
     * @return El nombre de la categoria segun el valor numerico IRCA aportado al momento de crear el cuerpo de agua.
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
