package use_case.calculate_point;

public class CalculatePointOutputData {
    private boolean correctness;
    private int totalPoint;
    public CalculatePointOutputData(boolean correctness, int totalPoint) {
        this.correctness = correctness;
        this.totalPoint = totalPoint;
    }
    public boolean getCorrectness() {
        return correctness;
    }
    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }
    public int getTotalPoint() {
        return this.totalPoint;
    }
    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }
}
