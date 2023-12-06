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
        return numQuestions;
    }



}