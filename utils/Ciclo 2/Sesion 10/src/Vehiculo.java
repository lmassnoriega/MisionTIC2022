public class Vehiculo{

    private String modelo;
    private String fabricante;
    private int valor;
    protected double precio_venta;
    

    public Vehiculo() {
        
    }
    

    public Vehiculo(String modelo) {
        this.modelo = modelo;
    }


    public Vehiculo(String modelo, String fabricante) {
        this.modelo = modelo;
        this.fabricante = fabricante;
    }


    public Vehiculo(String modelo, String fabricante, int valor, double precio_venta) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.valor = valor;
        this.precio_venta = precio_venta;
    }



    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }


    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    public void calcular(){
        System.out.println(this.valor);
    }

    public void calcular(int otrovalor){
        this.valor = 2000;
        System.out.println(valor - otrovalor);
    }


}