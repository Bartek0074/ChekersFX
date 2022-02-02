import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Board {


    GridPane board = new GridPane();

    public GridPane getBoard() { return board; }

    Board(ArrayList<ArrayList<Field>> fields) {

        for (int i = 0; i < 8; i = i + 2) {
            for (int j = 1; j < 8; j = j + 2) {
                fields.get(i).get(1).setPlayerId(2);
                fields.get(i).get(3).setPlayerId(0);
                fields.get(i).get(5).setPlayerId(1);
                fields.get(i).get(7).setPlayerId(1);
                board.add(fields.get(i).get(j).getButton(), i, j);
            }
        }


        for (int i = 1; i < 8; i = i + 2) {
            for (int j = 0; j < 8; j = j + 2) {
                fields.get(i).get(0).setPlayerId(2);
                fields.get(i).get(2).setPlayerId(2);
                fields.get(i).get(4).setPlayerId(0);
                fields.get(i).get(6).setPlayerId(1);
                board.add(fields.get(i).get(j).getButton(), i, j);
            }
        }

        for (int i = 1; i < 8; i = i + 2) {
            for (int j = 1; j < 8; j = j + 2) {
                Label fieldOutOfTheGame = new Label();
                fieldOutOfTheGame.setPrefHeight(75);
                fieldOutOfTheGame.setPrefWidth(75);
                fieldOutOfTheGame.setStyle("-fx-background-color: rgba(248, 242, 242, 1);");
                board.add(fieldOutOfTheGame, i, j);
            }
        }

        for (int i = 0; i < 8; i = i + 2) {
            for (int j = 0; j < 8; j = j + 2) {
                Label fieldOutOfTheGame = new Label();
                fieldOutOfTheGame.setPrefHeight(75);
                fieldOutOfTheGame.setPrefWidth(75);
                fieldOutOfTheGame.setStyle("-fx-background-color: rgba(248, 242, 242, 1);");
                board.add(fieldOutOfTheGame, i, j);
            }
        }
    }

}
