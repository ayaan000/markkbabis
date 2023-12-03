package use_case.calculate_point;

import entity.Computer;
import entity.Player;
import entity.Question;

import java.time.Duration;

public class CalculatePointInteractor{
    final CalculatePointOutputBoundary userPresenter;
    private Player player;
    private Computer computer;
    private Question question;

    public CalculatePointInteractor(CalculatePointOutputBoundary calculatePointOutputBoundary,
                                    Player player, Computer computer, Question question) {
        this.userPresenter = calculatePointOutputBoundary;
        this.player = player;
        this.computer = computer;
        this.question = question;
    }

    public void execute() {
        // where do you get these variables??
        int answer1 = Player.getAnswer();
        int answer2 = Computer.getAnswer();
        int correctAnswer = question.getIndexAnswer();
        Duration time1 = Player.getTime();
        Duration time2 = Computer.getTime();

        int points1 = 0;
        int points2 = 0;

        points1 = Integer (100 * ((time1.getSeconds()-15) / 15.00);

//        if (answer1 == correctAnswer) {
////            points1 = Long.valueOf(number).intValue();
//            points1 = Integer (100 * ((time1.getSeconds()-15) / 15.00);
//        }

        // where am I supposed to do the actual calculations??
        CalculatePointOutputData calculatePointOutputData = new CalculatePointOutputData(answer1, answer2, time1,
                time2);

        userPresenter.prepareSuccessView(calculatePointOutputData);
    }
}
