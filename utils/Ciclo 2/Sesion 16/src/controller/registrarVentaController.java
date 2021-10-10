package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connect.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
        try {

            Productos producto = new Productos();
            
            ResultSet rsprod = producto.allProductos();
            System.out.println("Productos: " + rsprod.getRow());

            Clientes cliente = new Clientes();
            ResultSet rscli = cliente.allClientes();
            System.out.println("Cleintes: " + rscli.getRow());

            while(rsprod.next()){
                lstProductos.add(rsprod.getString("codigo") + "-" + rsprod.getString("nombre"));
                
            }
            cbProducto.getItems().setAll(lstProductos); 
            cbProducto.getSelectionModel().selectFirst();
    
            while(rscli.next()){
                lstClientes.add(rscli.getString("id_cliente") + "-" + rscli.getString("nombre"));
                cbCliente.getItems().setAll(lstClientes);
                cbCliente.getSelectionModel().selectFirst();
            }
            
        } catch (SQLException e) {
            System.out.println("Error en la carga de datos: " + e.getMessage());
         }
    }

    @FXML
    void guardarCliente(ActionEvent event) {


        int ced = Integer.parseInt(cedula.getText());
        String nom = this.nombreCli.getText();
        String ape = this.apellido.getText();

        String gen = this.genero.getText();

        Clientes cliente = new Clientes(ced, nom, ape, gen);
        System.err.println(cliente);
        cliente.save();

    }


    @FXML
    void registrarVenta(ActionEvent event) {


        String codPRod[] = cbProducto.getSelectionModel().getSelectedItem().split("-");
        String codCliente[] = cbCliente.getSelectionModel().getSelectedItem().split("-");
        int cant = Integer.parseInt(this.cantidad.getText());

        Ventas venta = new Ventas(Integer.parseInt(codCliente[0]), Integer.parseInt(codPRod[0]), cant);
        venta.save();
        initialize(null, null);


    }


}
