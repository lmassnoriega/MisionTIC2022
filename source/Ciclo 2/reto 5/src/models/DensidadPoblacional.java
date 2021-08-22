package models;

public class DensidadPoblacional extends ObjetoGeografico{

    public DensidadPoblacional(String municipio) {
        super(municipio);

    }

    public static int afeccion(int habitantes){
        if (habitantes<10000) {
            return 0;
        }
        else{
            if (habitantes<50000) {
                return 1;
            }
            return 2;
        }
    }
}
