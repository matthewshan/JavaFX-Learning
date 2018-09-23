package Table;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableDemo extends Application{
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Demo");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Pirice column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); //String must be the same name as the variable

        //Name column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(100);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);


        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);

        //Layout
        VBox layout = new VBox();
        layout.getChildren().addAll(table, hBox);

        //Sets up the scene and stage (window)
        Scene scene = new Scene(layout);
        window.resizableProperty().setValue(Boolean.FALSE);
        window.setScene(scene);
        window.show();
    }


    private void addButtonClicked() {
        Product temp = new Product();
        temp.setName(nameInput.getText());
        temp.setPrice(Double.parseDouble(priceInput.getText()));
        temp.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(temp);
    }

    private void deleteButtonClicked() {
        ObservableList<Product> productSelected, productList;
        productList = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(productList::remove);
    }


    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Mouse", 29.00, 380));
        products.add(new Product("Keyboard", 79.00, 160));
        products.add(new Product("PC", 1059.00, 45));
        products.add(new Product("Headphones", 39.00, 457));
        return products;
    }
}
