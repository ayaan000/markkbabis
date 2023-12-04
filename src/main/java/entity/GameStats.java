package entity;
import entity.Game;
import use_case.game_stats.GameStatsOutputData;

import java.time.Duration;
import java.util.List;


public class GameStats {
    private Game game;
    private List<Question> questions;
    private String difficulty;
    private int numQuestions;
    private int playerPoints;
    private int computerPoints;
    private int numCorrectAnswers1;
    private int numCorrectAnswers2;
    public GameStats(Game game, List<Question> questions, String difficulty, int numQuestions,
                     int playerPoints, int computerPoints, int numCorrectAnswers1, int numCorrectAnswers2) {
        this.game = game;
        this.questions = questions;
        this.difficulty = difficulty;
        this.numQuestions = numQuestions;
        this.playerPoints = playerPoints;
        this.computerPoints = computerPoints;
        this.numCorrectAnswers1 = numCorrectAnswers1;
        this.numCorrectAnswers2 = numCorrectAnswers2;
    }

//    GameStatsOutputData gameStatsOutputData = new GameStatsOutputData(difficulty, numQuestions,
//            playerPoints, computerPoints, numCorrectAnswers1, numCorrectAnswers2, timePlayed);

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public int getNumCorrectAnswers1() {
        return numCorrectAnswers1;
    }

    public int getNumCorrectAnswers2() {
        return numCorrectAnswers2;
    }
}