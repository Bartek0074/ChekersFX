import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Field {

    int playerId;

    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int y;

    public int getPlayerId() { return playerId; }

    public void setPlayerId(int playerId) { this.playerId = playerId; }

    private Button button = new Button();

    public Button getButton() { return button; }

    public void setButton(Button button) { this.button = button; }


    Field(){
        button = new Button();
        button.setPrefHeight(75);
        button.setPrefWidth(75);
        button.setStyle("-fx-background-color: rgba(107, 142, 135, 0.7);" +
                "-fx-effect: dropshadow(gaussian, black, 10, 0, 0, 0);" +
                "-fx-background-insets: 1;");

        button.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setStyle("-fx-background-color: rgba(107, 142, 135, 0.85);" +
                        "-fx-effect: dropshadow(gaussian, black, 10, 0, 0, 0);" +
                        "-fx-background-insets: 1;");
            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setStyle("-fx-background-color: rgba(107, 142, 135, 0.7);" +
                        "-fx-effect: dropshadow(gaussian, black, 10, 0, 0, 0);" +
                        "-fx-background-insets: 1;");
            }
        });

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setStyle("-fx-background-color: rgba(107, 142, 135, 1);" +
                        "-fx-effect: dropshadow(gaussian, black, 10, 0, 0, 0);" +
                        "-fx-background-insets: 1;");
            }
        });

    }
}
