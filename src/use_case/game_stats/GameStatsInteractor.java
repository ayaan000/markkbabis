package use_case.game_stats;

import java.time.Duration;

public class GameStatsInteractor implements GameStatsInputBoundary {
    private GameStatsOutputBoundary userPresenter;

    public GameStatsInteractor(GameStatsOutputBoundary gameStatsOutputBoundary) {
        this.userPresenter = gameStatsOutputBoundary;
    }

    public void execute() {

        // List of inputs to create gameStatsOutputData
        String category = ;
        String difficulty = ;
        int numQuestions = ;
        int points1 = ;
        int points2 = ;
        int numCorrectAnswers = ;
        int numCorrectAnswers = ;
        Duration timePlayed = ;

        GameStatsOutputData gameStatsOutputData = new GameStatsOutputData();
        userPresenter.prepareSuccessView(gameStatsOutputData);
    }
}
