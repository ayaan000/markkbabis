package interface_adapter.calculate_point;

import entity.Question;
import use_case.calculate_point.CalculatePointInputBoundary;
import use_case.calculate_point.CalculatePointInputData;
import use_case.select_answer.SelectAnswerInputBoundary;
import use_case.select_answer.SelectAnswerInputData;

import java.time.Duration;

public class CalculatePointController {
    CalculatePointInputBoundary calculatePointInteractor;

    public void calculatePointController(CalculatePointInputBoundary calculatePointInputBoundary) {
        this.calculatePointInteractor = calculatePointInputBoundary;
    }
    public void execute(int answer1, int answer2, int correctAnswer, Duration time1, Duration time2) {
        CalculatePointInputData calculatePointInputData = new CalculatePointInputData(answer1, answer2, correctAnswer,
                time1, time2);
        calculatePointInteractor.execute(calculatePointInputData);
    }
}
