public class Admin extends Empleado  implements Funciones{

    public void funciones(){
        System.out.println("Mi funcion es gestionar recursos financeieros. ");
    }

    public String jefeinmediato(){
        return "Mi jefe es Juan De Los Palotes";
    }

    @Override
    public void compromisosComportamentales() {
        // TODO Auto-generated method stub
        System.out.println("Listar los compromisos lanborales concertados");
        
    }

}