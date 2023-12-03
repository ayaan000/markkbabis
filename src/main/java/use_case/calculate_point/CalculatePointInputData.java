package use_case.calculate_point;

import entity.Computer;
import entity.Player;

import java.time.Duration;

public class CalculatePointInputData {
    private Player player;
    private Computer computer;
    private boolean playerCorrectness;
    private boolean computerCorrectness;
    private Duration playerTimeLeft;
    private Duration computerTimeLeft;
    public CalculatePointInputData(boolean playerCorrectness, boolean computerCorrectness, Duration playerTimeLeft, Duration computerTimeLeft,
                                   Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
        this.playerCorrectness = playerCorrectness;
        this.computerCorrectness = computerCorrectness;
        this.playerTimeLeft = playerTimeLeft;
        this.computerTimeLeft = computerTimeLeft;
    }
    public int getPlayerPoint() {
        return player.getTotalPoints();
    }

    public void setPlayerPoint(int playerPoint) {
        player.setTotalPoints(playerPoint);
    }

    public int getComputerPoint() {
        return computer.getTotalPoints2();
    }

    public void setComputerPoint(int computerPoint) {
        computer. = computerPoint;
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
