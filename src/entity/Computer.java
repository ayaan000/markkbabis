package entity;

import java.time.Duration;

public class Computer {

    private final String difficultyRating;
    private final Duration timeDelay;
    private Integer totalPoints;

    Computer(String difficultyRating) {
        this.difficultyRating = difficultyRating;

        if (difficultyRating.equals("Easy")) {
           this.timeDelay = Duration.ofSeconds(20, 1);
        } else if (difficultyRating.equals("Medium")) {
            this.timeDelay = Duration.ofSeconds(10, 1);
        } else {
            this.timeDelay = Duration.ofSeconds(5, 1);
        }

        this.totalPoints = 0;
    }

    public String getDifficultyRating() {
        return difficultyRating;
    }

    public Duration getTimeDelay() {
        return timeDelay;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void updateCompPoints(Integer points) {
        totalPoints += points;
    }
}
