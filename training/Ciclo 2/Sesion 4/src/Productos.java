public class Productos {

    //  final int OBESIDAD = 1;

    // Atributos
    int codigo;
    double precio;
    int cant_bod;
    int cant_req;

    //Contructor

    public Productos(int cod, double pre, int ca_bo, int ca_rq){
        this.codigo = cod;
        this.precio = pre;
        this.cant_bod = ca_bo;
        this.cant_req = ca_rq;
    }

    // Métodos
    public boolean solicitarPedido(){
        if(this.cant_bod < this.cant_req){
            return true;
        }
        else{
            return false;
        }
    } 
    
}
