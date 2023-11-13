package entity;

import java.util.ArrayList;

public class Game {
    private String currCategory;
    private float timeLeft;
    private Question currQuestion;

    private ArrayList<Question> questionList;

    private int questionnumber = 0;

    Game(String currCategory, float timeLeft, Question currQuestion, ArrayList<Question> questionList)
    {
        this.currCategory = currCategory;
        this.timeLeft = timeLeft;
        this.currQuestion = currQuestion;
        this.questionList = questionList;
    }

    public int computePoints()
    {
        return Math.round(100 * this.timeLeft);

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

    public void nextQuestion()
    {
        if (questionnumber < questionList.size()) {
            this.currQuestion = questionList.get(++questionnumber);
        }
        else {
            //code for game end
        }
    }

}