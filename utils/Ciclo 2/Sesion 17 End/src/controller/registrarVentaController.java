package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import connect.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Clientes;
import model.Productos;
import model.Ventas;

public class registrarVentaController implements Initializable {

    @FXML
    private TextField cedula;

    @FXML
    private TextField nombreCli;

    @FXML
    private TextField apellido;

    @FXML
    private TextField genero;

    @FXML
    private Button btnGuardarCliente;

    @FXML
    private ComboBox<String> cbProducto;

    @FXML
    private ComboBox<String> cbCliente;

    @FXML
    private TextField cantidad;

    @FXML
    private Button btnRegistrarVenta;


    
    
    ObservableList<String> lstProductos = FXCollections.observableArrayList();
    ObservableList<String> lstClientes = FXCollections.observableArrayList();

    public void actualizarListaCombos(){
        try {

            Productos producto = new Productos();
            ResultSet rsprod = producto.allProductos();

            Clientes cliente = new Clientes();
            ResultSet rscli = cliente.allClientes();

            if(lstProductos.size()>0){
                lstProductos.clear();
            }
            while(rsprod.next()){
                lstProductos.add(rsprod.getString("codigo") + "-" + rsprod.getString("nombre"));
                cbProducto.getItems().setAll(lstProductos); 
                cbProducto.getSelectionModel().selectFirst();
            }
            
            if(lstClientes.size()>0){
                lstClientes.clear();
            }
            while(rscli.next()){
                lstClientes.add(rscli.getString("id_cliente") + "-" + rscli.getString("nombre"));
                cbCliente.getItems().setAll(lstClientes);
                cbCliente.getSelectionModel().selectFirst();
            }
            
        } catch (SQLException e) {
            System.out.println("Error en la carga de datos: " + e.getMessage());
         }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        actualizarListaCombos();
    }

    @FXML
    void guardarCliente(ActionEvent event) {
        

        if( !cedula.getText().isEmpty()){
            if( !nombreCli.getText().isEmpty()){
                if( !apellido.getText().isEmpty()){
                    if(!genero.getText().isEmpty()){
                        int ced = Integer.parseInt(cedula.getText());
                        String nom = this.nombreCli.getText();
                        String ape = this.apellido.getText();
                        String gen = this.genero.getText();

                        Clientes cliente = new Clientes(ced, nom, ape, gen);
                        cliente.save();
                        cedula.clear();
                        nombreCli.clear();
                        apellido.clear();
                        genero.clear();
                        cedula.requestFocus();
                        actualizarListaCombos();

                    }else{

                            
                        String text = "El género del cliente no puede estar vacío";
                        Alert alerta = new Alert(AlertType.INFORMATION, text);
                        alerta.showAndWait();
                        genero.requestFocus();
                    }
                }else{
                        String text = "El apellido del cliente no puede estar vacío";
                        Alert alerta = new Alert(AlertType.INFORMATION, text);
                        alerta.showAndWait();
                        apellido.requestFocus();
                    }
            }else{
                    String text = "El nombre del cliente no puede estar vacío";
                    Alert alerta = new Alert(AlertType.INFORMATION, text);
                    alerta.showAndWait();
                    nombreCli.requestFocus();
                }
        }else{
                String text = "La cédula del cliente no puede estar vacía";
                Alert alerta = new Alert(AlertType.INFORMATION, text);
                alerta.showAndWait();
                cedula.requestFocus();

        } 
    }  


    @FXML
    void registrarVenta(ActionEvent event) {

        String codPRod[] = cbProducto.getSelectionModel().getSelectedItem().split("-");
        String codCliente[] = cbCliente.getSelectionModel().getSelectedItem().split("-");
        

        if(!cantidad.getText().isEmpty()){
            int cant = Integer.parseInt(this.cantidad.getText());
            Ventas venta = new Ventas(Integer.parseInt(codCliente[0]), Integer.parseInt(codPRod[0]), cant);
            venta.save();
            initialize(null, null);
        }else{
            String text = "La cantidad a vender no puede estar vacía";
            Alert alerta = new Alert(AlertType.INFORMATION, text);
            alerta.showAndWait();
            cantidad.requestFocus();
        }


    }


}
