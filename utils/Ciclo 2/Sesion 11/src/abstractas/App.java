package abstractas;

public class App {

    public static void main(String[] args) {
        
        // Sin polimorfismo
        Triangulo trian1 = new Triangulo("Triangulo sin polimorfismo");
        trian1.calcularArea();

        // Con polimorfismo
        FiguraGeometrica figura  = new Triangulo("Triangulo acutángulo");
        //figura.calcularArea();
        tipoFiguraGeometrica(figura);

        FiguraGeometrica figura1  = new Triangulo("Triangulo obtusángulo");
        //figura1.calcularArea();
        tipoFiguraGeometrica(figura1);

        figura1 = new Rectangulo("Rectangulo");
        tipoFiguraGeometrica(figura1);

    }

    public static void tipoFiguraGeometrica(FiguraGeometrica figura)
    {
        figura.calcularArea();
    }
    
}
