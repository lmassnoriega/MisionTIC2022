package locke;

public abstract class Producto implements Comparable<Producto> {
    
    private static final float VAR_DSCTO = 0.01f;

    private int codigo;
    private String descripcion;
    private float precioCompra;
    private float precioVenta;
    private int stock;
    private int minStock;
    private int maxStock;
    private float descuento;

    //#region Constructor 

    /**
     * 
     * @param codigo
     * @param descripcion
     * @param precioCompra
     * @param precioVenta
     * @param stock
     * @param minStock
     * @param maxStock
     * @param descuento
     */
    public Producto(int codigo, String descripcion, float precioCompra, float precioVenta, int stock, int minStock, int maxStock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.descuento = VAR_DSCTO;
    }

    //#endregion
    
    //#region Metodos Abstractos

    protected abstract boolean solicitarPedido();

    protected abstract void totalPagar();

    protected abstract void mostrar();

    //#endregion

    //#region Getters y Setters

    protected int getCodigo() {
        return this.codigo;
    }

    protected void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    protected String getDescripcion() {
        return this.descripcion;
    }

    protected void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    protected float getPrecioCompra() {
        return this.precioCompra;
    }

    protected void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    protected float getPrecioVenta() {
        return this.precioVenta;
    }

    protected void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    protected int getStock() {
        return this.stock;
    }

    protected void setStock(int stock) {
        this.stock = stock;
    }

    protected int getMinStock() {
        return this.minStock;
    }

    protected void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    protected int getMaxStock() {
        return this.maxStock;
    }

    protected void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    protected float getDescuento() {
        return this.descuento;
    }

    protected void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    //#endregion

}
