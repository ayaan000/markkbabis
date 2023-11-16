package use_case.select_answer;

import entity.Question;

public class SelectAnswerInputData {
<<<<<<< HEAD

    private int answer;
    public SelectAnswerInputData(int answer) {
        this.answer = answer;
    }
    public int getAnswer() {
        return answer;
    }
=======
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
>>>>>>> 0f8f05a (Completed use case for selecting answer other than interactor)
}
