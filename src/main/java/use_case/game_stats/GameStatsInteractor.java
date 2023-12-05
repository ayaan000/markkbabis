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

        // List of inputs to create gameStatsOutputData
//        String difficulty = gameStatsInputData.getComputer().getDifficultyRating();
//        int numQuestions = gameStatsInputData.getGame().getNumQuestions();
        int playerPoints= gameStatsInputData.getPlayer().getTotalPoints();
        int computerPoints = gameStatsInputData.getComputer().getTotalPoints2();
//        int numCorrectAnswers1 = gameStatsInputData.getPlayer().getNumCorrectAns();
//        int numCorrectAnswers2 = gameStatsInputData.getComputer().getNumCorrectAns();

        GameStatsOutputData gameStatsOutputData = new GameStatsOutputData(playerPoints, computerPoints);

        userPresenter.prepareSuccessView(gameStatsOutputData);
    }
}
