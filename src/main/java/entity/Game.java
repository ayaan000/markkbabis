package entity;

import java.util.ArrayList;

public class Game {

    private Question currQuestion;

    private Question[] questionList;

    private int numQuestions;


    public Game(Question[] questionList)
    {
        this.questionList = questionList;
        this.numQuestions = questionList.length;
        this.currQuestion = questionList[0];
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

    public Question[] getQuestionList() {
        return questionList;
    }

    public int getNumQuestions() {
        return questionList.length;
    }



}