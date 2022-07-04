import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App  extends Application{


    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        /* FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("D:/Roymer/MisionTIC2022/CICLO2/demo_javafx_52/demo_scene_52/demo_scene_52/src/login.fxml"));

        loader.getClass().getResource("login.fxml");

        Parent root = loader.load(); */
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("INTERFAZ CON SCENE BUILDER");
        primaryStage.show();

    }

    public static void main(String[] args) throws Exception {
        
            launch(args);
    }
}
