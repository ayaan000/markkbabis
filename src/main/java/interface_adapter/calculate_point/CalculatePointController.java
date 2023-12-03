package interface_adapter.calculate_point;

import entity.Question;
import use_case.calculate_point.CalculatePointInputBoundary;
import use_case.calculate_point.CalculatePointInputData;
import use_case.select_answer.SelectAnswerInputBoundary;
import use_case.select_answer.SelectAnswerInputData;

import java.time.Duration;

public class CalculatePointController {
    CalculatePointInputBoundary calculatePointInteractor;

    public CalculatePointController(CalculatePointInputBoundary calculatePointInputBoundary) {
        this.calculatePointInteractor = calculatePointInputBoundary;
    }
    public void execute(int playerPoint, int computerPoint, boolean correctness, Duration timeleft) {
        CalculatePointInputData calculatePointInputData = new CalculatePointInputData(playerPoint, computerPoint, correctness, timeleft);
        calculatePointInteractor.execute(calculatePointInputData);
    }
}
