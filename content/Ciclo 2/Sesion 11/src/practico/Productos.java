package practico;

public abstract class Productos{

    protected int codigo;
    protected String descripcion;
    protected double precio_compra;
    protected double precio_venta;
    protected int cantidad_bodega;
    protected int cantidad_minima;
    protected int cantidad_maxima;
    protected final static double DESCUENTO = 0.01;


    public Productos() {
    }



    public Productos(int codigo, String descripcion, double precio_compra, double precio_venta, int cantidad_bodega, int cantidad_minima, int cantidad_maxima) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad_bodega = cantidad_bodega;
        this.cantidad_minima = cantidad_minima;
        this.cantidad_maxima = cantidad_maxima;
    }


    public abstract boolean solicitarPedido();

    public abstract  double calcularPagar(int unidades, int dcto);
    /* 
    public boolean solicitarPedido(){
        if(this.cantidad_bodega < this.cantidad_minima){ return true; } else { return false; }
    }

    public double calcularPagar(int unidades){
        return (this.precio_venta * unidades) - ((this.precio_venta * unidades) * DESCUENTO);
    }

 */
    @Override
    public String toString() {
        return "Productos: {" +
            " codigo = " + this.codigo + "-" +
            ", descripcion = " + this.descripcion + "-" +
            ", precio_compra='" + this.precio_compra + "-" +
            ", precio_venta='" + this.precio_venta + "-" +
            ", cantidad_bodega='" + this.cantidad_bodega +  "-" +
            ", cantidad_minima='" + this.cantidad_minima + "-" +
            ", cantidad_maxima='" + this.cantidad_maxima + 
            "}";
    }
    

}
