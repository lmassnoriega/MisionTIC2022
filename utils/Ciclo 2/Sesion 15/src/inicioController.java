import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.midi.Soundbank;

import connect.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class inicioController {

    @FXML
    private TextField codigo;

    @FXML
    private TextField nombre;

    @FXML
    private TextField compra;

    @FXML
    private TextField venta;

    @FXML
    private TextField bodega;

    @FXML
    private TextField minima;

    @FXML
    private Button createProduct;

    @FXML
    private TextField maxima;

    @FXML
    void createProduct(ActionEvent event) {

        int cod = Integer.parseInt(codigo.getText());
        String nom = this.nombre.getText();
        int p_compra = Integer.parseInt(compra.getText());
        int p_venta = Integer.parseInt(venta.getText());
        int c_bodega = Integer.parseInt(bodega.getText());
        int c_minima = Integer.parseInt(minima.getText());
        int c_maxima = Integer.parseInt(maxima.getText());

        Connect conexion = new Connect();
        Connection conn = null;

        try {
            String insertar = "INSERT INTO productos (codigo, nombre, p_compra, p_venta, c_bodega, c_minima, c_maxima) VALUES (" +  cod + " , '" +  nom + "' , " + p_compra + " , " + p_venta + " , " + c_bodega + " , "  +  c_minima + " , " + c_maxima + ")";
            conn = conexion.connect(); 
            Statement stm = conn.createStatement();
            stm.executeUpdate(insertar);
            System.out.println("Registro exitoso.");

        } catch (SQLException e) {
            System.out.println("Error en el registro: " + e.getMessage());
        }

    }

}
