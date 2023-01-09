package com.uninorte.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uninorte.Reto4;

public class DatabaseController {

    private static final Logger logger = LogManager.getLogger(DatabaseController.class);

    public Connection connect(){

        String url = Reto4.class.getResource("data/ideam.db").toString();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+url);
            logger.info("Conectado a la BD");

        } catch (SQLException e) {
            logger.error("Error de conexión a la BD: " + e.getMessage());
        }
        return conn;
    }

    
    
}