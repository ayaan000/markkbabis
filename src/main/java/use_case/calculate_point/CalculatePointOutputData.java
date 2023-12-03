package use_case.calculate_point;

import java.time.Duration;

public class CalculatePointOutputData {
    private int points1;
    private int points2;

    public CalculatePointOutputData(int points1, int points2) {
        this.points1 = points1;
        this.points2 = points2;
    }

    public int getPoints1() {
        return points1;
    }

    public int getPoints2() {
        return points2;
    }
}
