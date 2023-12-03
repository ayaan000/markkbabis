package interface_adapter.calculate_point;

import java.time.Duration;

public class CalculatePointState {
    private int points1 = 0;
    private int points2 = 0;

    public CalculatePointState(CalculatePointState copy) {
        points1 = copy.points1;
        points2 = copy.points2;
    }

    public CalculatePointState() {

    }

    public int getPoints1() {
        return points1;
    }

    public int getPoints2() {
        return points2;
    }
}
