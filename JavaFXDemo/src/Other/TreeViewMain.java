package Other;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewMain extends Application{
    Stage window;
    Scene scene;
    Button button;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Demo");
        button = new Button("Submit");


        TreeItem<String> root, food, drinks;

        //root
        root = new TreeItem<>();
        root.setExpanded(true); //Expands the tree view for the user

        //food
        food = makeBranch("Food", root);
        makeBranch("Pizza", food);
        makeBranch("Steak", food);
        makeBranch("French Fries", food);

        //drinks
        drinks = makeBranch("Drinks", root);
        makeBranch("Soda", drinks);
        makeBranch("Tea", drinks);
        makeBranch("Water", drinks);

        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false); //Removes the display of the root, which is unnamed
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if(newValue != null)
                        System.out.println(newValue.getValue());
                });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().addAll(tree);

        //Set the layout as the scene
        scene = new Scene(layout, 300, 250);
        //Set the scene for the window
        window.setScene(scene);
        //Shows the window
        window.show();
    }

    public TreeItem<String> makeBranch(String name, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(name);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
