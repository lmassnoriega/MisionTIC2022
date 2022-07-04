package practico;

public class Prendas extends Productos {

    private String talla;
    private boolean planchado;


    public Prendas() {
    }



    public Prendas(int codigo, String descripcion, double precio_compra, double precio_venta, int cantidad_bodega, int cantidad_minima, int cantidad_maxima, String talla, boolean planchado) {
        super(codigo, descripcion, precio_compra, precio_venta, cantidad_bodega, cantidad_minima, cantidad_maxima);
        this.talla = talla;
        this.planchado = planchado;
    }


    public String getTalla() {
        return this.talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public boolean isPlanchado() {
        return this.planchado;
    }

    public boolean getPlanchado() {
        return this.planchado;
    }

    public void setPlanchado(boolean planchado) {
        this.planchado = planchado;
    }

    public boolean solicitarPedido(){
        if(this.cantidad_bodega < this.cantidad_minima){ return true; } else { return false; }
    }

    public double calcularPagar (int unidades, int dct){
        if (dct == 0){ 
            return this.precio_venta * unidades;
        }else {
            return (this.precio_venta * unidades) - ((this.precio_venta * unidades) * DESCUENTO);
        }
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
        strb.append(" Planchado: ").append(this.planchado);
        return strb.toString();
    }


    
    
}
