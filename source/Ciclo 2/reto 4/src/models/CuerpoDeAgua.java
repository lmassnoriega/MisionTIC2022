package models;

/**
 * @version 1.2 08/03/2021
 * @author Spartan Locke
 */
public class CuerpoDeAgua extends ObjetoGeografico {

    private static final String[] IRCA_CA_STRINGS = {"SIN RIESGO", "BAJO", "MEDIO", "ALTO", "INVIABLE SANITARIAMENTE"};

    protected String nombre;
    private String tipoAgua;
    private String tipoCuerpo;
    private int id;
    protected float irca;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAgua() {
        return this.tipoAgua;
    }

    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    public String getTipoCuerpo() {
        return this.tipoCuerpo;
    }

    public void setTipoCuerpo(String tipoCuerpo) {
        this.tipoCuerpo = tipoCuerpo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getIrca() {
        return this.irca;
    }

    public void setIrca(float irca) {
        this.irca = irca;
    }
    
    /**
     * Constuctor basico que toma el nombre, identificador, nombre del municipio y clasificacion numerica IRCA.
     * @param Nombre Cadena de caracteres que representa el nombre del cuerpo de agua a crear.
     * @param ID Identificador numerico entero del cuerpo de agua a crear. No es autogenerado.
     * @param Municipio Cadena de caracteres que especifica el municipio en el que esta inscrito el cuerpo de agua a crear.
     * @param IRCA_level Valor de punto flotante con el valor IRCA del cuerpo de agua a crear. Este valor oscila entre 0 y 100.
     */
    public CuerpoDeAgua(String Nombre, int ID, String Municipio, String TipoCuerpo, String TipoAgua, float IRCA_level) {
        super(Municipio);
        this.nombre = Nombre;
        this.id = ID;
        this.tipoAgua = TipoAgua;
        this.tipoCuerpo = TipoCuerpo;
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
