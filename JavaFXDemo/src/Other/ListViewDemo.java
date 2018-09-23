package Other;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;

public class ListViewDemo extends Application{

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Demo");
        button = new Button("Submit");

        listView = new ListView<>();
        listView.getItems().addAll("Captain America", "Doctor Strange", "Deadpool", "Iron Man");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //Allows the user to select multiple list items

        button.setOnAction(e -> buttonClicked());

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView, button); //Adds the JavaFX Elements

        //Set the layout as the scene
        scene = new Scene(layout, 300, 250);
        //Set the scene for the window
        window.setScene(scene);
        //Shows the window
        window.show();
    }

    private void buttonClicked() {
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for(String m :movies) {
            message += m + "\n";
        }

        System.out.println(message);
    }
}
