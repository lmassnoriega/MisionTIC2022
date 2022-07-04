public class App {
    public static void main(String[] args) throws Exception {
        
        Herramientas op1 = new Herramientas("Taladro de percusión satelital jajaj");
        op1.funciones();        
        System.out.println(op1.jefeinmediato());
        op1.compromisosComportamentales();        

     


        Admin adm1 = new Admin();
        System.out.println(adm1.jefeinmediato());
        adm1.funciones();
        adm1.compromisosComportamentales();    


    }
}
