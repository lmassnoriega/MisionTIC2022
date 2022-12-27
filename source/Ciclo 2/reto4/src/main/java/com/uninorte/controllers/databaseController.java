package com.uninorte.controllers;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseController {

    public Connection connect(){

        String url = "data/ideam.db";
        ////String url = getClass().getResource("../data/ideam.db").toString();
        //URL resource = getClass().getResource("ideam.db"); 
        Connection conn = null;
        try {
            //String url = new File(resource.toURI()).getAbsolutePath();
            conn = DriverManager.getConnection("jdbc:sqlite:"+url);
            System.out.println("Conectado a la BD");

        } catch (SQLException e) {
            System.out.println("Error de conexión a la BD: " + e.getMessage());
        }
        return conn;
    }

    
    
}