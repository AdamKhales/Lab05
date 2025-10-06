/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab05;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ComboBox<String> beverage = new ComboBox<>();
        beverage.getItems().addAll("Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice");
        ComboBox<String> appetizer = new ComboBox<>();
        appetizer.getItems().addAll("Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa");
        ComboBox<String> mainCourse = new ComboBox<>();
        mainCourse.getItems().addAll("Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips");
        ComboBox<String> dessert = new ComboBox<>();
        dessert.getItems().addAll("Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp");
        
        Slider slider = new Slider(0,20,0);
        
    }
}
