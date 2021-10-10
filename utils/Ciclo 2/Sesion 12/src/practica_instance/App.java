package practica_instance;

public class App {

    public static void main(String[] args) {
        
        Empleado empleado = new Empleado(100, "Spider Man");
        //definirDetalle(empleado);
        instanciaDe(empleado);
        

        empleado = new Gerente(200, "Goku", "Escenario1");
        
        //instanciaDe(empleado);
        

        empleado = new Asesor(300, "Pedro", "Atención al cliente");
        
       
        //definirDetalle(empleado);
        

    }


    public static void definirDetalle(Empleado e){

        e.detalle();

    }


    public static void instanciaDe(Empleado e){

        if(e instanceof Gerente){
            System.out.println("Es del tipo Gerente");
            Gerente g = (Gerente)e;
            g.soloGerente();
            // ((Gerente)e).soloGerente(); // En una sola línea la conversión

        }else if(e instanceof Asesor){
            System.out.println("Es del tipo Asesor");

        }else if(e instanceof Empleado){
            System.out.println("Es del tipo Empleado");
            //Estas líneas generan un error en tiempo d eejecución.
            /*
            Gerente g = (Gerente)e;
            g.soloGerente();
            */
            
            e.detalle();
            
        }else if(e instanceof Object){
            System.out.println("Es del tipo Object");
        }

    }
    
}
