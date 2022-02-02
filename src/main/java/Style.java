import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Style {

    static void setStyle(Button button){

        button.setPrefHeight(75);
        button.setPrefWidth(150);

        Font font = Font.font("Arial", FontWeight.BOLD, 40);
        button.setFont(font);

        button.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);" +
                "-fx-effect: dropshadow(gaussian, black, 1, 0, 0, 0);" +
                "-fx-background-insets: 1;");

        button.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8);" +
                        "-fx-effect: dropshadow(gaussian, black, 1, 0, 0, 0);" +
                        "-fx-background-insets: 1;");
            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);" +
                        "-fx-effect: dropshadow(gaussian, black, 1, 0, 0, 0);" +
                        "-fx-background-insets: 1;");
            }
        });
    }

    static void setStyle(Label label){

        Font font = Font.font("Arial",FontWeight.BOLD, 50);
        label.setFont(font);
        label.setTextFill(Color.BLACK);
        label.setStyle("-fx-background-color: rgba(0, 0, 0, 0.02);" +
                "-fx-effect: dropshadow(gaussian, white, 40, 0, 0, 0);" +
                "-fx-background-insets: 1;");
    }
}
