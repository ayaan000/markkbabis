package interface_adapter.calculate_point;

import entity.Question;
import use_case.calculate_point.CalculatePointInputBoundary;
import use_case.calculate_point.CalculatePointInputData;
import use_case.select_answer.SelectAnswerInputBoundary;
import use_case.select_answer.SelectAnswerInputData;

public class CalculatePointController {
    CalculatePointInputBoundary calculatePointInteractor;

    public void calculatePointController(CalculatePointInputBoundary calculatePointInputBoundary) {
        this.calculatePointInteractor = calculatePointInputBoundary;
    }
    public void execute(int answer) {
        CalculatePointInputData calculatePointInputData = new CalculatePointInputData(answer);
        calculatePointInteractor.execute(calculatePointInputData);
    }
}
