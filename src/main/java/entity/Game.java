package entity;

import java.util.ArrayList;

public class Game {
    private String currCategory;
    private Question currQuestion;

    private ArrayList<Question> questionList;

    private int questionnumber = 0;

    private boolean gameEnd = false;

    Game(String currCategory, float timeLeft, Question currQuestion, ArrayList<Question> questionList)
    {
        this.currCategory = currCategory;
        this.currQuestion = currQuestion;
        this.questionList = questionList;
    }

    public int computePoints()
    {
        return Math.round(100);

    }
//    public int computePoints()
//    {
//        return Math.round(100 * this.timeLeft);
//
//    }

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

    public Question getCurrQuestion()
    {
        return this.currQuestion;
    }

    public int getAns()
    {
        return this.currQuestion.getIndexAnswer();
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public int getNumQuestions() {
        return questionList.size();
    }

    public void nextQuestion()
    {
        if (questionnumber < questionList.size()) {
            this.currQuestion = questionList.get(++questionnumber);
        }
        else {
            this.gameEnd = true;
        }
    }

}