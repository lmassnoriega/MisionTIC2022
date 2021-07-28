package abstractas;

public class Rectangulo extends FiguraGeometrica{

    
    public Rectangulo(){

    }

    public Rectangulo(String tipoFigura){
        super(tipoFigura);
    }

    @Override
    public void calcularArea(){
        System.out.println("Escritura desde el rectángulo");
        System.out.println("Me llamo " + this.tipoFigura);
        System.out.println("Soy del tipo " + this.getClass().getSimpleName());
        System.out.println("_____________________________");
    }
    
    
}
