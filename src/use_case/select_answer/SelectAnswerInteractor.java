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
        int userAnswer = selectAnswerInputData.getAnswer();
        // int questionAnswer = currentQuestion.answer; where to access the Question? Which has Question as parameter? Is it Game/

        if (userAnswer != questionAnswer) {
            userPresenter.prepareFailView(" Wrong answer ");
            // player.point += 0;
        } else {
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(userAnswer, timeleft, true);
            userPresenter.prepareSuccessView(selectAnswerOutputData);
            player.point = player.point + 100 + round(10 * timeleft); // 100 for correct answer, 10 * timeleft for time taken to answer but how to access entity
        }
    }
}
