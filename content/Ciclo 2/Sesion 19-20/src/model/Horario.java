package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.Connect;

public class Horario{

    private int id;
    private int dia;
    private String hora;


    public Horario() {
    }

    public Horario(int id, int dia, String hora) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", dia='" + getDia() + "'" +
            ", hora='" + getHora() + "'" +
            "}";
    }

    public ResultSet allHorarios(){
        String todosHorarios = "SELECT * FROM Horario ORDER BY id ASC";
        ResultSet rset = null;
        try {
            Connect connect = new Connect();
            Connection cnx = connect.connect();
            Statement st = cnx.createStatement();
            rset = st.executeQuery(todosHorarios);
        } catch (Exception e) { System.out.println("Error en la consulta de Cursos: " + e.getMessage()); }
        return rset;
    }


    
}