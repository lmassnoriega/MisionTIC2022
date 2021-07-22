public class PrincipalEstatico {
    

    public static void main(String[] args) {
        
        Estatico est1 = new Estatico();
        Estatico est2 = new Estatico();
        Estatico est3 = new Estatico(01, "Pepito");

        est1.setCodigo(12);
        est1.setNombre("Roymer");

        System.out.println(est1.getCodigo());
        System.out.println(est1.getNombre());
        
        System.out.println(Estatico.codigoPostal());
        //System.out.println(Estatico.codigoPostal);

        System.out.println("OBJ1: " + Estatico.codigoPostal());
        System.out.println("OBJ2: " + Estatico.codigoPostal());
        System.out.println(Estatico.codigoPostal());
        
        System.out.println(est1);







    }
}
