package use_case.SelectAnswer;

import entity.Question;

import java.time.Duration;
import java.util.ArrayList;

public class SelectAnswerOutputData {
    private int playerPoints;
    private int compPoints;
    private ArrayList<Question> questions;
    private String answer;
    private Duration timeLeft;
    private boolean correctness;

    public SelectAnswerOutputData(int playerPoints, int compPoints, ArrayList<Question> questions, String answer,
                            Duration timeLeft, boolean correctness) {
        this.playerPoints = playerPoints;
        this.compPoints = compPoints;
        this.questions = questions;
        this.answer = answer;
        this.timeLeft = timeLeft;
        this.correctness = correctness;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getCompPoints() {
        return compPoints;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getAnswer() {
        return answer;
    }

    public Duration getTimeLeft() {
        return timeLeft;
    }

    public boolean getCorrectness() {
        return correctness;
    }
}