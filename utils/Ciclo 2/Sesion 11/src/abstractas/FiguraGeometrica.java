package abstractas;

public abstract class FiguraGeometrica {

    protected String tipoFigura;

    public FiguraGeometrica(){

    }

    public FiguraGeometrica(String tipoFigura){
        this.tipoFigura = tipoFigura;
    }


    public String getTipoFigura() {
        return this.tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    public abstract void calcularArea();
    
/* 
    public void calcularArea(String tipoFigura){
        System.out.println("Soy del tipo " + this.getClass().getSimpleName());
    } */ 
    
}
