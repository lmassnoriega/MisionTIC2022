public class Taxi extends Vehiculo2 {

    private int numsillas;


    public Taxi(){
        super();
    }

    public Taxi(String matricula, int numsillas)
    {
        super(matricula);
        this.numsillas = numsillas;  // variable  propia de  la clase taxi
    }


    public Taxi(double resistencia, int numerosillas){
        super(resistencia);
        this.numsillas = numerosillas;
    }


    public int getNumsillas() {
        return this.numsillas;
    }

    public void setNumsillas(int numsillas) {
        this.numsillas = numsillas;
    }

    

    @Override
    public String toString() {
        return "{" + super.toString() + 
            " numsillas='" + getNumsillas() +  "}";
    }

    
}
