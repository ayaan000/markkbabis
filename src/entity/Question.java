package entity;

import java.util.List;

public class Question {
    private String question;
    private String correctAnswer;
    private List<String> inCorrectAnswer;

    public Question(String question, String correctAnswer, List<String> inCorrectAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.inCorrectAnswer = inCorrectAnswer;
    }

    public String getAnswer() {
        return correctAnswer;
    }
    public String getQuestion() {
        return question;
    }
}
