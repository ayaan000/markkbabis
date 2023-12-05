package entity;

public class GameStats {

    private int playerPoints;
    private int computerPoints;

    public GameStats(
            int playerPoints, int computerPoints) {
        this.playerPoints = playerPoints;
        this.computerPoints = computerPoints;
    }



    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }


}