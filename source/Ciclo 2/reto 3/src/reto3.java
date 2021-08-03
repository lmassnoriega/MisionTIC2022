import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 */
public class reto3 {
    private ArrayList<CuerpoDeAgua> cuerpos;

    /**
     * 
     */
    public reto3() {
        this.cuerpos = new ArrayList<>();
    }

    /**
     * 
     * @param lectura
     */
    public void anadirCuerpo(String lectura){
        String datos[] = lectura.split(" ");
        CuerpoDeAgua cuerpo = new CuerpoDeAgua(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3], datos[4], Float.parseFloat(datos[5]));
        cuerpos.add(cuerpo);
    }

    /**
     * 
     */
    public void irca_individual(){
        for (CuerpoDeAgua cuerpo : cuerpos) {
            System.out.printf("%4.2f \n",cuerpo.irca);
        }
    }

    /**
     * 
     */
    public void cuerposBajosSinRiesgo(){
        float sinriesgos = 0;
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) < 2) {
                sinriesgos++;
            }
        }
        System.out.printf("%4.2f \n",sinriesgos);
    }

    /**
     * 
     */
    public void cuerposSinRiesgo(){
        String sinriesgos = "";
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) == 0) {
                sinriesgos += cuerpo.nombre + " " ;
            }
        }
        sinriesgos = sinriesgos.trim();

        if (sinriesgos.isEmpty()) {
            System.out.println("NA");
        }
        else{
            System.out.println(sinriesgos);
        }
    }

    /**
     * 
     */
    public void irca_promedio(){
        float suma = 0;
        for (CuerpoDeAgua cuerpoDeAgua : cuerpos) {
            suma += cuerpoDeAgua.irca;
        }
        System.out.printf("%4.2f",(suma/cuerpos.size()));
    }
    
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        reto3 actividad = new reto3();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try {
            int lecturas = Integer.parseInt(lector.readLine());
            for (int i = 0; i < lecturas; i++) {
                String data = lector.readLine();
                actividad.anadirCuerpo(data);
            }
        } catch (Exception e) {
        }
        actividad.irca_individual();
        actividad.cuerposBajosSinRiesgo();
        actividad.cuerposSinRiesgo();
        actividad.irca_promedio();
    }
}
