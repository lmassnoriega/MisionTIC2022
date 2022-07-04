import java.util.Scanner;


public class Productos {

    private int codigo;
    private double precio_compra;
    private int cantidad_bodega;
    private int cantidad_minima;
    private int cantidad_maxima;
    private static double porcentaje = 0.01;


    public Productos() {
    }

    public Productos(int codigo, double precio_compra, int cantidad_bodega, int cantidad_minima, int cantidad_maxima) {
        this.codigo = codigo;
        this.precio_compra = precio_compra;
        this.cantidad_bodega = cantidad_bodega;
        this.cantidad_minima = cantidad_minima;
        this.cantidad_maxima = cantidad_maxima;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio_compra() {
        return this.precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getCantidad_bodega() {
        return this.cantidad_bodega;
    }

    public void setCantidad_bodega(int cantidad_bodega) {
        this.cantidad_bodega = cantidad_bodega;
    }

    public int getCantidad_minima() {
        return this.cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public boolean solicitarPedido(){
        if(this.cantidad_bodega < this.cantidad_minima){ return true; } else { return false;}
    }

    public int getCantidad_maxima() {
        return this.cantidad_maxima;
    }

    public double totalPagar(double precio, int unidades){
        return (precio * unidades) - ((precio * unidades)*porcentaje) ;
    }

    public void setCantidad_maxima(int cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", precio_compra='" + getPrecio_compra() + "'" +
            ", cantidad_bodega='" + getCantidad_bodega() + "'" +
            ", cantidad_minima='" + getCantidad_minima() + "'" +
            ", cantidad_maxima='" + getCantidad_maxima() + "'" +
            "}";
    }


    
}
