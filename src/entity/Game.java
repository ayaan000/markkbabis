package entity;

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
        //Code to pause game
    }
    void playGame()
    {
        //Code to begin game
    }
    void restartGame()
    {
        //Code to reload game
    }
    void returnToLobby()
    {
        //Code to return to lobby
    }
    public float computePoints()
    {
        float points = 10 * this.timeLeft;
        return points;

    }

    String getPlayerAns()
    {
        return "";
    }

    public boolean checkCorrect(int playerAnswer)
    {
        int correctAnswer = this.getAns();

        if (playerAnswer == correctAnswer){
            return true;
        }

        else {
            return false;
        }
    }

    public String getQuestion()
    {
        return this.currQuestion.getQuestion();
    }

    public int getAns()
    {
        return this.currQuestion.getAnswer();
    }

    public void setCurrQuestion(Question newQuestion)
    {
        this.currQuestion = newQuestion;
    }

}