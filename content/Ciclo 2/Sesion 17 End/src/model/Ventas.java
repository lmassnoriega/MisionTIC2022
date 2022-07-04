package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connect.Connect;

public class Ventas {


    private int id_venta;

    private int codigocliente;
    private int codigoproducto;
    private int cantidad;


    public Ventas() {
    }


    public Ventas(int codigocliente, int codigoproducto, int cantidad) {
        this.codigocliente = codigocliente;
        this.codigoproducto = codigoproducto;
        this.cantidad = cantidad;
    }


    public Ventas(int id_venta, int codigocliente, int codigoproducto, int cantidad) {
        this.id_venta = id_venta;
        this.codigocliente = codigocliente;
        this.codigoproducto = codigoproducto;
        this.cantidad = cantidad;
    }




    public int getId_venta() {
        return this.id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCodigocliente() {
        return this.codigocliente;
    }

    public void setCodigocliente(int codigocliente) {
        this.codigocliente = codigocliente;
    }

    public int getCodigoproducto() {
        return this.codigoproducto;
    }

    public void setCodigoproducto(int codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public void save(){

        try {

            Connect conexion = new Connect();
            Connection cn =  conexion.connect();

            String insertar = "INSERT INTO Ventas (codigocliente, codigoproducto, cantidad) VALUES ( " +  this.codigocliente + " ,  " + this.codigoproducto + "  , " + this.cantidad + ")";
            System.err.println(insertar);
            //Connection conn = conexion.connect(); 
            Statement stm = cn.createStatement();
            stm.executeUpdate(insertar);
            System.out.println("Registro exitoso.");

        } catch (SQLException e) {
            System.out.println("Error en el registro: " + e.getMessage());
        }


    }

    
}
