package use_case.calculate_point;

import java.time.Duration;

public class CalculatePointInputData {
    private int answer1;
    private int answer2;
    private Duration time1;
    private Duration time2;

    public CalculatePointInputData(int answer1, int answer2, Duration time1, Duration time2) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.time1 = time1;
        this.time2 = time2;
    }

    public int getAnswer1() {
        return answer1;
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
