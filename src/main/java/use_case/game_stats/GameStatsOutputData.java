package use_case.game_stats;

import java.time.Duration;

public class GameStatsOutputData {
    // Need for final game stats:
    // Category played
    // Difficulty played
    // Player1 points
    // Computer/ Player2 points
    // Player1 amt of correct answers (Indirectly displays the amt of questions)
    // Computer/ Player 2 amt of correct answers (Indirectly displays the amt of questions)
    // Time played

//    private String difficulty;
//    private int numQuestions;
    // points1 is  automatically assigned to Player1
    private int playerPoints;
    private int computerPoints;
    //numCorrectAnswers1 is  automatically assigned to Player1
//    private int numCorrectAnswers1;
//    private int numCorrectAnswers2;

    public GameStatsOutputData(int playerPoints, int computerPoints) {
//    this.difficulty = difficulty;
//    this.numQuestions = numQuestions;
    this.playerPoints = playerPoints;
    this.computerPoints = computerPoints;
//    this.numCorrectAnswers1 = numCorrectAnswers1;
//    this.numCorrectAnswers2 = numCorrectAnswers2;
    }


//    public String getDifficulty() {
//        return difficulty;
//    }
//
//    public int getNumQuestions() {
//        return numQuestions;
//    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

//    public int getNumCorrectAnswers1() {
//        return numCorrectAnswers1;
//    }
//
//    public int getNumCorrectAnswers2() {
//        return numCorrectAnswers2;
//    }
}