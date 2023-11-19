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
        int userAnswer = selectAnswerInputData.getAnswer();
        // int questionAnswer = currentQuestion.answer; where to access the Question? Which has Question as parameter? Is it Game/

        if (userAnswer != questionAnswer) {
            userPresenter.prepareFailView(" Wrong answer ");
            // player.point += 0;
        } else {
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(userAnswer, timeleft, true);
            userPresenter.prepareSuccessView(selectAnswerOutputData);

        }
    }
}
