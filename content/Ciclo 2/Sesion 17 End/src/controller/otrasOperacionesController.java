package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Productos;


public class otrasOperacionesController {

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
    private TextField maxima;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button bbtnEliminar;


    @FXML
    void consultarProducto(ActionEvent event) {

        Productos producto = new Productos();
        if(codigo.getText().isEmpty()){
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setContentText("Código no puede estar vacio.");
            alerta.showAndWait();
            codigo.requestFocus();
        }else{
            ResultSet prods = producto.oneProduct(Integer.parseInt(codigo.getText()));
            if (prods == null){
                System.out.println("ERROR");
            }else{
                try {
                    System.out.println(prods.getString("nombre"));
                    while(prods.next()){
                        this.nombre.setText(prods.getString("nombre"));
                        this.compra.setText(prods.getString("p_compra"));
                        this.venta.setText(prods.getString("p_venta"));
                        this.bodega.setText(prods.getString("c_bodega"));
                        this.minima.setText(prods.getString("c_minima"));
                        this.maxima.setText(prods.getString("c_maxima"));
                    }    
                } catch (SQLException e) {
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setContentText("Código de producto NO válido. Intente de nuevo.");
                    alerta.showAndWait();
                    codigo.requestFocus();
                    System.out.println("Error en la consulta del Producto: " + e.getMessage());
                }
            }
        }
    }


    @FXML
    public void update(){
        int cod = Integer.parseInt(this.codigo.getText());
        String nom = this.nombre.getText();
        int p_compra = Integer.parseInt(this.compra.getText());
        int p_venta = Integer.parseInt(this.venta.getText());
        int c_bodega = Integer.parseInt(this.bodega.getText());
        int c_minima = Integer.parseInt(this.minima.getText());
        int c_maxima = Integer.parseInt(this.maxima.getText());

        Productos producto = new Productos(nom, p_compra, p_venta, c_bodega, c_minima, c_maxima);
        producto.update(cod);
        this.codigo.clear();
        this.nombre.clear();
        this.compra.clear();
        this.venta.clear();
        this.bodega.clear();
        this.minima.clear();
        this.maxima.clear();
        this.codigo.requestFocus();
    }

    @FXML
    public void delete(){

        int cod = Integer.parseInt(this.codigo.getText());
        Productos producto = new Productos();
        producto.delete(cod);
        this.codigo.clear();
        this.nombre.clear();
        this.compra.clear();
        this.venta.clear();
        this.bodega.clear();
        this.minima.clear();
        this.maxima.clear();
        this.codigo.requestFocus();
        
    }

}