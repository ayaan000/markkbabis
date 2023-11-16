package use_case;

import entity.Question;

import java.time.LocalDateTime;

public class SelectAnswerInteractor implements SelectAnswerInputBoundary{
    // final SelectAnswerDataAccessInterface userDataAccessObject;
    final SelectAnswerOutputBoundary userPresenter;

    public SelectAnswerInteractor(SelectAnswerOutputBoundary selectAnswerOutputBoundary) {
        this.userPresenter = selectAnswerOutputBoundary;
    }

    @Override
    public void execute(SelectAnswerInputData selectAnswerInputData) {
        Question question = selectAnswerInputData.getQuestion();
        int questionAnswer = question.getIndexAnswer();
        int userAnswer = selectAnswerInputData.getAnswer();
        if (userAnswer != questionAnswer) {
            userPresenter.prepareFailView(" Wrong answer ");
        } else {
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(question.getCorrectAnswer());
            userPresenter.prepareSuccessView(selectAnswerOutputData);
        }
    }
}