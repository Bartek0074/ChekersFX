import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CheckersFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ArrayList<ArrayList<Field>> fields = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            fields.add(new ArrayList<>());
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                fields.get(i).add(new Field());
                fields.get(i).get(j).setX(i);
                fields.get(i).get(j).setY(j);
            }
        }

        Board board = new Board(fields);
        CheckersUtil.updateButtonImage(fields);
        StackPane stackPane = new StackPane();
        PlayerId playerId = new PlayerId(1);

        Coords from = new Coords();
        Coords to = new Coords();
        Location location = new Location();
        location.setLocation("from");


        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                int finalI = i;
                int finalJ = j;
                fields.get(i).get(j).getButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (CheckersUtil.captureCheck(playerId, fields))
                        {
                            CheckersUtil.capture(playerId,
                                fields,
                                fields.get(finalI).get(finalJ),
                                from, to, location);
                        }
                        else if (CheckersUtil.moveCheck(playerId, fields))
                        {
                            CheckersUtil.move(playerId,
                                fields,
                                fields.get(finalI).get(finalJ),
                                from, to, location);
                        }

                        CheckersUtil.updateButtonImage(fields);
                        if (CheckersUtil.isGameWon(playerId, fields)){
                            CheckersUtil.postGameInfo(playerId, fields, primaryStage, stackPane);
                        }
                    }
                });
            }
        }

        stackPane.getChildren().add(board.getBoard());

        Scene scene = new Scene(stackPane);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setHeight(639);
        primaryStage.setWidth(623);

    }
}