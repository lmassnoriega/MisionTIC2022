import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    
    public void start(Stage primaryStage) throws FileNotFoundException{

        FileInputStream input = new FileInputStream("D:/Roymer/MisionTIC2022/CICLO2/demo_javafx_52/demo_jfx_52/src/wonder.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);


        Label labelSaludo = new Label("Ejercicio con VBox.");
        labelSaludo.setFont(new Font("Arial", 30));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        Label labelUser = new Label("Usuario: ");
        labelUser .setFont(new Font("Arial", 18));
        Label labelPasswd = new Label("Contraseña: ");
        labelPasswd .setFont(new Font("Arial", 18));

        TextField userTxt = new TextField();
        userTxt.setPromptText("Digite su usuario");
        userTxt.setMaxWidth(400);
        userTxt.setMaxHeight(50);

        PasswordField userPasswd = new PasswordField();
        userPasswd.setPromptText("Digite su contraseña");
        userPasswd.setMaxWidth(400);
        userPasswd.setMaxHeight(50);

        Button btn1 = new Button("Iniciar sesión ");
        btn1.setMaxSize(100, 150);
       

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        GridPane.setConstraints(labelUser, 0, 0);
        GridPane.setConstraints(userTxt, 1, 0);
        GridPane.setConstraints(labelPasswd, 0, 1);
        GridPane.setConstraints(userPasswd, 1, 1);

        GridPane.setConstraints(btn1, 0, 2);
        GridPane.setColumnSpan(btn1, 2);

        GridPane.setMargin(labelUser, new Insets(0, 10, 0, 0));
        GridPane.setMargin(labelPasswd, new Insets(0, 10, 0, 0));
        GridPane.setMargin(userTxt, new Insets(20, 0, 20, 0));
        GridPane.setMargin(userPasswd, new Insets(20, 0, 20, 0));
        GridPane.setMargin(btn1, new Insets(20, 0, 20, 0));

       
        
        grid.getChildren().addAll(labelUser, labelPasswd, userTxt, userPasswd, btn1);
        grid.setAlignment(Pos.CENTER);

        // Nodo raíz

        VBox root = new VBox();
        root.getChildren().addAll(labelSaludo, imageView, grid, btn1);
        root.setAlignment(Pos.CENTER);

        //Escena
        Scene scene = new Scene(root, 400, 400);

        // Asignar al escena al Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("PRIMERA INTERFAZ CON JAVA FX.");
        primaryStage.show();

        // Mostrar el escenario

        
    }



    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
