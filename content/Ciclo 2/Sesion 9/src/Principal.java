public class Principal {
    public static void main(String[] args) throws Exception {
        
        Taxi taxi1 = new Taxi();
        System.out.println(taxi1);

        taxi1.setNumeroLicencia(10000);
        System.out.println(taxi1.getNumeroLicencia());

        Taxi taxi2 = new Taxi(888, 555, "Cualquiera", 34.7);
        System.out.println(taxi2);

        Taxi taxi3 = new Taxi(999, 99, "HJC", 78.9, 322);
        System.out.println(taxi3);

    }
}
