/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab05;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2493077
 */
public class Lab05 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        Label quantity = new Label("Select Quantity:");
        Label bagStyle = new Label("Select Bag Style:");
        ListView<String> bagList = new ListView<>();
        bagList.setPrefWidth(250);
        bagList.setPrefHeight(200);
        bagList.getItems().addAll(
                "Full Decorative",
                "Beaded",
                "Pirate Design",
                "Fringed",
                "Leather",
                "Plain");
        
        ComboBox<Integer> cb = new ComboBox<>();
        cb.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        cb.setValue(1);
        Label message = new Label();
        
        RadioButton small = new RadioButton("Small");
        RadioButton medium = new RadioButton("Medium");
        RadioButton large = new RadioButton("Large");
        
        
        ToggleGroup toggleGroup = new ToggleGroup();
        small.setToggleGroup(toggleGroup);
        medium.setToggleGroup(toggleGroup);
        large.setToggleGroup(toggleGroup);
        small.setSelected(true);
        
        Button order = new Button("Order");
        order.setPrefWidth(100);
        order.setOnAction(e -> {
            int value = cb.getValue();
            String bag = bagList.getSelectionModel().getSelectedItem();
            String size = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
            if(bag != null) {
            message.setText(String.format("You ordered %d %s %s bag(s)", value,size,bag));
            message.setStyle("");
            } else {
                message.setStyle("-fx-text-fill: red;");
                message.setText("Please select a bag option");
            }
           
        });
        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            message.setText("");
            small.setSelected(true);
            cb.setValue(1);
            bagList.getSelectionModel().select(0);
        });
        clear.setPrefWidth(100);
        
        gp.setPadding(new Insets(10,10,10,10));
        gp.setHgap(10);
        gp.setHgap(10);
        gp.add(bagStyle, 0, 0);
        gp.add(bagList, 1, 0);
        gp.add(quantity, 2, 0);
        gp.add(cb, 3, 0);
        gp.add(order, 2, 1);
        gp.add(clear, 3, 1);
        VBox radioBox = new VBox(10,small,medium,large);
        radioBox.setAlignment(Pos.CENTER_LEFT);
        gp.add(radioBox, 4, 0);
        gp.add(message, 2, 2, 2,1);
        
        stage.setTitle("Bag Order Form");
        Scene scene = new Scene(gp, 800,300);
        stage.setScene(scene);
        stage.show();
   }
    
}
