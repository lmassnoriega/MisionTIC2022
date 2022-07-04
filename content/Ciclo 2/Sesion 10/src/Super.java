import java.lang.StringBuilder;

public class Super extends Vehiculo {

    private boolean frenosABS;

    public Super(){

    }

    public Super(String modelo, String fabricante, int valor, double precio_venta, boolean tieneFrenos){
        super(modelo, fabricante, valor, precio_venta);
        this.frenosABS = tieneFrenos;
    }


    public boolean isFrenosABS() {
        return this.frenosABS;
    }

    public boolean getFrenosABS() {
        return this.frenosABS;
    }

    public void setFrenosABS(boolean frenosABS) {
        this.frenosABS = frenosABS;
    }



    public void mostrarPrecio(){
        System.out.println("Valor del precio de venta desde el hijo:" + this.precio_venta);
    }


    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(" Modelo: ").append(super.getModelo());
        strb.append(" Fabricante: ").append(super.getFabricante());
        strb.append(" Valor: ").append(this.getValor());
        strb.append(" Precio venta: ").append(this.precio_venta);
        strb.append(" Tiene frenos ABS: ").append(this.frenosABS);
        return strb.toString();
    }


}
