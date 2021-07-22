
public class Calculadora {

    // Atributos
    int numero1;
    int numero2;

    // Constructor vacío
   public Calculadora(){

   }

    // Constructor con argumentos
    public Calculadora(int x, int y){
        this.numero1 = x;
        this.numero2 = y;
    }


    // Métodos
    public void v(int numero1){
        this.numero1 = numero1;
    }

    public void saludo(){
        System.out.println("HOLA POO");
    }

    public int sumar(){
        int resultado = this.numero1 + this.numero2;
        return resultado;
    }
   
    public int sumar(int v1, int v2){
        int resultado = v1 + v2;
        return resultado;
    }

   
    
}
