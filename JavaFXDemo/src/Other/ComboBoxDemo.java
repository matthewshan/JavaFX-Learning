package Other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input");
        button = new Button("Submit");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "One",
                "Two",
                "Three"
        );

        comboBox.setPromptText("Select a number");

        //comboBox.setEditable(true);

        comboBox.setOnAction(e -> System.out.println("User Selected: " + comboBox.getValue()) );
        button.setOnAction(e -> System.out.println("Submission is: " + comboBox.getValue()));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox, button); //Adds the JavaFX Elements

        //Set the layout as the scene
        scene = new Scene(layout, 300, 250);
        //Set the scene for the window
        window.setScene(scene);
        //Shows the window
        window.show();
    }

}


