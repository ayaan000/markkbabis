package use_case.game_stats;

import entity.Computer;
import entity.Game;

import java.time.Duration;

public class GameStatsInteractor implements GameStatsInputBoundary {
    private GameStatsOutputBoundary userPresenter;

    public GameStatsInteractor(GameStatsOutputBoundary gameStatsOutputBoundary) {
        this.userPresenter = gameStatsOutputBoundary;
    }

    public void execute() {

        // List of inputs to create gameStatsOutputData
        String category = Game.getCurrCategrory();
        String difficulty = Computer.getDIfficultyRating();
        int numQuestions = Game.getQuestionList();
        int playerPoints= Player.getTotalPoints();
        int computerPoints = Computer.getTotalPoints();
        int numCorrectAnswers1 = Player.getNumCorrectAns();
        int numCorrectAnswers2 = Computer.getNumCorrectAns();
        Duration timePlayed = Game.getTimePLayed();

        GameStatsOutputData gameStatsOutputData = new GameStatsOutputData(category, difficulty, numQuestions,
                playerPoints, computerPoints, numCorrectAnswers1, numCorrectAnswers2, timePlayed);

        userPresenter.prepareSuccessView(gameStatsOutputData);
    }
}
