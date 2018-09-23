package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    Stage window;
    Scene scene;
    private Dice dice;
    private VBox content;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("DnD die roller");

        Menu fileMenu = new Menu("_File");

        MenuItem saveFile = new MenuItem("Quick Save");
        saveFile.setOnAction(e -> { //TODO Put the current values into the die
            try{
                dice.save();
            } catch(IOException x) {
                x.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "The was an error while saving...");
                alert.showAndWait().filter(r -> r == ButtonType.OK);
            }
        });

        MenuItem loadFile = new MenuItem("Quick Load");
        loadFile.setOnAction(e -> load());


        fileMenu.getItems().addAll(saveFile, loadFile);

        MenuBar menus = new MenuBar();
        menus.getMenus().addAll(fileMenu);

        dice = new Dice();
        for (int i = 0; i < 5; i++)
            dice.add(new Die());

        BorderPane layout = new BorderPane();

        content = new VBox();
        content.setPadding(new Insets(10,10,10,10));
        content.getChildren().add(new Separator());

        for(int i = 0; i < dice.size(); i++) {
            Row r = new Row(dice.get(i));
            content.getChildren().addAll(r, new Separator());
        }
        content.setAlignment(Pos.CENTER );

        layout.setTop(menus);
        layout.setCenter(content);

        scene = new Scene(layout);
        scene.getStylesheets().add("/sample/css/main.css");
        //window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    public void load() {
        try{
            dice.load();
        } catch(Exception x) {
            x.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "The was an error while saving...");
            alert.showAndWait().filter(r -> r == ButtonType.OK);
        }

        content.getChildren().clear();
        content.getChildren().add(new Separator());

        for(int i = 0; i < dice.size(); i++) {
            System.out.println(dice.get(i).getName());
            Row r = new Row(dice.get(i));
            content.getChildren().addAll(r, new Separator());
        }
    }
}

