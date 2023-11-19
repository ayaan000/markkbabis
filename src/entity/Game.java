package entity;

import java.util.ArrayList;

public class Game {
    private String currCategory;
    private Question currQuestion;

    private ArrayList<Question> questionList;


    Game(String currCategory, float timeLeft, Question currQuestion, ArrayList<Question> questionList)
    {
        this.currCategory = currCategory;
        this.currQuestion = currQuestion;
        this.questionList = questionList;
    }


//    public boolean checkCorrect(int playerAnswer)
//    {
//        int correctAnswer = this.getAns();
//
//        if (playerAnswer == correctAnswer){
//            return true;
//        }
//
//        else {
//            return false;
//        }
//    }

    public String getCurrCategory() {
        return currCategory;
    }
    public String getQuestion()
    {
        return this.currQuestion.getQuestion();
    }

    public int getAns()
    {
        return this.currQuestion.getIndexAnswer();
    }

//    public void nextQuestion()
//    {
//        if (questionnumber < questionList.size()) {
//            this.currQuestion = questionList.get(++questionnumber);
//        }
//        else {
//            this.gameEnd = true;
//        }
//    }

}