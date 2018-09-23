package Other;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuDemo extends Application {
    Stage window;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Application");

        //FileMenu
        Menu fileMenu = new Menu("_File");

        MenuItem fileNew = new MenuItem("New...");
        fileNew.setOnAction(e -> System.out.println("Creating new file..."));

        MenuItem fileSave = new MenuItem("Save...");
        fileSave.setOnAction(e -> System.out.println("Saving file..."));

        MenuItem fileLoad = new MenuItem("Load...");
        fileLoad.setOnAction(e -> System.out.println("Loading file..."));

        MenuItem fileOptions = new MenuItem("Options...");
        fileOptions.setOnAction(e -> System.out.println("Modifying options..."));

        MenuItem fileExit = new MenuItem("Exit...");
        fileExit.setOnAction(e -> System.out.println("Exiting..."));

        fileMenu.getItems().addAll(fileNew, fileSave, fileLoad, new SeparatorMenuItem(),
                fileOptions, new SeparatorMenuItem(), fileExit);


        //EditMenu
        Menu editMenu = new Menu("_Edit");

        MenuItem editCopy = new MenuItem("Copy");
        editCopy.setOnAction(e -> System.out.println("Copying..."));

        MenuItem editPaste = new MenuItem("Paste");
        editPaste.setOnAction(e -> System.out.println("Pasteing..."));
        editPaste.setDisable(true);

        MenuItem editCut = new MenuItem("Cut");
        editCut.setOnAction(e -> System.out.println("Cutting..."));

        editMenu.getItems().addAll(editCopy, editPaste, editCut);


        //HelpMenu
        Menu settingsMenu = new Menu("_Settings");
        CheckMenuItem setting1 = new CheckMenuItem("Setting 1");
        setting1.setOnAction(e -> {
            if(setting1.isSelected())
                System.out.println("Setting one is now on");
            else
                System.out.println("Setting one is now off");
        });
        setting1.setSelected(true); //Checks the option on setting
        settingsMenu.getItems().add(setting1);

        //Difficulty
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem normal = new RadioMenuItem("Normal");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        normal.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        normal.setSelected(true);

        difficultyMenu.getItems().addAll(easy,normal,hard);

        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, settingsMenu, difficultyMenu);

        //Layout
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);

        scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
