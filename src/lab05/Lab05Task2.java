/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab05;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
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
public class Lab05Task2 extends Application{
    Double subTotalAmount = 0.0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String[] itemNames = {"Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice", "Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa","Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips", "Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp"};
        double[] itemPrices = {2.50, 2.00, 1.75, 2.95, 1.5, 2.5, 4.50, 3.75, 5.25, 3.00, 6.95, 15.00, 13.50, 13.95, 11.90, 18.99, 11.75, 12.25, 5.95, 4.50, 4.75, 3.25, 5.98};
        Map<String, Double> priceMap = new HashMap<>();
        ComboBox<String> beverage = new ComboBox<>();
        beverage.getItems().addAll("Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice");
        ComboBox<String> appetizer = new ComboBox<>();
        appetizer.getItems().addAll("Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa");
        ComboBox<String> mainCourse = new ComboBox<>();
        mainCourse.getItems().addAll("Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips");
        ComboBox<String> dessert = new ComboBox<>();
        dessert.getItems().addAll("Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp");
        
        beverage.setPromptText("Beverages");
        appetizer.setPromptText("Appetizers");
        mainCourse.setPromptText("Main Course");
        dessert.setPromptText("Desserts");
        for(int i = 0; i < itemNames.length; i++) {
            priceMap.put(itemNames[i], itemPrices[i]);
        }
        
        HBox row1 = new HBox(25, beverage, appetizer, mainCourse, dessert);
        row1.setAlignment(Pos.CENTER);
        Slider slider = new Slider(0,20,0);        
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(5);
        
        Button clearBill = new Button("Clear bill");
        Label subTotal = new Label();
        Label tax = new Label();
        Label tip = new Label();
        Label total = new Label();
        
        VBox row2 = new VBox(10,clearBill, subTotal, tax, tip, total);
        
        
        VBox vb = new VBox(10,row1,slider,row2);
        
        beverage.setOnAction(e -> {
            String item = beverage.getSelectionModel().getSelectedItem();
            if (item != null) {
            subTotalAmount += priceMap.get(item);
            }
            subTotal.setText(String.format("Subtotal: %.2f$",subTotalAmount));
            tax.setText(String.format("Tax: %.2f$",subTotalAmount * 0.15));
            total.setText(String.format("Total: %.2f$", subTotalAmount * 1.15));
        });
        
        appetizer.setOnAction(e -> {
            String item = appetizer.getSelectionModel().getSelectedItem();
            if (item != null) {
            subTotalAmount += priceMap.get(item);
            }
            subTotal.setText(String.format("Subtotal: %.2f$",subTotalAmount));
            tax.setText(String.format("Tax: %.2f$",subTotalAmount * 0.15));
            total.setText(String.format("Total: %.2f$", subTotalAmount * 1.15));
        });
        
        mainCourse.setOnAction(e -> {
            String item = mainCourse.getSelectionModel().getSelectedItem();
            if (item != null) {
            subTotalAmount += priceMap.get(item);
            }
            subTotal.setText(String.format("Subtotal: %.2f$",subTotalAmount));
            tax.setText(String.format("Tax: %.2f$",subTotalAmount * 0.15));
            total.setText(String.format("Total: %.2f$", subTotalAmount * 1.15));
        });
        
        dessert.setOnAction(e -> {
            String item = dessert.getSelectionModel().getSelectedItem();
            if (item != null) {
                subTotalAmount += priceMap.get(item);
            }
            subTotal.setText(String.format("Subtotal: %.2f$",subTotalAmount));
            tax.setText(String.format("Tax: %.2f$",subTotalAmount * 0.15));
            total.setText(String.format("Total: %.2f$", subTotalAmount * 1.15));
        });
        
        slider.valueProperty().addListener((observeable, oldvalue, newvalue) -> {
            double tipAmount  = slider.getValue()/100 * this.subTotalAmount;
            tip.setText(String.format("Tip: %.2f$", tipAmount));
            total.setText(String.format("Total: %.2f$", subTotalAmount * 1.15 + tipAmount));
        });
        
        clearBill.setOnAction(e -> {
            subTotalAmount = 0.0;
            subTotal.setText("");
            tax.setText("");
            tip.setText("");
            total.setText("");
            slider.setValue(0);
        });
        
        Scene scene = new Scene(vb);
        stage.setScene(scene);
        stage.show();
    }
    
   
}
