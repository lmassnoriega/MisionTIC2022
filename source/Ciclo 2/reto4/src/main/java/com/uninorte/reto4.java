package com.uninorte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Reto4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/layout.fxml"));
        Parent mainWindow = loader.load();
        Scene scene = new Scene(mainWindow);

        stage.setTitle("Cuerpos de Agua");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}