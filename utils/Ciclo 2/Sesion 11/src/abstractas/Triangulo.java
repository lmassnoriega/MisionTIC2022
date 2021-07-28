package abstractas;

public class Triangulo extends FiguraGeometrica{

    
    public Triangulo(){

    }

    public Triangulo(String tipoFigura){
        super(tipoFigura);
    }

    @Override
    public void calcularArea(){
        System.out.println("Escritura desde el triángulo");
        System.out.println("Me llamo " + this.tipoFigura);
        System.out.println("Soy del tipo " + this.getClass().getSimpleName());
        System.out.println("_____________________________");
    }
    
    
}
