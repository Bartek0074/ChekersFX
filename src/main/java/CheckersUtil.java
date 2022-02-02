import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CheckersUtil {

    static void updateButtonImage(ArrayList<ArrayList<Field>> fields){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (fields.get(i).get(j).getPlayerId() == 0) {
                    ImageView noPawn = new ImageView(new Image("blank.png"));
                    fields.get(i).get(j).getButton().setGraphic(noPawn);
                }

                else if (fields.get(i).get(j).getPlayerId() == 1){
                    ImageView pawnWhite = new ImageView(new Image("pawn-white.png"));
                    pawnWhite.setFitHeight(60);
                    pawnWhite.setFitWidth(60);
                    fields.get(i).get(j).getButton().setGraphic(pawnWhite);
                }

                else if (fields.get(i).get(j).getPlayerId() == 2){
                    ImageView pawnBlack = new ImageView(new Image("pawn-black.png"));
                    pawnBlack.setFitHeight(60);
                    pawnBlack.setFitWidth(60);
                    fields.get(i).get(j).getButton().setGraphic(pawnBlack);
                }

                else if (fields.get(i).get(j).getPlayerId() == 3){
                    ImageView pawnWhiteQueen = new ImageView(new Image("pawn-white-queen.png"));
                    pawnWhiteQueen.setFitHeight(60);
                    pawnWhiteQueen.setFitWidth(60);
                    fields.get(i).get(j).getButton().setGraphic(pawnWhiteQueen);
                }

                else if (fields.get(i).get(j).getPlayerId() == 4){
                    ImageView pawnBlackQueen = new ImageView(new Image("pawn-black-queen.png"));
                    pawnBlackQueen.setFitHeight(60);
                    pawnBlackQueen.setFitWidth(60);
                    fields.get(i).get(j).getButton().setGraphic(pawnBlackQueen);
                }
            }
        }
    }

    static boolean captureCheck(PlayerId playerId, ArrayList<ArrayList<Field>> fields) {

        int isCapture = 0;
        int isTherePawn;

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (fields.get(i).get(j).getPlayerId() == playerId.getPlayerId()){
                    try{
                        if ((fields.get(i + 1).get(j + 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(i + 1).get(j + 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                            fields.get(i + 2).get(j + 2).getPlayerId() == 0)
                        {
                            isCapture++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}

                    try{
                        if ((fields.get(i + 1).get(j - 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(i + 1).get(j - 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                            fields.get(i + 2).get(j - 2).getPlayerId() == 0)
                        {
                            isCapture++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}

                    try{
                        if ((fields.get(i - 1).get(j + 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(i - 1).get(j + 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                            fields.get(i - 2).get(j + 2).getPlayerId() == 0)
                        {
                            isCapture++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}

                    try{
                        if ((fields.get(i - 1).get(j - 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(i - 1).get(j - 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                            fields.get(i - 2).get(j - 2).getPlayerId() == 0)
                        {
                            isCapture++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}
                }

                if (fields.get(i).get(j).getPlayerId() == playerId.getQueenPlayerId()){

                    for (int k = 1; k <= 7; k++) {
                        try {
                            if (fields.get(i + k).get(j + k).getPlayerId() == playerId.getEnemiesPlayerId() ||
                                fields.get(i + k).get(j + k).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                            {
                                isTherePawn = 0;
                                isTherePawn++;
                                try{
                                    if (isTherePawn == 1 &&
                                        fields.get(i + k + 1).get(j + k + 1).getPlayerId() == 0) {
                                        isCapture++;
                                    }
                                }
                                catch (IndexOutOfBoundsException e){}
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }

                    for (int k = 1; k <= 7; k++) {
                        try {
                            if (fields.get(i + k).get(j - k).getPlayerId() == playerId.getEnemiesPlayerId() ||
                                    fields.get(i + k).get(j - k).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                            {
                                isTherePawn = 0;
                                isTherePawn++;
                                try{
                                    if (isTherePawn == 1 &&
                                            fields.get(i + k + 1).get(j - k - 1).getPlayerId() == 0) {
                                        isCapture++;
                                    }
                                }
                                catch (IndexOutOfBoundsException e){}
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }

                    for (int k = 1; k <= 7; k++) {
                        try {
                            if (fields.get(i - k).get(j + k).getPlayerId() == playerId.getEnemiesPlayerId() ||
                                    fields.get(i - k).get(j + k).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                            {
                                isTherePawn = 0;
                                isTherePawn++;
                                try{
                                    if (isTherePawn == 1 &&
                                            fields.get(i - k - 1).get(j + k + 1).getPlayerId() == 0) {
                                        isCapture++;
                                    }
                                }
                                catch (IndexOutOfBoundsException e){}
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }

                    for (int k = 1; k <= 7; k++) {
                        try {
                            if (fields.get(i - k).get(j - k).getPlayerId() == playerId.getEnemiesPlayerId() ||
                                    fields.get(i - k).get(j - k).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                            {
                                isTherePawn = 0;
                                isTherePawn++;
                                try{
                                    if (isTherePawn == 1 &&
                                            fields.get(i - k - 1).get(j - k - 1).getPlayerId() == 0) {
                                        isCapture++;
                                    }
                                }
                                catch (IndexOutOfBoundsException e){}
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }
                }
            }
        }

        if (isCapture > 0){
            return true;
        }
        else {
            return false;
        }
    }

    static void capture(PlayerId playerId, ArrayList<ArrayList<Field>> fields, Field field, Coords from, Coords to, Location location){

        if (location.getLocation().equals("from") &&
            (field.getPlayerId() == playerId.getPlayerId() || field.getPlayerId() == playerId.getQueenPlayerId()))
        {
            from.setX(field.getX());
            from.setY(field.getY());
            location.setLocation("to");
        }

        else if (location.getLocation().equals("to") && field.getPlayerId() == 0 &&
        fields.get(from.getX()).get(from.getY()).getPlayerId() == playerId.getPlayerId())
        {

            to.setX(field.getX());
            to.setY(field.getY());

            int isCaptured = 0;

            try{
                if ((fields.get(from.getX() + 1).get(from.getY() + 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                fields.get(from.getX() + 1).get(from.getY() + 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                to.getX() == from.getX() + 2 && to.getY() == from.getY() + 2)
                {
                    fields.get(from.getX() + 1).get(from.getY() + 1).setPlayerId(0);
                    isCaptured++;
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if ((fields.get(from.getX() + 1).get(from.getY() - 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                    fields.get(from.getX() + 1).get(from.getY() -+ 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                    to.getX() == from.getX() + 2 && to.getY() == from.getY() - 2)
                {
                    fields.get(from.getX() + 1).get(from.getY() - 1).setPlayerId(0);
                    isCaptured++;
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if ((fields.get(from.getX() - 1).get(from.getY() + 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                    fields.get(from.getX() - 1).get(from.getY() + 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                    to.getX() == from.getX() - 2 && to.getY() == from.getY() + 2)
                {
                    fields.get(from.getX() - 1).get(from.getY() + 1).setPlayerId(0);
                    isCaptured++;
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if ((fields.get(from.getX() - 1).get(from.getY() - 1).getPlayerId() == playerId.getEnemiesPlayerId() ||
                    fields.get(from.getX() - 1).get(from.getY() - 1).getPlayerId() == playerId.getQueenEnemiesPlayerId()) &&
                    to.getX() == from.getX() - 2 && to.getY() == from.getY() - 2)
                {
                    fields.get(from.getX() - 1).get(from.getY() - 1).setPlayerId(0);
                    isCaptured++;
                }
            }
            catch (IndexOutOfBoundsException e){}

            if (isCaptured > 0){
                fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                if (anotherCaptureCheck(playerId, fields, field, from, to, location)){
                    from.setX(to.getX());
                    from.setY(to.getY());
                    capture(playerId, fields, field, from, to, location);
                }
                else{
                    if(playerId.getPlayerId() == 1 && field.getY() == 0){
                        fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getQueenPlayerId());
                    }
                    else if(playerId.getPlayerId() == 2 && field.getY() == 7){
                        fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getQueenPlayerId());
                    }
                    else {
                        fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                    }
                    location.setLocation("from");
                    PlayerId.switchPlayerId(playerId);
                }
            }
        }

        else if (location.getLocation().equals("to") && field.getPlayerId() == 0 &&
                fields.get(from.getX()).get(from.getY()).getPlayerId() == playerId.getQueenPlayerId()){

            to.setX(field.getX());
            to.setY(field.getY());

            int isCaptured = 0;

            if (to.getX() - from.getX() == to.getY() - from.getY() ||
                to.getX() - from.getX() == -(to.getY() - from.getY()))
            {
                int numberOfFields = to.getX() - from.getX();
                int isTherePawn = 0;
                int xEnemy = 0;
                int yEnemy = 0;

                if (to.getX() == from.getX() + Math.abs(numberOfFields) &&
                        to.getY() == from.getY() + Math.abs(numberOfFields)) {
                    for (int i = 1; i < Math.abs(numberOfFields); i++) {
                        if (fields.get(from.getX() + i).get(from.getY() + i).getPlayerId() != 0) {
                            isTherePawn++;
                            xEnemy = from.getX() + i;
                            yEnemy = from.getY() + i;
                        }
                    }
                }

                if (to.getX() == from.getX() + Math.abs(numberOfFields) &&
                        to.getY() == from.getY() - Math.abs(numberOfFields)) {
                    for (int i = 1; i < Math.abs(numberOfFields); i++) {
                        if (fields.get(from.getX() + i).get(from.getY() - i).getPlayerId() != 0) {
                            isTherePawn++;
                            xEnemy = from.getX() + i;
                            yEnemy = from.getY() - i;
                        }
                    }
                }

                if (to.getX() == from.getX() - Math.abs(numberOfFields) &&
                        to.getY() == from.getY() + Math.abs(numberOfFields)) {
                    for (int i = 1; i < Math.abs(numberOfFields); i++) {
                        if (fields.get(from.getX() - i).get(from.getY() + i).getPlayerId() != 0) {
                            isTherePawn++;
                            xEnemy = from.getX() - i;
                            yEnemy = from.getY() + i;
                        }
                    }
                }

                if (to.getX() == from.getX() - Math.abs(numberOfFields) &&
                        to.getY() == from.getY() - Math.abs(numberOfFields)) {
                    for (int i = 1; i < Math.abs(numberOfFields); i++) {
                        if (fields.get(from.getX() - i).get(from.getY() - i).getPlayerId() != 0) {
                            isTherePawn++;
                            xEnemy = from.getX() - i;
                            yEnemy = from.getY() - i;
                        }
                    }
                }

                if (isTherePawn == 1 &&
                    (fields.get(xEnemy).get(yEnemy).getPlayerId() == playerId.getEnemiesPlayerId() ||
                    fields.get(xEnemy).get(yEnemy).getPlayerId() == playerId.getQueenEnemiesPlayerId()))
                {
                    fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                    fields.get(xEnemy).get(yEnemy).setPlayerId(0);
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getQueenPlayerId());

                    if (anotherCaptureCheck(playerId, fields, field, from, to, location)){
                        from.setX(to.getX());
                        from.setY(to.getY());
                        capture(playerId, fields, field, from, to, location);
                    }
                    else{
                    location.setLocation("from");
                    PlayerId.switchPlayerId(playerId);
                    }
                }

                if (isCaptured > 0){
                    fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                    if (anotherCaptureCheck(playerId, fields, field, from, to, location)){
                        from.setX(to.getX());
                        from.setY(to.getY());
                        capture(playerId, fields, field, from, to, location);
                    }
                    else {
                        location.setLocation("from");
                        PlayerId.switchPlayerId(playerId);
                    }
                }
            }
        }

        else if (location.getLocation().equals("to") &&
                (field.getPlayerId() == playerId.getPlayerId() ||
                field.getPlayerId() == playerId.getQueenPlayerId()))
        {
            from.setX(field.getX());
            from.setY(field.getY());
        }
    }

    static boolean anotherCaptureCheck(PlayerId playerId, ArrayList<ArrayList<Field>> fields, Field field, Coords from, Coords to, Location location){

        int isCapture = 0;

        if (fields.get(to.getX()).get(to.getY()).getPlayerId() == playerId.getPlayerId()) {
            try {
                if (fields.get(to.getX() + 1).get(to.getY() + 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        fields.get(to.getX() + 2).get(to.getY() + 2).getPlayerId() == 0) {
                    isCapture++;
                }
            } catch (IndexOutOfBoundsException e) { }

            try {
                if (fields.get(to.getX() + 1).get(to.getY() - 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        fields.get(to.getX() + 2).get(to.getY() - 2).getPlayerId() == 0) {
                    isCapture++;
                }
            } catch (IndexOutOfBoundsException e) { }

            try {
                if (fields.get(to.getX() - 1).get(to.getY() + 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        fields.get(to.getX() - 2).get(to.getY() + 2).getPlayerId() == 0) {
                    isCapture++;
                }
            } catch (IndexOutOfBoundsException e) { }

            try {
                if (fields.get(to.getX() - 1).get(to.getY() - 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        fields.get(to.getX() - 2).get(to.getY() - 2).getPlayerId() == 0) {
                    isCapture++;
                }
            } catch (IndexOutOfBoundsException e) { }
        }

        if (fields.get(to.getX()).get(to.getY()).getPlayerId() == playerId.getQueenPlayerId()) {

            int isTherePawn;

            for (int i = 1; i <= 7; i++) {
                try {
                    if (fields.get(to.getX() + i).get(to.getY() + i).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(to.getX() + i).get(to.getY() + i).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                    {
                        isTherePawn = 0;
                        isTherePawn++;
                        try{
                            if (isTherePawn == 1 &&
                                    fields.get(to.getX() + i + 1).get(to.getY() + i + 1).getPlayerId() == 0) {
                                isCapture++;
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }
                }
                catch (IndexOutOfBoundsException e){}
            }

            for (int i = 1; i <= 7; i++) {
                try {
                    if (fields.get(to.getX() + i).get(to.getY() - i).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(to.getX() + i).get(to.getY() - i).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                    {
                        isTherePawn = 0;
                        isTherePawn++;
                        try{
                            if (isTherePawn == 1 &&
                                    fields.get(to.getX() + i + 1).get(to.getY() - i - 1).getPlayerId() == 0) {
                                isCapture++;
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }
                }
                catch (IndexOutOfBoundsException e){}
            }

            for (int i = 1; i <= 7; i++) {
                try {
                    if (fields.get(to.getX() - i).get(to.getY() + i).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(to.getX() - i).get(to.getY() + i).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                    {
                        isTherePawn = 0;
                        isTherePawn++;
                        try{
                            if (isTherePawn == 1 &&
                                    fields.get(to.getX() - i - 1).get(to.getY() + i + 1).getPlayerId() == 0) {
                                isCapture++;
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }
                }
                catch (IndexOutOfBoundsException e){}
            }

            for (int i = 1; i <= 7; i++) {
                try {
                    if (fields.get(to.getX() - i).get(to.getY() - i).getPlayerId() == playerId.getEnemiesPlayerId() ||
                            fields.get(to.getX() - i).get(to.getY() - i).getPlayerId() == playerId.getQueenEnemiesPlayerId())
                    {
                        isTherePawn = 0;
                        isTherePawn++;
                        try{
                            if (isTherePawn == 1 &&
                                    fields.get(to.getX() - i - 1).get(to.getY() - i - 1).getPlayerId() == 0) {
                                isCapture++;
                            }
                        }
                        catch (IndexOutOfBoundsException e){}
                    }
                }
                catch (IndexOutOfBoundsException e){}
            }
        }

        if (isCapture > 0){
            return true;
        }
        else {
            return false;
        }
    }

    static void anotherCapture(PlayerId playerId, ArrayList<ArrayList<Field>> fields, Field field, Coords from, Coords to, Location location){

        if (location.getLocation().equals("to") && field.getPlayerId() == 0)
        {
            from.setX(to.getX());
            from.setY(to.getY());

            to.setX(field.getX());
            to.setY(field.getY());

            try{
                if (fields.get(from.getX() + 1).get(from.getY() + 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        to.getX() == from.getX() + 2 && to.getY() == from.getY() + 2){
                    fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                    fields.get(from.getX() + 1).get(from.getY() + 1).setPlayerId(0);
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                    location.setLocation("from");
                    if (captureCheck(playerId, fields)){
                        capture(playerId, fields, field, from, to, location);}
                    else{
                        PlayerId.switchPlayerId(playerId);}
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if (fields.get(from.getX() + 1).get(from.getY() - 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        to.getX() == from.getX() + 2 && to.getY() == from.getY() - 2){
                    fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                    fields.get(from.getX() + 1).get(from.getY() - 1).setPlayerId(0);
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                    location.setLocation("from");
                    if (captureCheck(playerId, fields)){
                        capture(playerId, fields, field, from, to, location);}
                    else{
                        PlayerId.switchPlayerId(playerId);}
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if (fields.get(from.getX() - 1).get(from.getY() + 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        to.getX() == from.getX() - 2 && to.getY() == from.getY() + 2){
                    fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                    fields.get(from.getX() - 1).get(from.getY() + 1).setPlayerId(0);
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                    location.setLocation("from");
                    if (captureCheck(playerId, fields)){
                        capture(playerId, fields, field, from, to, location);}
                    else{
                        PlayerId.switchPlayerId(playerId);}
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if (fields.get(from.getX() - 1).get(from.getY() - 1).getPlayerId() == playerId.getEnemiesPlayerId() &&
                        to.getX() == from.getX() - 2 && to.getY() == from.getY() - 2){
                    fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                    fields.get(from.getX() - 1).get(from.getY() - 1).setPlayerId(0);
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                    location.setLocation("from");
                    if (captureCheck(playerId, fields)){
                        capture(playerId, fields, field, from, to, location);}
                    else{
                        PlayerId.switchPlayerId(playerId);}
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        else if (location.getLocation().equals("to") && field.getPlayerId() == playerId.getPlayerId())
        {
            from.setX(field.getX());
            from.setY(field.getY());
        }
    }

    static boolean moveCheck(PlayerId playerId, ArrayList<ArrayList<Field>> fields){

        int a = 0;
        if (playerId.getPlayerId() == 1){
            a = -1;
        }
        else if (playerId.getPlayerId() == 2){
            a = 1;
        }

        int isMove = 0;

        for (int i = 0; i < 8; i++){
            for (int j =0; j < 8; j++){
                if (fields.get(i).get(j).getPlayerId() == playerId.getPlayerId()){
                    try{
                        if(fields.get(i + 1).get(j + a).getPlayerId() == 0){
                            isMove++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}

                    try{
                        if(fields.get(i - 1).get(j + a).getPlayerId() == 0){
                            isMove++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}
                }

                if (fields.get(i).get(j).getPlayerId() == playerId.getQueenPlayerId()){
                    try{
                        if(fields.get(i + 1).get(j + a).getPlayerId() == 0){
                            isMove++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}

                    try{
                        if(fields.get(i + 1).get(j +- a).getPlayerId() == 0){
                            isMove++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}

                    try{
                        if(fields.get(i - 1).get(j + a).getPlayerId() == 0){
                            isMove++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}

                    try{
                        if(fields.get(i - 1).get(j - a).getPlayerId() == 0){
                            isMove++;
                        }
                    }
                    catch (IndexOutOfBoundsException e){}
                }
            }
        }

        if (isMove > 0){
            return true;
        }
        else {
            return false;
        }
    }

    static void move(PlayerId playerId, ArrayList<ArrayList<Field>> fields, Field field, Coords from, Coords to, Location location){

        int a = 0;
        if (playerId.getPlayerId() == 1){
            a = -1;
        }
        else if (playerId.getPlayerId() == 2){
            a = 1;
        }

        if (location.getLocation().equals("from") &&
            (field.getPlayerId() == playerId.getPlayerId() || field.getPlayerId() == playerId.getQueenPlayerId()))
        {
            from.setX(field.getX());
            from.setY(field.getY());
            location.setLocation("to");
        }

        else if (location.getLocation().equals("to") && field.getPlayerId() == 0)
        {
            to.setX(field.getX());
            to.setY(field.getY());

            int isMoved = 0;

            if (fields.get(from.getX()).get(from.getY()).getPlayerId() == playerId.getPlayerId()){
                if ((to.getX() == from.getX() - 1 || to.getX() == from.getX() + 1) &&
                    to.getY() == from.getY() + a)
                {
                isMoved++;
                }
            }

            if (fields.get(from.getX()).get(from.getY()).getPlayerId() == playerId.getQueenPlayerId()){
                if (to.getX() - from.getX() == to.getY() - from.getY() ||
                    to.getX() - from.getX() == -(to.getY() - from.getY())){

                    int numberOfFields = to.getX() - from.getX();
                    int isTherePawn = 0;

                    if (to.getX() == from.getX() + Math.abs(numberOfFields) &&
                        to.getY() == from.getY() + Math.abs(numberOfFields)){
                        for (int i = 1; i <= Math.abs(numberOfFields) ; i++){
                            if (fields.get(from.getX() + i).get(from.getY() + i).getPlayerId() != 0) {
                                isTherePawn++;
                            }
                        }
                    }

                    if (to.getX() == from.getX() + Math.abs(numberOfFields) &&
                            to.getY() == from.getY() - Math.abs(numberOfFields)){
                        for (int i = 1; i <= Math.abs(numberOfFields) ; i++){
                            if (fields.get(from.getX() + i).get(from.getY() - i).getPlayerId() != 0) {
                                isTherePawn++;
                            }
                        }
                    }

                    if (to.getX() == from.getX() - Math.abs(numberOfFields) &&
                            to.getY() == from.getY() + Math.abs(numberOfFields)){
                        for (int i = 1; i <= Math.abs(numberOfFields) ; i++){
                            if (fields.get(from.getX() - i).get(from.getY() + i).getPlayerId() != 0) {
                                isTherePawn++;
                            }
                        }
                    }

                    if (to.getX() == from.getX() - Math.abs(numberOfFields) &&
                            to.getY() == from.getY() - Math.abs(numberOfFields)){
                        for (int i = 1; i <= Math.abs(numberOfFields) ; i++){
                            if (fields.get(from.getX() - i).get(from.getY() - i).getPlayerId() != 0) {
                                isTherePawn++;
                            }
                        }
                    }

                    if (isTherePawn == 0){
                        isMoved++;
                    }
                }
            }

            if (isMoved > 0){
                if(playerId.getPlayerId() == 1 && field.getY() == 0){
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getQueenPlayerId());
                }
                else if(playerId.getPlayerId() == 2 && field.getY() == 7){
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getQueenPlayerId());
                }
                else if(fields.get(from.getX()).get(from.getY()).getPlayerId() == 3 ||
                        fields.get(from.getX()).get(from.getY()).getPlayerId() == 4){
                    fields.get(to.getX()).get(to.getY()).setPlayerId(fields.get(from.getX()).get(from.getY()).getPlayerId());
                }
                else {
                    fields.get(to.getX()).get(to.getY()).setPlayerId(playerId.getPlayerId());
                }
                fields.get(from.getX()).get(from.getY()).setPlayerId(0);
                location.setLocation("from");
                PlayerId.switchPlayerId(playerId);
            }
        }

        else if (location.getLocation().equals("to") &&
                (field.getPlayerId() == playerId.getPlayerId() || field.getPlayerId() == playerId.getQueenPlayerId()))
        {
            from.setX(field.getX());
            from.setY(field.getY());
        }
    }

    static boolean isGameWon(PlayerId playerId, ArrayList<ArrayList<Field>> fields){

        int numberOfPawns = 0;

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (fields.get(i).get(j).getPlayerId() == playerId.getPlayerId() ||
                        fields.get(i).get(j).getPlayerId() == playerId.getQueenPlayerId()){
                    numberOfPawns++;
                }
            }
        }
        if (numberOfPawns == 0 ||
            (!moveCheck(playerId, fields) &&
            !captureCheck(playerId, fields))){
            return true;
        }
        else {
            return false;
        }
    }

    static void postGameInfo(PlayerId playerId, ArrayList<ArrayList<Field>> fields, Stage stage, StackPane stackpane){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                fields.get(i).get(j).getButton().setDisable(true);
            }
        }
        Label postGameText = new Label("PLAY AGAIN?");
        Style.setStyle(postGameText);
        Label winnerText = new Label();
        Style.setStyle(winnerText);
        Button yes = new Button("YES");
        Style.setStyle(yes);
        Button no = new Button("NO");
        Style.setStyle(no);

        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public
            void handle(ActionEvent event) {
                stackpane.getChildren().clear();
                Board board = new Board(fields);
                stackpane.getChildren().add(board.getBoard());
                updateButtonImage(fields);
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 8; j++){
                        fields.get(i).get(j).getButton().setDisable(false);
                    }
                }
                playerId.setPlayerId(1);
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.hide();
            }
        });

        if (playerId.getEnemiesPlayerId() == 1){
            winnerText.setText("WHITES WIN!");
        }
        else if (playerId.getEnemiesPlayerId() == 2){
            winnerText.setText("BLACKS WIN!");
        }

        winnerText.setTranslateY(-75);
        yes.setTranslateX(-100);
        yes.setTranslateY(90);
        no.setTranslateX(100);
        no.setTranslateY(90);

        stackpane.getChildren().add(postGameText);
        stackpane.getChildren().add(winnerText);
        stackpane.getChildren().add(yes);
        stackpane.getChildren().add(no);
    }
}
