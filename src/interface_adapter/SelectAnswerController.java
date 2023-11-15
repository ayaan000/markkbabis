package interface_adapter;

import entity.Question;
import use_case.SelectAnswerInputBoundary;
import use_case.SelectAnswerInputData;

public class SelectAnswerController {
    final SelectAnswerInputBoundary userSelectAnswerInteractor;
    public SelectAnswerController(SelectAnswerInputBoundary userSignupUseCaseInteractor) {
        this.userSelectAnswerInteractor = userSignupUseCaseInteractor;
    }

    public void execute(Question question, int answer) {
        SelectAnswerInputData selectAnswerInputData = new SelectAnswerInputData(question, answer);
        userSelectAnswerInteractor.execute(selectAnswerInputData);
    }
}
