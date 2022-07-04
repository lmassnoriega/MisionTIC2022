package practico;



public  class Calzado extends Productos {
    
    private int talla;


    public Calzado() {
    }


    public Calzado(int codigo, String descripcion, double precio_compra, double precio_venta, int cantidad_bodega, int cantidad_minima, int cantidad_maxima, int talla) {
        super(codigo, descripcion, precio_compra, precio_venta, cantidad_bodega, cantidad_minima, cantidad_maxima);
        this.talla = talla;
    }


    public int getTalla() {
        return this.talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(" Código: ").append(codigo);
        strb.append(" Descripcion: ").append(descripcion);
        strb.append(" Precio compra: ").append(precio_compra);
        strb.append(" Precio venta: ").append(precio_venta);
        strb.append(" Cantidad Bodega: ").append(cantidad_bodega);
        strb.append(" Cantidad Mínima: ").append(cantidad_minima);
        strb.append(" Cantidad Máxima: ").append(cantidad_maxima);
        strb.append(" Talla: ").append(this.talla);
        return strb.toString();
    }

}
