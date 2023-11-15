package use_case.Answer;

import java.time.Duration;
import java.util.ArrayList;

public class AnswerOutputData {
    private int playerPoints;
    private int compPoints;
    private ArrayList<String> questions;
    private String answer;
    private Duration timeLeft;
    private boolean correctness;

    public AnswerOutputData(int playerPoints, int compPoints, ArrayList<String> questions, String answer,
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

    public ArrayList<String> getQuestions() {
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
