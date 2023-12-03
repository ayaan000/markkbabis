package use_case.calculate_point;

import java.time.Duration;

public class CalculatePointInteractor implements CalculatePointInputBoundary{
    @Override
    public void execute(CalculatePointInputData calculatePointInputData) {
        boolean correctness = calculatePointInputData.getCorrectness();
        Duration timeLeft = calculatePointInputData.getTimeLeft();
        if (correctness) {
            // player.point = player.point + 100 + round(10 * timeLeft);
        }
        else {
            // player.point += 0;
        }
    }
}
