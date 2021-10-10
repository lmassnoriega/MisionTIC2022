package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connect;

public class Curso{

        private int codigo;
        private String nombre;
        private int id_horario;
        private int id_instructor;


    public Curso() {
    }

    
    public Curso(String nombre, int id_horario, int id_instructor) {
        this.nombre = nombre;
        this.id_horario = id_horario;
        this.id_instructor = id_instructor;
    }

    public Curso(int codigo, String nombre, int id_horario, int id_instructor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.id_horario = id_horario;
        this.id_instructor = id_instructor;
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

    public int getId_horario() {
        return this.id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }



    public int getId_instructor() {
        return this.id_instructor;
    }

    public void setId_instructor(int id_instructor) {
        this.id_instructor = id_instructor;
    }


    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", id_horario='" + getId_horario() + "'" +
            "}";
    }

    public void save(){
        String save = "INSERT INTO Cursos (nombre, id_horario, id_instructor) VALUES ('" + this.nombre + "' , " + this.id_horario + ", " +  this.id_instructor + ")";
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(save);
            System.out.println("Cursos: registro almacenado.");
        } catch (SQLException e) {
            System.out.println("Cursos: registro NO almacenado - " + e.getMessage());
        }
    }

    public ResultSet allCursos(){
        String allCursos = "SELECT * FROM Cursos ORDER BY codigo ASC";
        ResultSet rstCursos = null;
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement stm = cnx.createStatement();
            rstCursos = stm.executeQuery(allCursos);
            System.out.println("Cursos: consulta exitosa. ");
        } catch (SQLException e) {
            System.out.println("Cursos: consulta sin éxito. " + e.getMessage());
        }
        return rstCursos;
    }

}