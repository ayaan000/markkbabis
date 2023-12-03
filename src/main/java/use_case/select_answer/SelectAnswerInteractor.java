package use_case.select_answer;

import entity.Game;
import entity.Question;

public class SelectAnswerInteractor implements SelectAnswerInputBoundary{
    // final SelectAnswerDataAccessInterface userDataAccessObject;
    final SelectAnswerOutputBoundary userPresenter;
    private Game game;
    public SelectAnswerInteractor(SelectAnswerOutputBoundary selectAnswerOutputBoundary, Game game) {
        this.userPresenter = selectAnswerOutputBoundary;
        this.game = game;
    }

    @Override
    public void execute(SelectAnswerInputData selectAnswerInputData) {
        String question = game.getQuestion();
        String questionAnswer = .getCorrectAnswer();
        int userAnswer = selectAnswerInputData.getAnswer();
        if (userAnswer.equals(questionAnswer)) {
            userPresenter.prepareFailView(" Wrong answer ");
        } else {
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(question.getCorrectAnswer());
            userPresenter.prepareSuccessView(selectAnswerOutputData);
        }
    }
}
