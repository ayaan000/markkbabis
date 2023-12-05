package use_case.select_answer;

import entity.Computer;
import entity.Game;
import entity.Question;
import entity.Player;
import interface_adapter.calculate_point.CalculatePointController;
import use_case.calculate_point.CalculatePointInputBoundary;

import java.time.Duration;

public class SelectAnswerInteractor implements SelectAnswerInputBoundary{
    // final SelectAnswerDataAccessInterface userDataAccessObject;
    final SelectAnswerOutputBoundary selectAnswerPresenter;
    private Game game;
    private Player player;
    private Computer computer;
    private CalculatePointController calculatePointController;
    public SelectAnswerInteractor(SelectAnswerOutputBoundary selectAnswerOutputBoundary, Game game, Player player,
                                  Computer computer ) {
        this.selectAnswerPresenter = selectAnswerOutputBoundary;
        this.game = game;
        this.player = player;
        this.computer = computer;
    }

    @Override
    public void execute(SelectAnswerInputData selectAnswerInputData) {
        int userAnswer = selectAnswerInputData.getAnswer();
        Question question = game.getCurrQuestion();
        int questionAnswer = question.getIndexAnswer();
        boolean computerCorrectness = computer.getComResult();
        Duration computerTimeLeft = computer.getTimeDelay();
        if (userAnswer == questionAnswer) {             // correct
            calculatePointController.execute(true, computerCorrectness, 5, 5,
                    player, computer);
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(userAnswer, questionAnswer, true);
            selectAnswerPresenter.prepareSuccessView(selectAnswerOutputData);
        } else {                                        // false
            calculatePointController.execute(false, computerCorrectness, 5, 5,
                    player, computer);
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(userAnswer, questionAnswer, false);
            selectAnswerPresenter.prepareSuccessView(selectAnswerOutputData);
        }
    }
}
