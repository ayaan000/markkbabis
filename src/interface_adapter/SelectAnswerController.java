package interface_adapter;

import entity.Question;
import use_case.select_answer.SelectAnswerInputBoundary;
import use_case.select_answer.SelectAnswerInputData;

public class SelectAnswerController {

    SelectAnswerInputBoundary selectAnswerInputBoundary;

    public void SelectAnswerController(SelectAnswerInputBoundary selectAnswerInputBoundary) {
        this.selectAnswerInputBoundary = selectAnswerInputBoundary;
    }

    public void execute(Question question, int answer) {
        SelectAnswerInputData selectAnswerInputData = new SelectAnswerInputData(answer);
        selectAnswerInputBoundary.execute(selectAnswerInputData);
    }
}
