package interface_adapter;

import entity.Question;
import use_case.SelectAnswerInputBoundary;
import use_case.SelectAnswerInputData;

public class SelectAnswerController {

    SelectAnswerInputBoundary selectAnswerInputBoundary;

    public SelectAnswerController(){

    final SelectAnswerInputBoundary userSelectAnswerInteractor;
    public SelectAnswerController(SelectAnswerInputBoundary selectAnswerInputBoundary) {
        this.selectAnswerInputBoundary = selectAnswerInputBoundary;
    }

    public void execute(Question question, int answer) {
        SelectAnswerInputData selectAnswerInputData = new SelectAnswerInputData(question, answer);
        userSelectAnswerInteractor.execute(selectAnswerInputData);
    }
}
