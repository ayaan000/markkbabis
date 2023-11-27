package use_case.calculate_point;

public class CalculatePointInputData {
    private boolean correctness;
    public CalculatePointInputData(boolean correctness) {
        this.correctness = correctness;
    }
    public boolean getCorrectness() {
        return correctness;
    }
}
