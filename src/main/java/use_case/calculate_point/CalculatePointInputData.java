package use_case.calculate_point;

import java.time.Duration;

public class CalculatePointInputData {
    private boolean correctness;
    private Duration timeLeft;
    public CalculatePointInputData(boolean correctness, Duration timeLeft) {
        this.correctness = correctness;
        this.timeLeft = timeLeft;
    }
    public boolean getCorrectness() {
        return correctness;
    }
    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }
    public Duration getTimeLeft() {
        return timeLeft;
    }
    public void setTimeLeft(Duration timeLeft) {
        this.timeLeft = timeLeft;
    }
}
