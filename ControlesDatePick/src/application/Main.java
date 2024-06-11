package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear los controles
        Label dateLabel = new Label("Selecciona una fecha:");
        DatePicker datePicker = new DatePicker();

        Label colorLabel = new Label("Selecciona un color:");
        ColorPicker colorPicker = new ColorPicker();

        Button button = new Button("Confirmar selección");
        Text resultText = new Text();

        // Crear un rectángulo para mostrar el color seleccionado
        Rectangle colorDisplay = new Rectangle(100, 100);
        colorDisplay.setStroke(Color.BLACK);  // Añadir borde negro

        // Configurar la acción del botón
        button.setOnAction(e -> {
            String selectedDate = datePicker.getValue().toString();
            Color selectedColor = colorPicker.getValue();
            resultText.setText("Fecha: " + selectedDate + ", Color: " + selectedColor.toString());
            colorDisplay.setFill(selectedColor);
            System.out.println("Fecha seleccionada: " + selectedDate);
            System.out.println("Color seleccionado: " + selectedColor.toString());
        });

        // Crear el layout y añadir los controles
        VBox vbox = new VBox(10, dateLabel, datePicker, colorLabel, colorPicker, button, resultText, colorDisplay);
        vbox.setId("main-layout");  // Añadir id para el layout

        // Crear la escena
        Scene scene = new Scene(vbox, 300, 350);

        // Añadir la hoja de estilos
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // Configurar y mostrar el escenario
        primaryStage.setScene(scene);
        primaryStage.setTitle("Selector de Fecha y Color");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}