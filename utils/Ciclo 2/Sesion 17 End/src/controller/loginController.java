package controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebHistory;
import javafx.stage.Stage;
import model.Productos;

public class loginController {

    @FXML
    private ImageView img;

    @FXML
    private TextField passwd;

    @FXML
    private TextField us;

    @FXML
    private Button btnLogin;

    @FXML
    private Label mensajeError;


    @FXML
    void mostrarMsg(ActionEvent event) {
        System.out.println("Mi primera interfaz con JFX");
    }

    


    @FXML
    void login(ActionEvent event) throws IOException {
        
        String usuario = this.us.getText();
        String contrasena = this.passwd.getText();
        String error = "";

        if(usuario.equals("prueba") || usuario.contains("prueba")){
            error  = "Usuario no válido’";
        }

        if (contrasena.length() < 6){
            error = "Contraseña debe contar con más de 6 caracteres. Intente nuevamente’";
        }else if (contrasena.equals(usuario)){
            error =  "Contraseña no puede ser igual a usuario. Intente nuevamente";
        }

        if(error.isEmpty()){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/inicioSesion.fxml"));
            Parent root = loader.load();
            inicioController inicio = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("INGRESÓ A LA SESIÓN");
            stage.show();

        }else{
            mensajeError.setText(error);

        }


    }

}
