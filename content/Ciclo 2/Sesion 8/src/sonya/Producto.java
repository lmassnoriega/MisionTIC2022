package sonya;

public class Producto {
   
    private int codigo;
   
    private int cantidadBodega;
    private int cantidadMinima;
    private int cantidadMaxima;

    private static final float porcentajeDescuento = 1;
   
    private float precioCompra;
    private float precioVenta;


    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", cantidadBodega='" + getCantidadBodega() + "'" +
            ", cantidadMinima='" + getCantidadMinima() + "'" +
            ", cantidadMaxima='" + getCantidadMaxima() + "'" +
            ", precioCompra='" + getPrecioCompra() + "'" +
            ", precioVenta='" + getPrecioVenta() + "'" +
            "}";
    }

    public Producto() {
        
    }

    public boolean generarPedido() {
        if (this.cantidadMinima < this.cantidadBodega) {
            return true;
        }

        return false;
    }


    public float calcularTotalPagar(int cantidadUnidades) {
        return (
            this.precioCompra * cantidadUnidades
        );
    } 

    public float calcularTotalVenta(int cantidadUnidades) {
        this.cantidadBodega -= cantidadUnidades;
        return this.precioVenta * cantidadUnidades;
    }


    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidadBodega() {
        return this.cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public int getCantidadMinima() {
        return this.cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadMaxima() {
        return this.cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }


    public float getPrecioCompra() {
        return this.precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return this.precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

}
