import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Tienda {
    private ArrayList<Producto> inventario;
    public static BufferedReader lector;
    public BufferedReader lector2;

    public Tienda() {
        inventario = new ArrayList<Producto>();
    }

    //#region Metodos

    public boolean ConsultarInventario(){
        if (inventario.size() == 0) {
            System.out.println("No hay productos en inventario");
            return false;
        }
        return true;
    }

    public void ConsultarProductos(){ // Opcion 1
        if (ConsultarInventario()) {
            for (Producto producto : inventario) {
                System.out.println(producto.toString());
            }
        }
    }

    public void CrearInventario(){
        lector2 = new BufferedReader(new InputStreamReader(System.in));
        boolean completo = false;
        do {
            String oper2="";
            do {
                System.out.println("Ingrese el nombre del producto a crear, escriba listo cuando haya terminado");
                try {
                    oper2 = lector2.readLine();
                } catch (Exception ex) {}
            } while (existeProducto(oper2));
            if (oper2.equals("listo")) {
                System.out.println("Inventario ingresado");
                completo = true;
            } else {
                inventario.add(new Producto(inventario.size()+1, oper2));
                System.out.println("Producto "+oper2+" ingresado correctamente.");
            }
        } while (!completo);
    }

    public void ActualizarProductos(){
        lector2 = new BufferedReader(new InputStreamReader(System.in));
        boolean completo = false;
        do {
            String oper2="";
            do {
                System.out.println("Ingrese el codigo del producto a actualizar, escriba listo cuando haya terminado");
                try {
                    oper2 = lector2.readLine();
                } catch (Exception ex) {}
            } while (!existeCodigoProducto(oper2));

            if (oper2.equals("listo")) {
                System.out.println("Modificaciones completadas");
                completo = true;
            } else {
                String oper3 = "";
                int codigoProducto = Integer.parseInt(oper2);
                try {
                    System.out.println("Digite precio de compra, el precio de venta, la cantidad en bodega, la cantidad mínima requerida y la cantidad máxima de inventario permitida separadas por espacios");
                    oper3 = lector2.readLine();
                    String datosProducto[] = oper3.split(" ");
                    obtenerProducto(codigoProducto).ActualizarProducto(Float.parseFloat(datosProducto[0]), Float.parseFloat(datosProducto[1]), Integer.parseInt(datosProducto[2]), Integer.parseInt(datosProducto[3]), Integer.parseInt(datosProducto[4]), 1);
                } catch (Exception e) {
                }
                System.out.println("Datos actualiaados correctamente "+ obtenerProducto(codigoProducto).toString());
            }
        } while (!completo);
    }

    public void VerificarPedido(){
        if (ConsultarInventario()) {
            for (Producto producto : inventario) {
                if (producto.requierePedido()) {
                    System.out.println("Cantidad reducida del producto "+producto.nombre.toUpperCase()+". Considere solicitar mas al proveedor.");
                }
            }
        }
    }
    public void Sobreoferta(){
        Collections.sort(inventario);
        for (Producto producto : inventario) {
            System.out.println(producto.toString());
        }
    }

    public void Comprar(){
        lector2 = new BufferedReader(new InputStreamReader(System.in));
        boolean completo = false;
        do {
            String oper2="";
            do {
                System.out.println("Ingrese el codigo del producto a comprar, o escriba listo cuando haya terminado");
                try {
                    oper2 = lector2.readLine();
                } catch (Exception ex) {}
            } while (!existeCodigoProducto(oper2));

            if (oper2.equals("listo")) {
                System.out.println("Compra completada");
                completo = true;
            } else {
                String oper3 = "";
                int codigoProducto = Integer.parseInt(oper2);
                try {
                    System.out.println("Digite la cantidad de unidades a comprar ");
                    oper3 = lector2.readLine();
                    int compra = Integer.parseInt(oper3);
                    System.out.println("Subtotal de la compra: "+obtenerProducto(codigoProducto).nombre+": $"+obtenerProducto(codigoProducto).subtotalItem(compra));
                } catch (Exception e) {
                }
            }
        } while (!completo);
    }

    public void ActualizarStockMinimo(){
        lector2 = new BufferedReader(new InputStreamReader(System.in));
        boolean completo = false;
        do {
            String oper2="";
            do {
                System.out.println("Ingrese el codigo del producto a actualizar, escriba listo cuando haya terminado");
                try {
                    oper2 = lector2.readLine();
                } catch (Exception ex) {}
            } while (!existeCodigoProducto(oper2));

            if (oper2.equals("listo")) {
                System.out.println("Modificaciones completadas");
                completo = true;
            } else {
                String oper3 = "";
                int codigoProducto = Integer.parseInt(oper2);
                try {
                    System.out.println("Digite la cantidad mínima requerida en bodega del producto ");
                    oper3 = lector2.readLine();
                    int stock = Integer.parseInt(oper3);
                    obtenerProducto(codigoProducto).ActualizarStockMinimo(stock);
                } catch (Exception e) {
                }
                System.out.println("Datos actualizados correctamente "+ obtenerProducto(codigoProducto).toString());
            }
        } while (!completo);
    }
    //#endregion



    //#region Validaciones

    public Producto obtenerProducto(int codigo){
        for (Producto producto : inventario) {
            if (producto.codigo == codigo) {
                return producto;
            }
        }
        return null;
    }

    public boolean existeCodigoProducto(String codigo){
        try {
            int codigo_revisar = Integer.parseInt(codigo);
            for (Producto producto : inventario) {
                if (producto.codigo == codigo_revisar) {
                    return true;
                }
            }            
        } catch (Exception e) {
            return true;
        }
        return false;
    }


    public boolean existeProducto(String nombre){
        for (Producto producto : inventario) {
            if (producto.nombre.toLowerCase().equals(nombre.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean Verificar(String text){
        if (text.isEmpty()) {
            return false;
        }
        else{
            if (text.equals("salir")) {
                return true;
            }
            try {
                int opcion = Integer.parseInt(text);
                if (opcion < 8) {
                    return true;
                }
                return false;

            } catch (Exception e) {
                return false;
            }
        }
    }

    public void Magic(int operacion){
        switch (operacion){
            case 1:
                ConsultarProductos();
                break;
            case 2:
                CrearInventario();
                break;
            case 3:
                ActualizarProductos();
                break;
            case 4:
                VerificarPedido();
                break;
            case 5:
                Sobreoferta();
                break;
            case 6:
                Comprar();
                break;
            case 7:
                ActualizarStockMinimo();
                break;
            default:
                break;
        }

    }

    ////#endregion

    

    public static void main(String[] args) throws Exception {
        Tienda D1 = new Tienda();
        System.out.println("Bienvenido a la tienda!");

        lector = new BufferedReader(new InputStreamReader(System.in));
        String oper; 
        do {
            oper="";
            do {
                System.out.println("Selecciona una opcion");
                System.out.println("1. Consultar productos");
                System.out.println("2. Ingresar productos");                
                System.out.println("3. Actualizar datos de productos");
                System.out.println("4. Verificar stock");
                System.out.println("5. Verificar stock excedente");
                System.out.println("6. Ingresar compra de cliente");
                System.out.println("7. Actualizar stocks");
                System.out.println("salir");
                try {
                    oper = lector.readLine();
                } catch (Exception ex) {}
            } while (!Verificar(oper));
            if (oper.equals("salir")) {
                System.out.println("Gracias por usar");
            } else {
                D1.Magic(Integer.parseInt(oper));
            }
        } while (!oper.equals("salir"));
    }
}
