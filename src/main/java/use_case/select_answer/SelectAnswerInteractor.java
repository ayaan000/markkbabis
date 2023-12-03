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
        Question question = selectAnswerInputData.getQuestion();
        int questionAnswer = question.getCorrectAnswer();
        int userAnswer = selectAnswerInputData.getAnswer();
        boolean correctness = userAnswer == questionAnswer;
        if (!correctness) {
            userPresenter.prepareFailView(" Wrong answer ");
        } else {
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(question.getCorrectAnswer());
            userPresenter.prepareSuccessView(selectAnswerOutputData);
        }
    }
}
