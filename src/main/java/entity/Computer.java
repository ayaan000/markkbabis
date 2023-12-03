package entity;

import java.time.Duration;
import java.util.Random;

public class Computer {

    private final String difficultyRating;
    private final Duration timeDelay;
    private int totalPoints2;
    private int numCorrectAns;

    Computer(String difficultyRating) {
        this.difficultyRating = difficultyRating;

        if (difficultyRating.equals("Easy")) {
           this.timeDelay = Duration.ofSeconds(15, 1);
        } else if (difficultyRating.equals("Medium")) {
            this.timeDelay = Duration.ofSeconds(10, 1);
        } else {
            this.timeDelay = Duration.ofSeconds(5, 1);
        }

        this.totalPoints2 = 0;
        this.numCorrectAns = 0;

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

    public void setNumCorrectAns(int numCorrectAns) {
        this.numCorrectAns = numCorrectAns;
    }

    public int getNumCorrectAns() {
        return numCorrectAns;
    }

    public void setTotalPoints2(int additionalPoints) {
        this.totalPoints2 += additionalPoints;
    }

//    public Integer getPoints() {
//        return Game.getCompPoints;
//    }

//    public void updateCompPoints(Integer points) {
//        totalPoints += points;
//    }

    public boolean getComResult() {
        Random r = new Random();
        int randomNum = r.nextInt(100);
        int result = randomNum + 1;
        if (difficultyRating.equals("Easy")) {
            return result <= 33;
        } else if (difficultyRating.equals("Medium")) {
            return result <= 66;
        } else {
            return result <= 99;
        }
    }
}
