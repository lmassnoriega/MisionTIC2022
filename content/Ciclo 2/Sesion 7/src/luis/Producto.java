package luis;
public class Producto implements Comparable<Producto> {

    private static final float dsctoDefault = 1;

    protected int codigo;
    protected String nombre;
    private float valorCompra;
    private float valorVenta;
    private int existencia;
    private int stockMinimo;
    private int stockMaximo;
    private float dscto;

    @Override
    public String toString(){
        return "Codigo: ("+ String.valueOf(codigo) + "), Producto: "+ nombre + ", Existencia: " + String.valueOf(existencia);
    }

    public Producto(int Codigo, String Nombre) {
        this.codigo = Codigo;
        this.nombre = Nombre;
        this.existencia = 0;
    }

    public void ActualizarProducto(float valorCompra, float ValorVenta, int Existencia, int MinStock, int MaxStock, float Dscto){
        this.valorCompra = valorCompra;
        this.valorVenta = ValorVenta;
        this.existencia = Existencia;
        this.stockMinimo = MinStock;
        this.stockMaximo = MaxStock;
        try {
            this.dscto = Dscto;
        } catch (Exception e) {
            this.dscto = dsctoDefault;
        }
    }

    public boolean puedeDescargar(int unidades){
        return unidades <= existencia ? true : false;
    }

    public void descargar(int unidades){
        if (puedeDescargar(unidades)) {
            existencia -= unidades;
        } else {
            System.out.println("Cantidad insuficiente para realizar el descargue");
        }
    }

    public boolean puedeVerificarStock(){
        try {
            if (stockMinimo > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean requierePedido(){
        if (puedeVerificarStock()) {
            return existencia <= stockMinimo ? true : false;
        }
        System.out.println("Se debe parametrizar antes el stock minimo para verificar el estado del producto");
        return false;
    }

    public boolean puedeComprar(int unidades){
        try {
            if (this.valorCompra > 0) {
                if (this.existencia>= unidades) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Se debe parametrizar el valor de compra con anterioridad");
        }
        return false;
    }

    public float subtotalItem(int unidades){
        if (puedeComprar(unidades)) {
            return unidades * this.valorCompra;
        }
        return 0;
    }

    public void ActualizarStockMinimo(int MinStock){
        if (MinStock> 0) {
            stockMinimo = MinStock;
        } else {
            stockMinimo = 0;
        }
    }

    @Override
    public int compareTo(Producto o) {
        if (existencia == o.existencia) {
            return 0;
        } else {
            if (existencia > o.existencia) {
                return 1;
            } else {
                return -1;
            }   
        }
    }
}
