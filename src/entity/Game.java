import entity.*;

import java.util.ArrayList;

class Game {
    private String currCategory;
    private float timeLeft;
    private Question currQuestion;

    private ArrayList<Question> questionList;

    Game(String currCategory, float timeLeft, Question currQuestion, ArrayList<Question> questionList)
    {
        this.currCategory = currCategory;
        this.timeLeft = timeLeft;
        this.currQuestion = currQuestion;
        this.questionList = questionList;
    }

    void pauseGame()
    {

    }
    void playGame()
    {

    }
    void restartGame()
    {

    }
    void returnToLobby()
    {

    }
    void computePoints()
    {

    }

    void getPlayerAns()
    {

    }

    void checkCorrect()
    {

    }

    void getQuestion()
    {

    }

    void getAns()
    {

    }

}