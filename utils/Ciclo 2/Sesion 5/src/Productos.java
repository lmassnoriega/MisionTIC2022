public class Productos {
    
    private int codigo;
    private double precio;
    private int cant_bodega;
    private int cant_minima;

    // Contructor(es)
    public Productos(){
        
    }

    public Productos(int id, double prec, int bod, int min){    
        this.codigo = id;
        this.precio = prec;
        this.cant_bodega = bod;
        this.cant_minima = min;
    }

    // GET y SET

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    // Otros métodos
    public boolean solicitarProducto(){
        if(this.cant_bodega < this.cant_minima){return true;}
        else{ return false; }
    }

    // Sobreescritura del método toString
    
    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", cant_bodega='" + getCant_bodega() + "'" +
            ", cant_minima='" + getCant_minima() + "'" +
            "}";
    }
    
    



}
