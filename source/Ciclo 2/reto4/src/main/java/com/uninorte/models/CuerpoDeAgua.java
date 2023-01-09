package com.uninorte.models;

/**
 * @version 1.2 08/03/2021
 * @author Spartan Locke
 */
public class CuerpoDeAgua extends ObjetoGeografico {

    private static final String[] IRCA_CA_STRINGS = { "SIN RIESGO", "BAJO", "MEDIO", "ALTO",
            "INVIABLE SANITARIAMENTE" };

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
     * Constructor básico que toma el nombre, identificador, nombre del municipio y
     * clasificación numérica IRCA.
     * 
     * @param nombre    Cadena de caracteres que representa el nombre del cuerpo de
     *                  agua a crear.
     * @param id        Identificador numérico entero del cuerpo de agua a crear. No
     *                  es autogenerado.
     * @param municipio Cadena de caracteres que especifica el municipio en el que
     *                  está inscrito el cuerpo de agua a crear.
     * @param ircaLevel Valor de punto flotante con el valor IRCA del cuerpo de agua
     *                  a crear. Este valor oscila entre 0 y 100.
     */
    public CuerpoDeAgua(String nombre, int id, String municipio, String tipoCuerpo, String tipoAgua, float ircaLevel) {
        super(municipio);
        this.nombre = nombre;
        this.id = id;
        this.tipoAgua = tipoAgua;
        this.tipoCuerpo = tipoCuerpo;
        this.irca = ircaLevel;
    }

    /**
     * Convierte la medida numérica IRCA en un valor agrupado entero según esta
     * primera clasificación.
     * 
     * @param categoryName Representa una cadena con el nombre de la categoría.
     *                     Debe estar especificado en mayúsculas.
     * @return Un número entero entre 0 y 4 para las clasificaciones "SIN RIESGO",
     *         "BAJO", "MEDIO", "ALTO", "INVIABLE SANITARIAMENTE" respectivamente.
     * @see #IRCA_CA_STRINGS
     * @since 1.1
     */
    public static int index(String categoryName) {
        for (int i = 0; i < IRCA_CA_STRINGS.length; i++) {
            if (IRCA_CA_STRINGS[i].equals(categoryName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Convierte el valor numérico IRCA especificado al momento de crear el objeto
     * en una etiqueta para presentación visual.
     * 
     * @see #IRCA_CA_STRINGS
     * @since 1.0
     * @return El nombre de la categoría según el valor numérico IRCA aportado al
     *         momento de crear el cuerpo de agua.
     */
    public String nivel() {
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