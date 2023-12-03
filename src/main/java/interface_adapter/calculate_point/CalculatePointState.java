package interface_adapter.calculate_point;

import java.time.Duration;

public class CalculatePointState {
    private int answer1 = 0;
    private int answer2 = 0;
    private Duration time1 = blank;
    private Duration time2 = blank;

    public CalculatePointState(CalculatePointState copy) {
        answer1 = copy.answer1;
        answer2 = copy.answer2;
        time1 = copy.time1;
        time2 = copy.time2;
    }

    public CalculatePointState() {

    }

    public int getAnswer1() {
        return answer2;
    }

    public int getAnswer2() {
        return answer2;
    }

    public Duration getTime1() {
        return time1;
    }

    public Duration getTime2() {
        return time2;
    }
}
