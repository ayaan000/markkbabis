package use_case.select_answer;

import entity.Question;

import java.time.Duration;
import java.util.ArrayList;

public class SelectAnswerOutputData {

    private String correctAnswer;
    private Duration timeLeft;
    private boolean correctness;

    public SelectAnswerOutputData(String answer,
                            Duration timeLeft, boolean correctness) {
        this.correctAnswer = answer;
        this.timeLeft = timeLeft;
        this.correctness = correctness;
    }


    public Duration getTimeLeft() {
        return timeLeft;
    }

    public boolean getCorrectness() {
        return correctness;
    }

    public String getCorrectAnswer() {return correctAnswer;}
}
