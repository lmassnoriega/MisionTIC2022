package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public static Connection connect() {
        // Ruta donde está al db creada
        String url = "jdbc:sqlite:src/bd/Practica.db";

        Connection conn = null;

        try {
            // Creamos la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida.");
        } catch (SQLException e) {
            System.out.println("No hay conexión con la BD: " + e.getMessage());
        }
        return conn;
    }

}
