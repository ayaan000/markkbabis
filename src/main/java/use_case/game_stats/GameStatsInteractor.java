package use_case.game_stats;

import entity.Computer;
import entity.Game;

import java.time.Duration;

public class GameStatsInteractor implements GameStatsInputBoundary {
    private GameStatsOutputBoundary userPresenter;

    public GameStatsInteractor(GameStatsOutputBoundary gameStatsOutputBoundary) {
        this.userPresenter = gameStatsOutputBoundary;
    }

    public void execute(GameStatsInputData gameStatsInputData) {


        int playerPoints= gameStatsInputData.getPlayer().getTotalPoints();
        int computerPoints = gameStatsInputData.getComputer().getTotalPoints2();


        GameStatsOutputData gameStatsOutputData = new GameStatsOutputData(playerPoints, computerPoints);

        userPresenter.prepareSuccessView(gameStatsOutputData);
    }
}
