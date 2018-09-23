package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridMain extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("GridPane Tutorial");

        GridPane grid = new GridPane(); //Creates a new grid pane
        grid.setPadding(new Insets(10, 10, 10, 10)); //Sets padding for the window
        grid.setVgap(8); //Vertical Padding for cells
        grid.setVgap(10); //Vertical Padding for cells

        //Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);

        //Log-In button
        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
