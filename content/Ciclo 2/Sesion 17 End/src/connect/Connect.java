package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {


    // 1. Crear la cadena de conexion
    // 2 . Objecto de conexión

    //3 . Utilizar el DriverManager y su método getConnect y almacenarlo en una variable tipo
    // Connection
    //4.  Capturar el SQLException
    //5 .retornar la variable tipo Connection


    public Connection connect(){

        String url = "src/bd/almacen.db";
        
        Connection conex = null;

        try {
            
            conex = DriverManager.getConnection("jdbc:sqlite:"+url);
            System.out.println("Conectado a la BD");

        } catch (SQLException e) {
            System.out.println("Error de conexión a la BD: " + e.getMessage());
        }
        return conex;
    }
    
}
