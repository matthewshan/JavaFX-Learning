package Other;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BasicMain extends Application /*-2-implements EventHandler<ActionEvent>*/{

    Button button;

    public static void main(String[] args) {
        launch(args); //Sets up as JavaFX App
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Other.BasicMain JavaFX Code is inside the method
        //A window is called a "Stage" in JavaFX
        //Inside the window, it is called the "Scene"

        primaryStage.setTitle("Title of the Stage(Window)"); //Sets the title

        button = new Button("This is a Button"); //Just a simple button

        //-2-button.setOnAction(this); //Sets the action to use the EventHandler

        /*-3-button.setOnAction(new EventHandler<ActionEvent>() { //Uses Anonymous Inner class for the Event Handler
            @Override
            public void handle(ActionEvent event) {
                System.out.println("I like milk"); //Notice that you don't have to check the source with this
            }
        });*/

        button.setOnAction(e -> {
            System.out.println("I like cows");
            System.out.println("How about you");
        }); //-3-LAMBDAAAAAAA


        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250); //Creates a new scene with layout
        primaryStage.setScene(scene); //Sets the scene (Content)
        primaryStage.show(); //Shows the stage (window)
    }

    /*-2-@Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button) {
            System.out.println("I like cheese");
        }
    }*/
}