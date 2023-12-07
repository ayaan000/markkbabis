package use_case.select_answer;

import entity.Question;

public class SelectAnswerInputData {
    // private Question question;
    private String answer;
    public SelectAnswerInputData(String answer) {
        this.answer = answer;
    }
//    public Question getQuestion() {
//        return question;
//    }
//    public void setQuestion(Question question) {
//        this.question = question;
//    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
