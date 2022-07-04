public class Estructuras{


    public static void main(String[] args){
    
        //Condicional doble
        int valor = 0;
        if (valor == 1){
            System.out.println("uno");
        }else{
            System.out.println("cero");
        }
        
        //Condicionales múltiples
        if(valor == 1){
            System.out.println("uno");
        }else if (valor ==3 ){
                System.out.println("tres"); 
            }else{
                System.out.println("culquiera"); 
            }
        

        //Condicionales anidados
        int otracondicion = 3;
        if(valor == 1){
            System.out.println("uno");
            if (otracondicion == 23){
                System.out.println("otra salida");
            }else{
                System.out.println("otra salida anidada");
                }
        }else 
            {
            System.out.println("tres"); 
            }


        //Dependiendo de / Según sea / switch
        String edad = "50";
        switch(edad){

            case ("18"):
                System.out.println("Esta en el límite de edad");
                break;
            
            case ("15"):
                System.out.println("Menor de edad");
                break;
            
            default:
                System.out.println("Otra edad");
                break;
            
        }


        // While y Do while (Mientas Que y Hacer - Mientras que)
        System.out.println("________________");
        boolean condicion = false;
        int contador = 50;
        while(condicion){
            System.out.println("Entra");
            contador = contador + 1;
            System.out.println(contador);
        }

        do{
            System.out.println("Entra");
            //contador = contador + 1;
            contador -= 10;
            System.out.println(contador);
        }while(condicion != false);

        
    
        for (int i=0; i<=10; i++){
            System.out.println(i);
        }







    }


}