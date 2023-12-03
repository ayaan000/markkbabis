package use_case.calculate_point;

import entity.Computer;
import entity.Player;
import entity.Question;

import java.time.Duration;

public class CalculatePointInteractor implements CalculatePointInputBoundary{
    final CalculatePointOutputBoundary userPresenter;
    private Player player;
    private Computer computer;

    public CalculatePointInteractor(CalculatePointOutputBoundary calculatePointOutputBoundary,
                                    Player player, Computer computer) {
        this.userPresenter = calculatePointOutputBoundary;
        this.player = player;
        this.computer = computer;
    }

    public void execute(CalculatePointInputData calculatePointInputData) {
        // where do you get these variables??
        boolean answerCorrectness1 = calculatePointInputData.getAnswerCorrectness1();
        boolean answerCorrectness2 = calculatePointInputData.getAnswerCorrectness2();
        Duration time1 = calculatePointInputData.getTime1();
        Duration time2 = calculatePointInputData.getTime2();

        int points1 = 0;
        int points2 = 0;

        // Calculate points here

        int  timeSeconds1 = (int) (time1.getSeconds() / 60);
        int  timeSeconds2 = (int) (time2.getSeconds() / 60);

        points1 = (timeSeconds1 - 15) / 15;
        points2 = (timeSeconds2 - 15) / 15;

        player.setTotalPoints(points1);
        computer.setTotalPoints2(points2);

        int totalPoints1 = player.getTotalPoints();
        int totalPoints2 = computer.getTotalPoints2();

//        if (answer1 == correctAnswer) {
////            points1 = Long.valueOf(number).intValue();
//            points1 = Integer (100 * ((time1.getSeconds()-15) / 15.00);
//        }

        // where am I supposed to do the actual calculations??
        CalculatePointOutputData calculatePointOutputData = new CalculatePointOutputData(totalPoints1, totalPoints2);

        userPresenter.prepareSuccessView(calculatePointOutputData);
    }
}
