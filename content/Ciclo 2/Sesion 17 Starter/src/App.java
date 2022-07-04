import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{


    public void start(Stage primaryStage) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("INTERFAZ LOGIN CON SCENE BUILDER");
        primaryStage.show();
        
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
