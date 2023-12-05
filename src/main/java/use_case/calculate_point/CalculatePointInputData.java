package use_case.calculate_point;

import entity.Computer;
import entity.Player;

import java.time.Duration;

public class CalculatePointInputData {
    private boolean answerCorrectness1;
    private boolean answerCorrectness2;
    private long time1;
    private long time2;
    private Player player;
    private Computer computer;

    public CalculatePointInputData(boolean answerCorrectness1, boolean answerCorrectness2,  long time1,
                                   long time2, Player player, Computer computer) {
        this.answerCorrectness1 = answerCorrectness1;
        this.answerCorrectness2 = answerCorrectness2;
        this.time1 = time1;
        this.time2 = time2;
        this.player = player;
        this. computer = computer;
    }

    public boolean getAnswerCorrectness1() {
        return answerCorrectness1;
    }

    public boolean getAnswerCorrectness2() {
        return answerCorrectness2;
    }

    public long getTime1() {
        return time1;
    }

    public long getTime2() {
        return time2;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }
}
