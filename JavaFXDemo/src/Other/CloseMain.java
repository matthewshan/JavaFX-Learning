package Other;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Alert.ConfirmBox;

public class CloseMain extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Application");

        window.setOnCloseRequest(e -> {
            e.consume(); //Tells java that the program will take care of the event
            closeProgram();
        }); //This is the important stuff

        button = new Button("Close Program");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Title", "Are you sure you want to quit?");
        if(answer) {
            System.out.println("Saving File");
            //Fake save
            System.out.println("Saved");
            window.close();
        }
    }

}
