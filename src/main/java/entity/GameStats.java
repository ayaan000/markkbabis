package entity;
import entity.Game;
import use_case.game_stats.GameStatsOutputData;

import java.time.Duration;
import java.util.List;


public class GameStats {

    private int playerPoints;
    private int computerPoints;

    public GameStats(int playerPoints, int computerPoints) {

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