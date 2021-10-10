package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.Connect;

public class Clientes {

    
    private int id_cliente;
    private int cedula;
    private String nombre;
    private String apellido;
    private String genero;


    public Clientes() {
    }


    public Clientes( int cedula, String nombre, String apellido, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }



    public Clientes(int id_cliente, int cedula, String nombre, String apellido, String genero) {
        this.id_cliente = id_cliente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }



    public int getId_cliente() {
        return this.id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



    @Override
    public String toString() {
        return "{" +
            " id_cliente='" + getId_cliente() + "'" +
            ", cedula='" + getCedula() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", genero='" + getGenero() + "'" +
            "}";
    }

    public void save(){

        try {

            Connect conexion = new Connect();
            Connection cn =  conexion.connect();

            String insertar = "INSERT INTO Clientes (cedula, nombre, apellido, genero) VALUES (" +  this.cedula + " , ' " + this.nombre + " ' , ' " + this.apellido + " ' , ' " + this.genero + "' )";
            System.err.println(insertar);
            //Connection conn = conexion.connect(); 
            Statement stm = cn.createStatement();
            stm.executeUpdate(insertar);
            System.out.println("Registro exitoso.");

        } catch (SQLException e) {
            System.out.println("Error en el registro: " + e.getMessage());
        }

    }

    public ResultSet allClientes(){
        ResultSet rs = null;
        try {

            Connect conexion = new Connect();
            Connection cn =  conexion.connect();
            String consulta = "SELECT * FROM Clientes ORDER BY id_cliente ASC";
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(consulta);
            System.out.println("Consulta exitosa.");

        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }

        return rs;
    }

    
}
