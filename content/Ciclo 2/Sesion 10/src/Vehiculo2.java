public class Vehiculo2 {
    
        private String matricula;
        protected double resistencia;

        public Vehiculo2(){

        }

        public Vehiculo2(double resistencia){
            this.resistencia = resistencia;
        }   

        public Vehiculo2(String matricula) {
            this.matricula = matricula;   	
        }


        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }


    @Override
    public String toString() {
        return  " matricula='" + getMatricula() ;
    }
        


}

