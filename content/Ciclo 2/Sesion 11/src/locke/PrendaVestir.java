package locke;

public class PrendaVestir extends Producto{

    private int talla;
    private boolean permitePlanchado;

    //#region Constructor

    public PrendaVestir(int talla, boolean permitePlanchado,  int codigo, String descripcion, float precioCompra, float precioVenta, int stock, int minStock, int maxStock) {
        super(codigo, descripcion, precioCompra, precioVenta, stock, minStock, maxStock);
        this.talla = talla;
        this.permitePlanchado = permitePlanchado;
    }

    //#endregion

    //#region Getters y Setters

    public int getTalla() {
        return this.talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public boolean isPermitePlanchado() {
        return this.permitePlanchado;
    }

    public boolean getPermitePlanchado() {
        return this.permitePlanchado;
    }

    public void setPermitePlanchado(boolean permitePlanchado) {
        this.permitePlanchado = permitePlanchado;
    }

    //#endregion

    //#region Metodos Abstractos

    @Override
    protected boolean solicitarPedido() {
        return (this.getStock() < this.getMinStock())? true : false;        
    }

    @Override
    protected float totalPagar(int unidades) {
        return getPrecioCompra() * unidades;   
    }

    @Override
    protected void mostrar() {
        System.out.println("Prenda de Vestir: \n" +
            "Codigo = " + this.getCodigo() + " - " +
            "Descripcion = " + this.getDescripcion() + " - " +
            "Precio de Compra =" + this.getPrecioCompra()+ " - " +
            "Precio de Venta = " + this.getPrecioVenta()+ " - " +
            "Existencia = " + this.getStock() + " - " +
            "Talla = " + this.getTalla() + " - " +
            "Planchado = " + ((this.getPermitePlanchado()) ? "Si":"No" )
        );
    }

    @Override
    public int compareTo(Producto o) {
        if (getStock() == o.getStock()) {
            return 0;
        } else {
            if (getStock() > o.getStock()) {
                return 1;
            } else {
                return -1;
            }   
        }
    }
    
    //#endregion
}
