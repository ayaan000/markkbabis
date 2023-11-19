package use_case.select_answer;

import entity.Game;
import entity.Question;

public class SelectAnswerInteractor implements SelectAnswerInputBoundary{
    // final SelectAnswerDataAccessInterface userDataAccessObject;
    final SelectAnswerOutputBoundary userPresenter;

    public SelectAnswerInteractor(SelectAnswerOutputBoundary selectAnswerOutputBoundary) {
        this.userPresenter = selectAnswerOutputBoundary;
    }

    @Override
    public void execute(SelectAnswerInputData selectAnswerInputData) {

        }
    }
