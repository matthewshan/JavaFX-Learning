package Other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxDemo extends Application {


    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input");

        ChoiceBox<String> choiceBox = new ChoiceBox<String>();

        //getItems returns the list that is in choice box.
        choiceBox.getItems().addAll("Apples", "Bananas", "Coconuts", "Pears", "Pineapples");
        choiceBox.setValue("Apples"); //Sets the default dropdown selection

        //Listener for choiceBox selection
        choiceBox.setOnAction(e -> System.out.println(choiceBox.getValue()));
        //choiceBox.getSelectionModel().selectedItemProperty().addListener( (v /*ListItem*/, oldValue, newValue) -> System.out.println(oldValue + "->" +newValue));

//        //Form submission
//        button = new Button("Click me");
//
//        button.setOnAction(e -> getChoice(choiceBox));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox/*, button*/); //Adds the JavaFX Elements

        //Set the layout as the scene
        scene = new Scene(layout, 300, 250);
        //Set the scene for the window
        window.setScene(scene);
        //Shows the window
        window.show();
    }

//    private void getChoice(ChoiceBox<String> choiceBox) {
//        String value = choiceBox.getValue();
//
//        System.out.println(value);
//    }
}