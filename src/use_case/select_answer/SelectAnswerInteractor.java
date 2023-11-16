package use_case.select_answer;

import entity.Game;
import entity.Question;

public class SelectAnswerInteractor implements SelectAnswerInputBoundary{
    // final SelectAnswerDataAccessInterface userDataAccessObject;
    final SelectAnswerOutputBoundary userPresenter;

    public SelectAnswerInteractor(SelectAnswerOutputBoundary signupOutputBoundary) {
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(SelectAnswerInputData selectAnswerInputData) {
        Question question = selectAnswerInputData.getQuestion();
        String questionAnswer = question.getCorrectAnswer();
        int userAnswer = selectAnswerInputData.getAnswer();

        if (userAnswer != questionAnswer) {
            userPresenter.prepareFailView(" Wrong answer ");
        } else {
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(question.getCorrectAnswer());
            userPresenter.prepareSuccessView(selectAnswerOutputData);
        }
    }
}
