package use_case.select_answer;

import java.time.Duration;
import java.util.ArrayList;

public class SelectAnswerOutputData {
<<<<<<< HEAD

    private String correctAnswer;
    private Duration timeLeft;
    private boolean correctness;

    public SelectAnswerOutputData(String answer, Duration timeLeft, boolean correctness) {
        this.correctAnswer = answer;
=======
    private int playerPoints;
    private int compPoints;
    private ArrayList<String> questions;
    private String answer;
    private Duration timeLeft;
    private boolean correctness;

    public SelectAnswerOutputData(int playerPoints, int compPoints, ArrayList<String> questions, String answer,
                            Duration timeLeft, boolean correctness) {
        this.playerPoints = playerPoints;
        this.compPoints = compPoints;
        this.questions = questions;
        this.answer = answer;
>>>>>>> 0f8f05a (Completed use case for selecting answer other than interactor)
        this.timeLeft = timeLeft;
        this.correctness = correctness;
    }

<<<<<<< HEAD
=======
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
>>>>>>> 0f8f05a (Completed use case for selecting answer other than interactor)

    public Duration getTimeLeft() {
        return timeLeft;
    }

    public boolean getCorrectness() {
        return correctness;
    }
<<<<<<< HEAD

    public String getCorrectAnswer() {
        return correctAnswer;}
=======
>>>>>>> 0f8f05a (Completed use case for selecting answer other than interactor)
}
