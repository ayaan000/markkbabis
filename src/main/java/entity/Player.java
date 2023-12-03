package entity;

import entity.*;

import java.util.*;

public class Player {
    private int totalPoints;
    private List<Byte> avatar;
    private List<GameStats> games;
    private  Game currGame;

    // POTENTIAL ADDITIONAL ATTRIBUTES: currAnswerChoice

    // constructor
    Player(int totalPoints, List<Byte> avatar, List<GameStats> games, Game currGame) {
        this.totalPoints = totalPoints;
        this.avatar = avatar;
        this.games = games;
        this.currGame = currGame;
    }

    // getters and setters
    public int getTotalPoints() {return totalPoints;}
    public void setTotalPoints(int additionalPoints) {         // might need another entity to use this method?
        this.totalPoints += additionalPoints;
    }
    public List<Byte> getAvatar() {return avatar;}
    public void setAvatar(String avatarName) {
        // IDEA FOR IMPLEMENTATION
        // have preselected map of avatars that correlates strings to "images" (is Byte what accomplishes this?)
        // select a name (string) and then that sets the avatar attribute to store the "image"
    }
    public List<GameStats> getGames() {return games;}

    // setGames(): I don't think we need this, we will be accumulating
    // should we have an updateGames() method?

    public Game getCurrGame() {return currGame;}
    public void setCurrGame(Game game) {
        this.currGame = game;
    }

    // other methods
    public void chooseAnswer() {
        // IDEA FOR IMPLEMENTATION
        // will need some sort of interaction between the view/viewmodel and this method
        // QUESTION: how do we select an answer? Is it via keys?
        // taking the actor input and connect it to a certain answer
        // QUESTION: is this in player or somewhere else?
    }
}