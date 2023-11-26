import entity.*;

import java.util.*;

public class Player {
    private int totalPoints1;
    private List<Byte> avatar;
    private List<GameStats> games;
    private Game currGame;
    private int numCorrectAns;

    // POTENTIAL ADDITIONAL ATTRIBUTES: currAnswerChoice

    // constructor
    Player(int totalPoints, List<Byte> avatar, List<GameStats> games, Game currGame) {
        this.totalPoints1 = totalPoints;
        this.avatar = avatar;
        this.games = games;
        this.currGame = currGame;
        this.numCorrectGames = 0;
    }

    // getters and setters
    public int getTotalPoints1() {return totalPoints1;}
    public void setTotalPoints(int newTotalPoints) {         // might need another entity to use this method?
        totalPoints1 = newTotalPoints;
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

    public voic set

    public void setNumCorrectAns(int numCorrectAns) {
        this.numCorrectAns = numCorrectAns;
    }

    public int getNumCorrectAns() {
        return numCorrectAns;
    }
}