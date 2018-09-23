package sample;

import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;

public class Row extends HBox{
    private Button submit;
    private TextField rolls;
    private TextField diceType;
    private TextField modifier;
    private Label result;
    private TextField name;
    private Die die;

    public Row(Die die){
        this.die = die;

        result = new Label("00");
        result.setPrefHeight(25);

        HBox submitBox  = new HBox();
        submit = new Button("Roll");
        submit.setOnAction(e -> roll());
        submitBox.getChildren().add(submit);
        submitBox.setPadding(new Insets(0,15,0,10));

        rolls = new TextField(this.die.getRolls() + "");
        rolls.setPrefWidth(30);

        Label d = new Label("d");
        d.setPrefHeight(25);

        diceType = new TextField(this.die.getType() + "");
        diceType.setPrefWidth(30);

        Label p = new Label("+");
        d.setPrefHeight(25);

        modifier = new TextField(this.die.getMod() + "");
        modifier.setPrefWidth(30);

        HBox nameBox  = new HBox();

        name = new TextField(this.die.getName() + "");
        name.setPromptText("Name this roll");
        name.setOnKeyPressed(e -> {
            if(e.getCode().equals(KeyCode.ENTER)) {
                die.setName(name.getText());
                if(name.getText().equals(""))
                    name.setStyle("");
                else
                    name.setStyle("-fx-border-color: #343434; -fx-border-radius: 12px;");
            }
        });

        nameBox.getChildren().add(name);
        nameBox.setPadding(new Insets(2,0,2,15));

        this.getChildren().addAll(result, submitBox, rolls, d, diceType, p, modifier, nameBox);
        this.setPadding(new Insets(10,7,10,7));
        this.setSpacing(5);
    }

    public Die getDie(){
        return die;
    }

    private void roll() {
        try {
            die.setRolls(Integer.parseInt(rolls.getText()));
            die.setType(Integer.parseInt(diceType.getText()));
            die.setMod(Integer.parseInt(modifier.getText()));
            result.setText(String.format("%02d", die.roll()));
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Uh oh. Looks like the die you attempted to roll contains an invalid input. Please re-enter its values as an integers only and try again.");
            alert.showAndWait().filter(r -> r == ButtonType.OK);
        }
    }
}
