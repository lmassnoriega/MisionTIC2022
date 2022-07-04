public class Productos {
    

    private int codigo;
    private double prec_compra;
    private double prec_venta;
    private int cant_bodega;
    private int cant_minima;
    private int cant_maxima;
	private final double descuento = 0.01;

    public Productos(int codigo, double prec_compra, double prec_venta, int cant_bodega, int cant_minima, int cant_maxima) {
        this.codigo = codigo;
        this.prec_compra = prec_compra;
        this.prec_venta = prec_venta;
        this.cant_bodega = cant_bodega;
        this.cant_minima = cant_minima;
        this.cant_maxima = cant_maxima;
    }



    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrec_compra() {
        return this.prec_compra;
    }

    public void setPrec_compra(double prec_compra) {
        this.prec_compra = prec_compra;
    }

    public double getPrec_venta() {
        return this.prec_venta;
    }

    public void setPrec_venta(double prec_venta) {
        this.prec_venta = prec_venta;
    }

    public int getCant_bodega() {
        return this.cant_bodega;
    }

    public void setCant_bodega(int cant_bodega) {
        this.cant_bodega = cant_bodega;
    }

    public int getCant_minima() {
        return this.cant_minima;
    }

    public void setCant_minima(int cant_minima) {
        this.cant_minima = cant_minima;
    }

    public int getCant_maxima() {
        return this.cant_maxima;
    }

    public void setCant_maxima(int cant_maxima) {
        this.cant_maxima = cant_maxima;
    }

    public double getDescuento() {
        return this.descuento;
    }


    public boolean solicitarPedido(){
        if(this.cant_bodega < this.cant_minima){ return true; } else { return false; }
    }

    public double totalAPagar(int unidades){
        return (this.prec_venta * unidades) - ((this.prec_venta * unidades) * descuento);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", prec_compra='" + getPrec_compra() + "'" +
            ", prec_venta='" + getPrec_venta() + "'" +
            ", cant_bodega='" + getCant_bodega() + "'" +
            ", cant_minima='" + getCant_minima() + "'" +
            ", cant_maxima='" + getCant_maxima() + "'" +
            ", descuento='" + getDescuento() + "'" +
            "}";
    }






}
