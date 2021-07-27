package practico;
import java.util.Scanner;



public class PrincipalCPsesion10_52 {

    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);
        System.out.println("Cantidad de Prendas: ");
        int c_prendas = lector.nextInt();
        Prendas v_prendas[] = new Prendas[c_prendas];
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("Códig Prenda: ");
            int cod_prenda = lector.nextInt();
            System.out.println("Descripción: ");
            String des_prenda = lector.nextLine();
            lector.nextLine();
            System.out.println("Precio compra: ");
            double p_compra = lector.nextDouble();
            System.out.println("Precio venta: ");
            double p_venta = lector.nextDouble();
            System.out.println("Bodega: ");
            int c_bodega = lector.nextInt();
            System.out.println("Mínima: ");
            int c_minima = lector.nextInt();
            System.out.println("Máxima: ");
            int c_maxima = lector.nextInt();
            lector.nextLine();
            System.out.println("Talla: ");
            String t_prenda = lector.nextLine();
            System.out.println("Planchado: ");
            boolean planchado = lector.nextBoolean();

            v_prendas[i] = new Prendas(cod_prenda, des_prenda, p_compra, p_venta, c_bodega, c_minima, c_maxima, t_prenda, planchado);
        }
        
        
        System.out.println("Cantidad de Calzado: ");
        int c_calzado = lector.nextInt();
        Calzado v_calzado[] = new Calzado[c_calzado];
        for (int i = 0; i < args.length; i++) {
            System.out.println("Códig Prenda: ");
            int cod_calzado = lector.nextInt();
            System.out.println("Descripción: ");
            String des_calzado = lector.nextLine();
            lector.nextLine();
            System.out.println("Precio compra: ");
            double p_compra_calzado = lector.nextDouble();
            System.out.println("Precio venta: ");
            double p_venta_calzado = lector.nextDouble();
            System.out.println("Bodega: ");
            int c_bodega_calzado = lector.nextInt();
            System.out.println("Mínima: ");
            int c_minima_calzado = lector.nextInt();
            System.out.println("Máxima: ");
            int c_maxima_calzado = lector.nextInt();
            lector.nextLine();
            System.out.println("Talla: ");
            int t_calzado = lector.nextInt();

            v_calzado[i] = new Calzado(cod_calzado, des_calzado, p_compra_calzado, p_venta_calzado, c_bodega_calzado, c_minima_calzado, c_maxima_calzado, t_calzado);
        }
        int opt = 0;
        do{
            System.out.println("MENU PRINCIPAL");
            System.out.println("1- Consultar producto  [P: prenda | C: calzado]: ");
            System.out.println("2- Verificar pedido al proveedor: ");
            System.out.println("3- Prenda con mayor cantidad en bodega: ");
            System.out.println("4- Calzado con mayor cantidad en bodega:");
            System.out.println("5- Modificar cantidad mínima:");
            System.out.println("6- Vender producto:");
            System.out.println("7 - SALIR");
            System.out.println("OPCION: ");
            opt = lector.nextInt();
            
            switch (opt) {
                case 1:
                    System.out.println("Tipo de producto  [P: prenda | C: calzado]: ");
                    String tipo = lector.nextLine();
                    if (tipo.equals("P")){    
                        System.out.println("Códigop del producto: ");
                        int cod = lector.nextInt();
                        int i=0, sw =0;
                        while(i<c_prendas && sw == 0){
                            if (v_prendas[i].codigo == cod){
                                System.out.println("ELEMENTO ENCONTRADO");
                                System.out.println(v_prendas[i]);
                                sw = 1;
                            }
                            i++;
                        }
                        if (sw == 0){
                            System.out.println("ELEMENTO NO ENCONTRADO");
                        }
                    }else if (tipo.equals("C")){
                        System.out.println("Códigop del producto: ");
                        int cod = lector.nextInt();
                        int i=0, sw =0;
                        while(i<c_calzado && sw == 0){
                            if (v_calzado[i].codigo == cod){
                                System.out.println("ELEMENTO ENCONTRADO");
                                System.out.println(v_calzado[i]);
                                sw = 1;
                            }
                            i++;
                        }
                        if (sw == 0){
                            System.out.println("ELEMENTO NO ENCONTRADO");
                        }
                    }else{
                        System.out.println("OPCION INVÁLIDA");
                    }
                    break;
                
                case 2:
                    
                    System.out.println("PRENDAS");
                    for(Prendas prenda: v_prendas){
                        if(prenda.solicitarPedido()){
                            System.out.println("ALERTA: PEDIDO AL CÓDIGO " + prenda.codigo);
                        }
                    }

                    System.out.println("CALZADO");
                    for(Calzado prenda: v_calzado){
                        if(prenda.solicitarPedido()){
                            System.out.println("ALERTA: PEDIDO AL CÓDIGO " + prenda.codigo);
                        }
                    }
                    break;
                
                case (3): //PRENDAS CON MAYOR CANTIDAD DE UNIDADES
                    int mayor = 0, pos = 0;
                    for (int i = 0; i < c_prendas; i++) {
                        if (v_prendas[i].cantidad_bodega > mayor){
                            mayor = v_prendas[i].cantidad_bodega;
                            pos = i;
                        }
                        
                    }
                    System.out.println("Prenda con mayot cantidad de unidades es: " + v_prendas[pos].cantidad_bodega);
                    break;

                case (4): //PRENDAS CON MAYOR CANTIDAD DE UNIDADES
                    mayor = 0; pos = 0;
                    for (int i = 0; i < c_calzado; i++) {
                        if (v_calzado[i].cantidad_bodega > mayor){
                            mayor = v_calzado[i].cantidad_bodega;
                            pos = i;
                        }
                        
                    }
                    System.out.println("Calzado con mayot cantidad de unidades es: " + v_calzado[pos].cantidad_bodega);
                    break;


                default:
                    break;
            }



        }while(opt != 7);



    }
    
    
}
