package use_case;

import entity.Question;

public class SelectAnswerInputData {
    private Question question;
    private int answer;
    public SelectAnswerInputData(Question question, int answer) {
        this.answer = answer;
    }
    public Question getQuestion(Question question) {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    public int getAnswer(int answer) {
        return answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
