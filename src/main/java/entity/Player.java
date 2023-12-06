package entity;

import entity.*;

import java.util.*;

public class Player {
    private int totalPoints;

    public Player(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    // getters and setters
    public int getTotalPoints() {return totalPoints;}

    public void setAdditionalPoints(int additionalPoints) {         // might need another entity to use this method?
        this.totalPoints += additionalPoints;
    }


}