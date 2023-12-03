package interface_adapter.calculate_point;

import interface_adapter.select_answer.SelectAnswerState;

public class CalculatePointState {
    private int playerPoint;
    public CalculatePointState(CalculatePointState copy) {
        playerPoint = copy.playerPoint;
    }
    // Because of the previous copy constructor, the default constructor must be explicit.
    public CalculatePointState() {
    }
    public int getPlayerPoint() {
            return playerPoint;
    }
    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }
    public String toString() {
        return "CalculatePointState{" +
                "playerPoint='" + playerPoint + '\'' +
                '}';
    }
}