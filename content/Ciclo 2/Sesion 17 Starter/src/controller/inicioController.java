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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    private Button btnOtrasOperaciones;

    @FXML
    void createProduct(ActionEvent event) {
        
            if(!nombre.getText().isEmpty()){
                if(!compra.getText().isEmpty()){
                    if(!venta.getText().isEmpty()){
                        if(!bodega.getText().isEmpty()){
                            if(!minima.getText().isEmpty()){
                                if(!maxima.getText().isEmpty()){
                                    String nom = this.nombre.getText();
                                    int p_compra = Integer.parseInt(this.compra.getText());
                                    int p_venta = Integer.parseInt(this.venta.getText());
                                    int c_bodega = Integer.parseInt(this.bodega.getText());
                                    int c_minima = Integer.parseInt(this.minima.getText());
                                    int c_maxima = Integer.parseInt(this.maxima.getText());
                                    
                                    Productos productos = new Productos(nom, p_compra, p_venta, c_bodega, c_minima, c_maxima);
                                    System.out.println(productos);
                                    productos.save();
                                    this.nombre.clear();
                                    this.compra.clear();
                                    this.venta.clear();
                                    this.bodega.clear();
                                    this.minima.clear();
                                    this.maxima.clear();
                                    this.nombre.requestFocus();
                                }else{
                                    Alert alerta = new Alert(AlertType.INFORMATION, "Cantidad máxima vacía");
                                    alerta.showAndWait();
                                    maxima.requestFocus();
                                    //JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                //Alerta
                                Alert alerta = new Alert(AlertType.INFORMATION, "Cantidad mínima vacía");
                                alerta.showAndWait();
                                minima.requestFocus();
                            }
                        }else{
                            Alert alerta = new Alert(AlertType.INFORMATION, "Cantidad en bodega vacía");
                            alerta.showAndWait();
                            bodega.requestFocus();
                        }

                    }else{
                        Alert alerta = new Alert(AlertType.INFORMATION, "Venta vacía");
                        alerta.showAndWait();
                        venta.requestFocus();
                    }
                }else{
                    Alert alerta = new Alert(AlertType.INFORMATION, "Compra vacía");
                    alerta.showAndWait();
                    compra.requestFocus();
                }
            }else{
                Alert alerta = new Alert(AlertType.INFORMATION, "Nombre vacío");
                alerta.showAndWait();
                nombre.requestFocus();
            }
        //int cod = Integer.parseInt(codigo.getText());
    }


    ObservableList<String> listadoProductos = FXCollections.observableArrayList();

    @FXML
    void mostrarProductos(ActionEvent event) throws SQLException {
        Productos prod =new Productos();
        ResultSet consulta = prod.allProductos();
        
        if(listadoProductos.size()>0){
            listadoProductos.clear();
        }
        while(consulta.next()){
            listadoProductos.add(consulta.getString("codigo") + "-" + consulta.getString("nombre")); 
        }
        listaProductos.getItems().setAll(listadoProductos);

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


    @FXML
    void otrasOperaciones(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/otrasOperaciones.fxml"));
        Parent root = loader.load();
        otrasOperacionesController otras_operaciones = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Productos: actualizar / eliminar");
        stage.show();


    }
    
}
