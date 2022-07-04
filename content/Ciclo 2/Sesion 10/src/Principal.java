public class Principal {
    public static void main(String[] args) throws Exception {
        // Objeto número 1
        Vehiculo vehi1 = new Vehiculo("1998");
        System.out.println("Modelo del auto: " + vehi1.getModelo());

        vehi1.calcular();
        vehi1.calcular(1500);

        // Objeto número 2
        Vehiculo vehi2 = new Vehiculo();
        vehi2.setModelo("8888");
        vehi2.setFabricante("Mazda");
        vehi2.setValor(9000);
        System.out.println(vehi2.getModelo());
        System.out.println(vehi2.getFabricante());
        System.out.println(vehi2.getValor());

        


        // AHORA DESDE LA CLASE HIJA SUPER
        Super hijo1 = new Super();
        hijo1.mostrarPrecio();
        System.out.println(hijo1);

        Super hijo2 = new Super("modelo2021", "Chevrolet", 23, 2333333, true);
        System.err.println(hijo2.toString());


        //PROBANDO DESDE VEHICULO2 Y TAXI 
        Taxi taxi1 = new Taxi("UVY - 345", 4);
        System.out.println(taxi1);

        Taxi taxi2 = new Taxi();
        taxi2.resistencia = 23.4;
        taxi2.setMatricula("HHH - 000");
        System.out.println(taxi2);

    }
}
