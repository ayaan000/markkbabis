package entity;

import java.time.Duration;
import java.util.Random;

public class Computer {

    private final String difficultyRating;
    private final Duration timeDelay;
    private int totalPoints2;


    public Computer(String difficultyRating) {
        this.difficultyRating = difficultyRating;

        if (difficultyRating.equals("easy")) {
           this.timeDelay = Duration.ofSeconds(15, 1);
        } else if (difficultyRating.equals("medium")) {
            this.timeDelay = Duration.ofSeconds(10, 1);
        } else {
            this.timeDelay = Duration.ofSeconds(5, 1);
        }

        this.totalPoints2 = 0;

    }

    public String getDifficultyRating() {
        return difficultyRating;
    }

    public Duration getTimeDelay() {
        return timeDelay;
    }

    public int getTotalPoints2() {
        return totalPoints2;
    }


    public void setAdditionPoints(int additionalPoints) {
        this.totalPoints2 += additionalPoints;
    }


    public boolean getComResult() {
        Random r = new Random();
        int randomNum = r.nextInt(100);
        int result = randomNum + 1;
        if (difficultyRating.equals("easy")) {
            return result <= 33;
        } else if (difficultyRating.equals("medium")) {
            return result <= 66;
        } else {
            return result <= 99;
        }
    }
}
