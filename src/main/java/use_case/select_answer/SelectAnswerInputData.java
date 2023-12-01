package use_case.select_answer;

import entity.Question;

public class SelectAnswerInputData {
    private Question question;
    private int answer;
    public SelectAnswerInputData(Question question, int answer) {
        this.answer = answer;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    public int getAnswer() {
        return answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
