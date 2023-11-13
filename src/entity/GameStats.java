package entity;
import entity.Game;

import java.util.List;


public class GameStats {
    private Game game;
    private List<Question> questions;
    private int finalPoint1;
    private int finalPoint2;
    private int playerID;
    public GameStats(Game game, List<Question> questions, int finalPoint1, int finalPoint2, int playerID) {
        this.game = game;
        this.questions = questions;
        this.finalPoint1 = finalPoint1;
        this.finalPoint2 = finalPoint2;
        this.playerID = playerID;
    }
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

}