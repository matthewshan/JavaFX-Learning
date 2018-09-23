package Other;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ScenesMain extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args); //Sets up as JavaFX App
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //Scene 1
        Label label1 = new Label("The first scene!");
        Button button1 = new Button("To scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(20); //children are laid out in vertical column
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200,200);

        //Scene 2
        Button button2 = new Button("To scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("Title");
        window.show();


    }
}