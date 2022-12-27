package com.uninorte.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.uninorte.models.CuerpoDeAgua;

public class CuerpodeAguaController {
    private databaseController dbConnect;

    public CuerpodeAguaController() {
        this.dbConnect = new databaseController();
    }
    
    public databaseController getConnection() {
        return this.dbConnect;
    }

    public ArrayList<CuerpoDeAgua> GetAllCuerpos(){
        ArrayList<CuerpoDeAgua> results= new ArrayList<>();
        ResultSet rows = null;
        try {
            Connection conn = dbConnect.connect();
            String query = "SELECT * FROM CuerpoAgua";
            java.sql.Statement command = conn.createStatement();
            rows = command.executeQuery(query);
            while (rows.next()) {
                CuerpoDeAgua row = new CuerpoDeAgua(rows.getString("name"), rows.getInt("id"), rows.getString("municipio"), rows.getString("tipoCuerpo"), rows.getString("tipoAgua"), rows.getFloat("irca"));
                results.add(row);
            }
            System.out.println("Todos los cuerpos Exitosos");
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return results;
    }

    public CuerpoDeAgua getCuerpo(int id){
        CuerpoDeAgua result= null;
        ResultSet rows = null;
        try {
            Connection conn = dbConnect.connect();
            String query = "SELECT * FROM CuerpoAgua where id = "+String.valueOf(id);
            java.sql.Statement command = conn.createStatement();
            rows = command.executeQuery(query);
            boolean flag = true;
            while (rows.next() && flag ) {
                result = new CuerpoDeAgua(rows.getString("name"), rows.getInt("id"), rows.getString("municipio"), rows.getString("tipoCuerpo"), rows.getString("tipoAgua"), rows.getFloat("irca"));
                flag = false;
            }
            System.out.println("Hallado cuerpo de agua con id "+String.valueOf(id));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return result;
    }

    public void insertCuerpo(String nombre, String municipio, String tipoCuerpo, String tipoAgua, Float irca ){
        try {
            Connection conn = dbConnect.connect();
            String query = "INSERT INTO CuerpoAgua(name, municipio, tipoCuerpo, tipoAgua, irca) VALUES ('"+nombre+
                            "', '"+municipio+"', '"+tipoCuerpo+"', '"+tipoAgua+"'," +String.valueOf(irca)+")";
            java.sql.Statement command = conn.createStatement();
            command.executeUpdate(query);
            System.out.println("Cuerpo de Agua creado correctamente.");
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void updateCuerpo(int id, String nombre, String municipio, String tipoCuerpo, String tipoAgua, Float irca ){
        try {
            Connection conn = dbConnect.connect();
            String query = "update CuerpoAgua"+
                            " set name = '"+nombre+"', municipio = '"+municipio+"', tipoCuerpo = '"+tipoCuerpo+"', tipoAgua = '"+tipoAgua+"', irca = "+String.valueOf(irca)+
                            " where id ="+String.valueOf(id);
            java.sql.Statement command = conn.createStatement();
            command.executeUpdate(query);
            System.out.println("Hallado cuerpo de agua con id "+String.valueOf(id));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void deleteCuerpo(int id){
        try {
            Connection conn = dbConnect.connect();
            String query = "DELETE FROM CuerpoAgua where id = "+String.valueOf(id);
            java.sql.Statement command = conn.createStatement();
            command.executeUpdate(query);
            System.out.println("Eliminado cuerpo de agua con id "+String.valueOf(id));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }


}
