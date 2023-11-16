package use_case.select_answer;

import entity.Question;

public class SelectAnswerInputData {

    private int answer;
    public SelectAnswerInputData(int answer) {
        this.answer = answer;
    }
    public int getAnswer() {
        return answer;
    }
}
