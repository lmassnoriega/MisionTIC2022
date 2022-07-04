package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.Connect;

public class Productos {

    private int codigo;
    private String nombre;
    private int p_compra;
    private int p_venta;
    private int c_bodega;
    private int c_minima;
    private int c_maxima;


    public Productos() {
    }



    public Productos(String nombre, int p_compra, int p_venta, int c_bodega, int c_minima, int c_maxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.p_compra = p_compra;
        this.p_venta = p_venta;
        this.c_bodega = c_bodega;
        this.c_minima = c_minima;
        this.c_maxima = c_maxima;
    }


    public Productos(int codigo, String nombre, int p_compra, int p_venta, int c_bodega, int c_minima, int c_maxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.p_compra = p_compra;
        this.p_venta = p_venta;
        this.c_bodega = c_bodega;
        this.c_minima = c_minima;
        this.c_maxima = c_maxima;
    }



    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getP_compra() {
        return this.p_compra;
    }

    public void setP_compra(int p_compra) {
        this.p_compra = p_compra;
    }

    public int getP_venta() {
        return this.p_venta;
    }

    public void setP_venta(int p_venta) {
        this.p_venta = p_venta;
    }

    public int getC_bodega() {
        return this.c_bodega;
    }

    public void setC_bodega(int c_bodega) {
        this.c_bodega = c_bodega;
    }

    public int getC_minima() {
        return this.c_minima;
    }

    public void setC_minima(int c_minima) {
        this.c_minima = c_minima;
    }

    public int getC_maxima() {
        return this.c_maxima;
    }

    public void setC_maxima(int c_maxima) {
        this.c_maxima = c_maxima;
    }


    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", p_compra='" + getP_compra() + "'" +
            ", p_venta='" + getP_venta() + "'" +
            ", c_bodega='" + getC_bodega() + "'" +
            ", c_minima='" + getC_minima() + "'" +
            ", c_maxima='" + getC_maxima() + "'" +
            "}";
    }

    public void save(){

        try {

            Connect conexion = new Connect();
            Connection cn =  conexion.connect();

            String insertar = "INSERT INTO Productos (nombre, p_compra, p_venta, c_bodega, c_minima, c_maxima) VALUES ('" +  this.nombre + "' , " + this.p_compra + " , " + this.p_venta + " , " + this.c_bodega + " , "  +  this.c_minima + " , " + this.c_maxima + ")";
            System.err.println(insertar);
            //Connection conn = conexion.connect(); 
            Statement stm = cn.createStatement();
            stm.executeUpdate(insertar);
            System.out.println("Registro exitoso.");

        } catch (SQLException e) {
            System.out.println("Error en el registro: " + e.getMessage());
        }

    }

    public ResultSet allProductos(){
        ResultSet rs = null;
        try {

            Connect conexion = new Connect();
            Connection cn =  conexion.connect();
            String consulta = "SELECT * FROM Productos ORDER BY codigo ASC";
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(consulta);
            System.out.println("Consulta exitosa.");

        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }

        return rs;
    }

    
}
