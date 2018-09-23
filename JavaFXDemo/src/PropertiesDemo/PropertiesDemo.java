package PropertiesDemo;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertiesDemo extends Application {
    Stage window;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Application");

        //Input and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);

//        IntegerProperty x = new SimpleIntegerProperty(3);
//        IntegerProperty y = new SimpleIntegerProperty();
//
//        y.bind(x.multiply(10));
//        System.out.println("x: " + x.getValue());
//        System.out.println("y: " + y.getValue() + "\n");
//
//        x.setValue(9);
//        System.out.println("x: " + x.getValue());
//        System.out.println("y: " + y.getValue() + "\n");
//
//        Person matthew = new Person();
//        matthew.firstNameProperty().addListener((object, oldValue, newValue) -> {
//            System.out.println("Name changed to " + newValue);
//            System.out.println("firstNameProperty(): " + matthew.firstNameProperty());
//            System.out.println("getFirstName():"   + matthew.getFirstName());
//        });
//
//        Button button = new Button("Submit");
//        button.setOnAction(e -> matthew.setFirstName("Invalid"));

        VBox layout = new VBox(10, userInput, bottomText);
        layout.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());

        scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }
}