package use_case.calculate_point;

import entity.Computer;

import java.time.Duration;

public class CalculatePointInteractor{
    final CalculatePointOutputBoundary userPresenter;

    public CalculatePointInteractor(CalculatePointOutputBoundary calculatePointOutputBoundary) {
        this.userPresenter = calculatePointOutputBoundary;
    }

    public void execute() {
        // where do you get these variables??
        int answer1 = Player.getAnswer();
        int answer2 = Computer.getAnswer();
        Duration time1 = Player.getTime();
        Duration time2 = Computer.getTime();

        int points =

        // where am I supposed to do the actual calculations??
        CalculatePointOutputData calculatePointOutputData = new CalculatePointOutputData(answer1, answer2, time1,
                time2);

        userPresenter.prepareSuccessView(calculatePointOutputData);
    }
}
