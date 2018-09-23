package CSSDemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CSSDemo extends Application{
    Stage window;
    Scene scene;

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

        Label nameLabel = new Label("Username: ");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 0, 0);
       // nameLabel.setStyle("-fx-text-fill: #E8E8E8");

        TextField nameInput = new TextField("Matthew");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0, 1);

        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton, 1, 2);

        Button registerButton = new Button("Register");
        registerButton.getStyleClass().add("button-blue");
        GridPane.setConstraints(registerButton, 1, 3);

//        loginButton.setOnAction(e -> {
//            setUserAgentStylesheet(STYLESHEET_CASPIAN);
//        });

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, registerButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("/CSSDemo/main.css");
        window.setScene(scene);
        window.show();
    }
}