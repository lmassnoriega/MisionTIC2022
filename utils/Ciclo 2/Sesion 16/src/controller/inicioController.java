package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.midi.Soundbank;

import connect.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Productos;
import controller.registrarVentaController;;

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
    private ListView<String> listaProductos;

    @FXML
    private Button btnProductos;

    @FXML
    private Button btnCrearVenta;

   

    @FXML
    void createProduct(ActionEvent event) {

        int cod = Integer.parseInt(codigo.getText());
        String nom = this.nombre.getText();
        int p_compra = Integer.parseInt(compra.getText());
        int p_venta = Integer.parseInt(venta.getText());
        int c_bodega = Integer.parseInt(bodega.getText());
        int c_minima = Integer.parseInt(minima.getText());
        int c_maxima = Integer.parseInt(maxima.getText());
        

        Productos productos = new Productos(nom, p_compra, p_venta, c_bodega, c_minima, c_maxima);
        System.err.println(productos);
        productos.save();


    }


    ObservableList<String> listadoProductos = FXCollections.observableArrayList();

    @FXML
    void mostrarProductos(ActionEvent event) throws SQLException {
        Productos prod =new Productos();
        ResultSet consulta = prod.allProductos();
        //System.out.println( "Numero: " + consulta.getRow());
        //listaProductos.setItems(listadoProductos);
        while(consulta.next()){
       
            listadoProductos.add(consulta.getString("codigo") + "-" + consulta.getString("nombre"));
            
            
        }
        listaProductos.getItems().get
        
        if ( listaProductos.getItems() != null){
            listaProductos.getItems().clear();
            listaProductos.getItems().setAll(listadoProductos);
        } 

    }


    @FXML
    void crearVenta(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/registrarVenta.fxml"));
        Parent root = loader.load();
        registrarVentaController venta = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("INGRESÓ A LA SESIÓN");
        stage.show();


    }

    
}
