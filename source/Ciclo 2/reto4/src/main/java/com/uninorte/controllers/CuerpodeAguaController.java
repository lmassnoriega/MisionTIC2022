package com.uninorte.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uninorte.models.CuerpoDeAgua;

public class CuerpodeAguaController {
    
    private static final Logger logger = LogManager.getLogger(CuerpodeAguaController.class);
    private DatabaseController dbConnect;

    public CuerpodeAguaController() {
        this.dbConnect = new DatabaseController();
    }
    
    public DatabaseController getConnection() {
        return this.dbConnect;
    }

    public List<CuerpoDeAgua> getAllCuerpos() {
        ArrayList<CuerpoDeAgua> results= new ArrayList<>();
        ResultSet rows = null;
        Connection conn = dbConnect.connect();
        String query = "SELECT * FROM CuerpoAgua";
        try (java.sql.Statement command = conn.createStatement()){
            rows = command.executeQuery(query);
            while (rows.next()) {
                CuerpoDeAgua row = new CuerpoDeAgua(rows.getString("name"), rows.getInt("id"), rows.getString("municipio"), rows.getString("tipoCuerpo"), rows.getString("tipoAgua"), rows.getFloat("irca"));
                results.add(row);
            }
            logger.info("Todos los cuerpos Exitosos");
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return results;
    }

    public CuerpoDeAgua getCuerpo(int id){
        CuerpoDeAgua result= null;
        ResultSet rows = null;
        Connection conn = dbConnect.connect();
        String query = "SELECT * FROM CuerpoAgua where id = " + id;
        try (java.sql.Statement command = conn.createStatement()){
            rows = command.executeQuery(query);
            boolean flag = true;
            while (rows.next() && flag ) {
                result = new CuerpoDeAgua(rows.getString("name"), rows.getInt("id"), rows.getString("municipio"), rows.getString("tipoCuerpo"), rows.getString("tipoAgua"), rows.getFloat("irca"));
                flag = false;
            }
            logger.info("Hallado cuerpo de agua con id "+id);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return result;
    }

    public void insertCuerpo(String nombre, String municipio, String tipoCuerpo, String tipoAgua, Float irca) {
        Connection conn = dbConnect.connect();
        String query = "INSERT INTO CuerpoAgua(name, municipio, tipoCuerpo, tipoAgua, irca) VALUES ('" + nombre +
                "', '" + municipio + "', '" + tipoCuerpo + "', '" + tipoAgua + "'," + irca + ")";
        try (java.sql.Statement command = conn.createStatement()){
            command.executeUpdate(query);
            logger.info("Cuerpo de Agua creado correctamente.");
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void updateCuerpo(int id, String nombre, String municipio, String tipoCuerpo, String tipoAgua, Float irca) {
        Connection conn = dbConnect.connect();
        String query = "update CuerpoAgua" +
                " set name = '" + nombre + "', municipio = '" + municipio + "', tipoCuerpo = '" + tipoCuerpo
                + "', tipoAgua = '" + tipoAgua + "', irca = " + irca +
                " where id =" + id;
        try (java.sql.Statement command = conn.createStatement()){
            command.executeUpdate(query);
            logger.info("Hallado cuerpo de agua con id "+id);
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void deleteCuerpo(int id) {
        Connection conn = dbConnect.connect();
        String query = "DELETE FROM CuerpoAgua where id = "+id;
        try(java.sql.Statement command = conn.createStatement()) {
            command.executeUpdate(query);
            logger.info("Eliminado cuerpo de agua con id "+id);
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}
