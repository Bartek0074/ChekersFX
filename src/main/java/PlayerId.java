public class PlayerId {

    private int playerId;
    private int enemiesPlayerId;
    private int queenPlayerId;
    private int queenEnemiesPlayerId;

    public int getQueenPlayerId() { return queenPlayerId; }

    public void setQueenPlayerId(int queenPlayerId) { this.queenPlayerId = queenPlayerId; }

    public int getQueenEnemiesPlayerId() { return queenEnemiesPlayerId; }

    public void setQueenEnemiesPlayerId(int queenEnemiesPlayerId) { this.queenEnemiesPlayerId = queenEnemiesPlayerId; }

    public int getEnemiesPlayerId() {
        return enemiesPlayerId; }

    public void setEnemiesPlayerId(int enemiesPlayerId) { this.enemiesPlayerId = enemiesPlayerId; }

    public PlayerId(int playerId) {
        if (playerId == 1){
            queenPlayerId = 3;
            enemiesPlayerId = 2;
            queenEnemiesPlayerId = 4;
        }
        if (playerId == 2){
            queenPlayerId = 4;
            enemiesPlayerId = 1;
            queenEnemiesPlayerId = 3;
        }
        this.playerId = playerId;
    }

    public int getPlayerId() { return playerId; }

    public void setPlayerId(int playerId) {

        if (playerId == 1){
            queenPlayerId = 3;
            enemiesPlayerId = 2;
            queenEnemiesPlayerId = 4;
        }
        if (playerId == 2){
            queenPlayerId = 4;
            enemiesPlayerId = 1;
            queenEnemiesPlayerId = 3;
        }

        this.playerId = playerId;
    }


    static void switchPlayerId(PlayerId playerId){

        if (playerId.getPlayerId() == 1){
            playerId.setPlayerId(2);
        }
        else {
            playerId.setPlayerId(1);
        }
    }

}
