package locke;

import java.util.ArrayList;
import java.util.Collections;

public class Boutique {

    private ArrayList<PrendaVestir> ropa;
    private ArrayList<Calzado> calzado;

    //#region Constructror
    public Boutique() {
        ropa = new ArrayList<>();
        calzado = new ArrayList<>();
    }
    //#endregion

    //#region Opciones Tienda

    public void consultarProducto(int codigo, int tipo) {
        boolean flag = false;
        var coleccion = (tipo == 1 ) ? this.ropa : this.calzado;
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i).getCodigo() == codigo) {
                coleccion.get(i).mostrar();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No se encontro el producto con el codigo " + codigo);
        }
    }

    public void VerificarProductoAPedir(){
        for (Calzado zapato : this.calzado) {
            if (zapato.solicitarPedido()) {
                // TO DO Mostrar informacion para pedir calzado
            }
        }
        for (PrendaVestir prenda : this.ropa) {
            if (prenda.solicitarPedido()) {
                // TO DO Mostrar informacion para pedir ropa
            }
        }
    }

    public void productoConMasStock(int tipo){
        var coleccion = (tipo == 1 ) ? this.ropa : this.calzado;
        Collections.sort(coleccion);
        
    }

    //#endregion

    public static void main(String[] args) {
        Boutique LOccitane = new Boutique();
    }
}
