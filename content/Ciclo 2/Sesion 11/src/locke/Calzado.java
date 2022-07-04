package locke;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Calzado extends Producto{

    private int talla;


    public Calzado(int talla, int codigo, String descripcion, float precioCompra, float precioVenta, int stock, int minStock, int maxStock) {
        super(codigo, descripcion, precioCompra, precioVenta, stock, minStock, maxStock);
        this.talla = talla;
    }


    public int getTalla() {
        return this.talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }


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
        System.out.println("Calzado: \n" +
            "Codigo = " + this.getCodigo() + " - " +
            "Descripcion = " + this.getDescripcion() + " - " +
            "Precio de Compra =" + this.getPrecioCompra()+ " - " +
            "Precio de Venta = " + this.getPrecioVenta()+ " - " +
            "Existencia = " + this.getStock() + " - " +
            "Talla = " + this.getTalla()
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
    
}
