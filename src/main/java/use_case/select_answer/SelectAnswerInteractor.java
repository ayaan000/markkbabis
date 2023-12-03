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
    final SelectAnswerOutputBoundary userPresenter;
    private Game game;
    private Player player;
    private Computer computer;
    private CalculatePointController calculatePointController;
    public SelectAnswerInteractor(SelectAnswerOutputBoundary selectAnswerOutputBoundary, Game game, Player player,
                                  Computer computer ) {
        this.userPresenter = selectAnswerOutputBoundary;
        this.game = game;
        this.player = player;
        this.computer = computer;
    }

    @Override
    public void execute(SelectAnswerInputData selectAnswerInputData) {
        Question question = game.getCurrQuestion();
        int questionAnswer = question.getIndexAnswer();
        int userAnswer = selectAnswerInputData.getAnswer();
        int playerPoint = player.getTotalPoints();
        int computerPoint = computer.getTotalPoints2();
        boolean correctnessComputer = computer.getComResult();
        Duration computerTimeDelay = computer.getTimeDelay();

        if (userAnswer == questionAnswer) {             // correct
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(playerPoint, computerPoint, true);
            calculatePointController.execute(playerPoint, computerPoint, true, Duration.ofSeconds(15));
            userPresenter.prepareSuccessView(selectAnswerOutputData);
        } else {                                        // false
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(playerPoint, computerPoint, false);
            calculatePointController.execute(playerPoint, computerPoint, true, Duration.ofSeconds(15));
            userPresenter.prepareSuccessView(selectAnswerOutputData);
        }
    }
}
