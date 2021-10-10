package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.Connect;

public class Personas {

    private int id;
    private int identificacion;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private int curso_asig;
    private int tipo_persona;

    public Personas() {
    }

    public Personas(int id, int identificacion, String nombre, String apellido, String email, int edad, int curso_asig, int tipo_persona) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.curso_asig = curso_asig;
        this.tipo_persona = tipo_persona;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCurso_asig() {
        return this.curso_asig;
    }

    public void setCurso_asig(int curso_asig) {
        this.curso_asig = curso_asig;
    }


    public int getTipo_persona() {
        return this.tipo_persona;
    }

    public void setTipo_persona(int tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", identificacion='" + getIdentificacion() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", edad='" + getEdad() + "'" +
            ", curso_asig='" + getCurso_asig() + "'" +
            ", horario_asig='" + getTipo_persona() + "'" +
            "}";
    }

    public ResultSet allInstructores(){

        String allInstructores = "SELECT * FROM Personas WHERE tipo_persona = 1";
        ResultSet rstInst = null;
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement stm = cnx.createStatement();
            rstInst = stm.executeQuery(allInstructores);
            System.out.println("Instructores: consulta exitosa. ");
        } catch (SQLException e) {
            System.out.println("Instructores: consulta sin éxito. " + e.getMessage());
        }
        return rstInst;
    }


    public void save(){
        String save = "INSERT INTO Personas (identificacion, nombre, apellido , email, edad, curso_asig, tipo_persona)" 
        + "VALUES (" + this.identificacion + ", '" + this.nombre + "' , '" + this.apellido + "','" 
        +  this.email + "', " + this.edad + "," + this.curso_asig + "," + this.tipo_persona + ")";
        System.out.println(save);
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(save);
            System.out.println("Instructor: registro almacenado.");
        } catch (SQLException e) {
            System.out.println("Instructor: registro NO almacenado - " + e.getMessage());
        }
        

    }

    public ResultSet buscarInstructor(int identificacion){

        String buscarInstructor = "SELECT * FROM Personas WHERE identificacion = " + identificacion; 
        System.out.println(buscarInstructor);
        ResultSet resbuscarInstructor = null;
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement stm = cnx.createStatement();
            resbuscarInstructor  = stm.executeQuery(buscarInstructor);
            System.out.println("Instructor: consulta exitosa.");
        } catch (SQLException e) {
            System.out.println("Instructor: NO existe" + e.getMessage());
        }
        return resbuscarInstructor;

    }

    public void update(int id){
        System.out.println("EL IDE ES: "+ id);
        String update = "UPDATE Personas SET identificacion=" +  this.identificacion 
        + ", nombre = '" + this.nombre + "' , apellido = '" + this.apellido 
        + "', email = '" +  this.email + "', edad = " + this.edad 
        + ", curso_asig = " + this.curso_asig + ", tipo_persona = " + this.tipo_persona
        + " WHERE id = " + id ;
        System.out.println(update);
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(update);
            System.out.println("Instructor: registro actualizado.");
        } catch (SQLException e) {
            System.out.println("Instructor: registro NO actualizado - " + e.getMessage());
        }

    }

    public int buscarId(int identificacion) {
        String buscarIdInstructor = "SELECT id FROM Personas WHERE identificacion = " + identificacion; 
        System.out.println(buscarIdInstructor);
        ResultSet resId = null;
        int id = -1;
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement stm = cnx.createStatement();
            resId  = stm.executeQuery(buscarIdInstructor);
            System.out.println("EL IDE DESDE EL RESULE " + resId.getInt("id"));
            System.out.println("Instructor: Consulta de Id exitosa.");
            id = resId.getInt("id");
            resId.close();
        } catch (SQLException e) {
            System.out.println("Instructor: Id NO existe" + e.getMessage());
        }
        return id;
    }


    public void delete(int id){

        try {
            Connect conexion = new Connect();
            Connection cn =  conexion.connect();

            String eliminar = "DELETE FROM Personas WHERE id = " + id;
            System.out.println(eliminar);
            Connection conn = conexion.connect(); 
            Statement stm = cn.createStatement();
            stm.executeUpdate(eliminar);
            System.out.println("Instructor eliminado."); 

        } catch (SQLException e) {
            System.out.println("Error en la eliminación del instructor: " + e.getMessage());
        }
        
     }

}