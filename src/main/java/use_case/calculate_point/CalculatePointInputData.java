package use_case.calculate_point;

import entity.Computer;
import entity.Player;

import java.time.Duration;

public class CalculatePointInputData {
    private int answer1;
    private int answer2;
    private int correctAnswer;
    private Duration time1;
    private Duration time2;
    private Player player;
    private Computer computer;

    public CalculatePointInputData(int answer1, int answer2, int correctAnswer, Duration time1, Duration time2,
                                   Player player, Computer computer) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.correctAnswer = correctAnswer;
        this.time1 = time1;
        this.time2 = time2;
    }

    public int getAnswer1() {
        return answer1;
    }

    public int getAnswer2() {
        return answer2;
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public Duration getTime1() {
        return time1;
    }

    public Duration getTime2() {
        return time2;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }
}
