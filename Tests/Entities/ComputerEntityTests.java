package Entities;

import entity.Computer;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.time.Duration;

public class ComputerEntityTests {
    @Test
    public void initialiseComputerEasy() {
        // Initialise easy
        Computer computer1 = new Computer("easy");
        assert (computer1.getDifficultyRating().equals("easy") &&
                computer1.getTimeDelay().equals(Duration.ofSeconds(15, 1)) &&
                computer1.getTotalPoints2() == 0);
    }

    @Test
    public void initialiseComputerMedium() {
        // Initialise medium
        Computer computer1 = new Computer("medium");
        assert (computer1.getDifficultyRating().equals("medium") &&
                computer1.getTimeDelay().equals(Duration.ofSeconds(10, 1)) &&
                computer1.getTotalPoints2() == 0);
    }
    @Test
    public void initialiseComputerHard() {
        // Initialise hard
        Computer computer1 = new Computer("hard");
        assert (computer1.getDifficultyRating().equals("hard") &&
                computer1.getTimeDelay().equals(Duration.ofSeconds(5, 1)) &&
                computer1.getTotalPoints2() == 0);
    }

//    @Test
//    public void firstSetTotalPoints21() {
//        // When 0
//        Computer computer1 = new Computer("Easy");
//        computer1.setTotalPoints2(0);
//        assert (computer1.getTotalPoints2() == 0);
//    }
//
//    @Test
//    public void secondSetTotalPoints22() {
//        // When 10 then 0
//        Computer computer1 = new Computer("Easy");
//        computer1.setTotalPoints2(10);
//        computer1.setTotalPoints2(0);
//        assert (computer1.getTotalPoints2() == 0);
//    }
//
//    @Test
//    public void setTotalPoints23() {
//        Computer computer1 = new Computer("Easy");
//        computer1.setTotalPoints2(10);
//        assert (computer1.getTotalPoints2() == 10);
//    }

    @Test
    public void setAdditionPoints0() {
        // Zero
        Computer computer1 = new Computer("easy");
        computer1.setAdditionPoints(0);
        assert (computer1.getTotalPoints2() == 0);
    }

    @Test
    public void setAdditionPoints1() {
        // Positive number
        Computer computer1 = new Computer("easy");
        computer1.setAdditionPoints(10);
        assert (computer1.getTotalPoints2() == 10);
    }

    @Test
    public void setAdditionPoints2() {
        // Negative number
        Computer computer1 = new Computer("easy");
        computer1.setAdditionPoints(-10);
        assert (computer1.getTotalPoints2() == -10);
    }

    @Test
    public void setAdditionPoints3() {
        // Positive and then negative
        Computer computer1 = new Computer("easy");
        computer1.setAdditionPoints(20);
        computer1.setAdditionPoints(-10);
        assert (computer1.getTotalPoints2() == 10);
    }

    @Test
    public void setAdditionPoints4() {
        // Negative and positive
        Computer computer1 = new Computer("easy");
        computer1.setAdditionPoints(-10);
        computer1.setAdditionPoints(30);
        assert (computer1.getTotalPoints2() == 20);
    }

    @Test
    public void setAdditionPoints5() {
        // Positive and positive
        Computer computer1 = new Computer("Easy");
        computer1.setAdditionPoints(10);
        computer1.setAdditionPoints(50);
        assert (computer1.getTotalPoints2() == 60);
    }

    @Test
    public void setAdditionPoints6() {
        // Negative and negative
        Computer computer1 = new Computer("Easy");
        computer1.setAdditionPoints(-10);
        computer1.setAdditionPoints(-30);
        assert (computer1.getTotalPoints2() == -40);
    }

//    @Test
//    public void addNumCorrectAns1() {
//        // Zero
//        Computer computer1 = new Computer("Easy");
//        computer1.addNumCorrectAns(0);
//        assert (computer1.getNumCorrectAns() == 0);
//    }
//
//    @Test
//    public void addNumCorrectAns2() {
//        // Positive
//        Computer computer1 = new Computer("Easy");
//        computer1.addNumCorrectAns(1);
//        assert (computer1.getNumCorrectAns() == 1);
//    }
//
//    @Test
//    public void addNumCorrectAns3() {
//        // Negative
//        Computer computer1 = new Computer("Easy");
//        computer1.addNumCorrectAns(-1);
//        assert (computer1.getNumCorrectAns() == -1);
//    }
//
//    @Test
//    public void addNumCorrectAns4() {
//        // Positive and Positive
//        Computer computer1 = new Computer("Easy");
//        computer1.addNumCorrectAns(1);
//        computer1.addNumCorrectAns(1);
//        assert (computer1.getNumCorrectAns() == 2);
//    }
//
//    @Test
//    public void addNumCorrectAns5() {
//        // Negative and Negative
//        Computer computer1 = new Computer("Easy");
//        computer1.addNumCorrectAns(-1);
//        computer1.addNumCorrectAns(-1);
//        assert (computer1.getNumCorrectAns() == -2);
//    }
//
//    @Test
//    public void addNumCorrectAns6() {
//        // Positive and Negative
//        Computer computer1 = new Computer("Easy");
//        computer1.addNumCorrectAns(1);
//        computer1.addNumCorrectAns(-1);
//        assert (computer1.getNumCorrectAns() == 0);
//    }
//
//    @Test
//    public void addNumCorrectAns7() {
//        // Negative and Positive
//        Computer computer1 = new Computer("Easy");
//        computer1.addNumCorrectAns(-1);
//        computer1.addNumCorrectAns(1);
//        assert (computer1.getNumCorrectAns() == 0);
//    }
//
//    @Test
//    public void setNumCorrectAns0() {
//        // Zero
//        Computer computer1 = new Computer("Easy");
//        computer1.setAdditionPoints(0);
//        assert (computer1.getNumCorrectAns() == 0);
//    }
//
//    @Test
//    public void setNumCorrectAns1() {
//        // Positive number
//        Computer computer1 = new Computer("Easy");
//        computer1.setNumCorrectAns(1);
//        assert (computer1.getNumCorrectAns() == 1);
//    }
//
//    @Test
//    public void setNumCorrectAns2() {
//        // Negative number
//        Computer computer1 = new Computer("Easy");
//        computer1.setNumCorrectAns(-1);
//        assert (computer1.getNumCorrectAns() == -1);
//    }
//
//    @Test
//    public void setNumCorrectAns3() {
//        // Positive and then negative
//        Computer computer1 = new Computer("Easy");
//        computer1.setNumCorrectAns(2);
//        computer1.setNumCorrectAns(-1);
//        assert (computer1.getNumCorrectAns() == -1);
//    }
//
//    @Test
//    public void setNumCorrectAns4() {
//        // Negative and positive
//        Computer computer1 = new Computer("Easy");
//        computer1.setNumCorrectAns(-1);
//        computer1.setNumCorrectAns(1);
//        assert (computer1.getNumCorrectAns() == 1);
//    }
//
//    @Test
//    public void setNumCorrectAns5() {
//        // Positive and positive
//        Computer computer1 = new Computer("Easy");
//        computer1.setNumCorrectAns(1);
//        computer1.setNumCorrectAns(1);
//        assert (computer1.getNumCorrectAns() == 1);
//    }
//
//    @Test
//    public void setNumCorrectAns6() {
//        // Negative and negative
//        Computer computer1 = new Computer("Easy");
//        computer1.setNumCorrectAns(-1);
//        computer1.setNumCorrectAns(-2);
//        assert (computer1.getNumCorrectAns() == -2);
    }

//    @Test
//    public void getComResult() {
//        Computer computer1 = new Computer("Easy");
//        assert (computer1.getComResult() || !computer1.getComResult());
//    }
//}
