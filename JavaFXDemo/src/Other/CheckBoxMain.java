package Other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxMain extends Application {


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

        //Checkboxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);

        //Button
        button = new Button("Order Now!");
        button.setOnAction(e -> handleOptions(box1, box2));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(box1, box2, button);

        //Set the layout as the scene
        scene = new Scene(layout, 300, 250);
        //Set the scene for the window
        window.setScene(scene);
        //Shows the window
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message = "Your ordered:\n";

        if(box1.isSelected())
            message += "Bacon\n";
        if(box2.isSelected())
            message += "Tuna\n";

        System.out.println(message);
    }
}

