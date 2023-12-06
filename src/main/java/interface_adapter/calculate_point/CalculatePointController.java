package interface_adapter.calculate_point;

import entity.Computer;
import entity.Player;
import entity.Question;
import use_case.calculate_point.CalculatePointInputBoundary;
import use_case.calculate_point.CalculatePointInputData;
import use_case.calculate_point.CalculatePointOutputBoundary;
import use_case.select_answer.SelectAnswerInputBoundary;
import use_case.select_answer.SelectAnswerInputData;

import java.time.Duration;

public class CalculatePointController {
    CalculatePointInputBoundary calculatePointInteractor;

    public CalculatePointController(CalculatePointInputBoundary calculatePointInteractor) {
        this.calculatePointInteractor = calculatePointInteractor;
    }
  
    public void execute(boolean answerCorrectness1, boolean answerCorrectness2, long time1, long time2,
                        Player player, Computer computer) {
        CalculatePointInputData calculatePointInputData = new CalculatePointInputData(answerCorrectness1,
                answerCorrectness2, time1, time2);

        calculatePointInteractor.execute(calculatePointInputData);
    }
}
