package use_case.select_answer;

import java.time.Duration;
import java.util.ArrayList;

public class SelectAnswerOutputData {
    private int playerAnswer;
    private int correctAnswer;
    // private ArrayList<String> questions;
    // private int answer;
    // private Duration timeLeft;
    private boolean correctness;

    public SelectAnswerOutputData(int playerAnswer, int correctAnswer, boolean correctness) {
        this.playerAnswer = playerAnswer;
        this.correctAnswer = correctAnswer;
//        this.questions = questions;
//        this.answer = answer;
//        this.timeLeft = timeLeft;
        this.correctness = correctness;
    }

    public int getPlayerAnswer() {
        return playerAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean getCorrectness() {
        return correctness;
    }

//    public ArrayList<String> getQuestions() {
//        return questions;
//    }

    //    public int getAnswer() {
//        return answer;
//    }
//
//    public Duration getTimeLeft() {
//        return timeLeft;
//    }
    public void setPlayerAnswer(int playerAnswer) {
        this.playerAnswer = playerAnswer;
    }
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }

}



