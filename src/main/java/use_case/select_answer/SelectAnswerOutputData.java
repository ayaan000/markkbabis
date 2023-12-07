package use_case.select_answer;

import java.time.Duration;
import java.util.ArrayList;

public class SelectAnswerOutputData {
    private boolean correctness;

    public SelectAnswerOutputData(boolean correctness) {
        this.correctness = correctness;
    }
    public boolean getCorrectness() {
        return correctness;
    }
    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }

}



