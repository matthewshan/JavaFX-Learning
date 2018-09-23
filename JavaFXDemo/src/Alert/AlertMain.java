package Alert;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AlertMain extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Application");

        button = new Button("Click Me");
        //button.setOnAction(e -> AlertBox.display("Alert box title", "This is an alert box"));

        button.setOnAction(e -> {
                boolean result = ConfirmBox.display("Confirm box title", "Are you sure you want to perform this action?");
                System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
    }
}
