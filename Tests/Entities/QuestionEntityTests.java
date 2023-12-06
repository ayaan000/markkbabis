package Entities;

import entity.Game;
import entity.GameStats;
import entity.Player;
import entity.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuestionEntityTests {
    @Before
    public void init(){
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth" );
    }
    @Test
    public void testGetCorrectAnswer() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth" );
        assertEquals("Sloth", question.getCorrectAnswer());
    }
//    @Test
//    public void testSetCorrectAnswer() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Tribe" );
//        question.setCorrectAnswer("Sloth");
//        assertEquals("Sloth", question.getCorrectAnswer());
//    }
    @Test
    public void testGetIndexAnswer() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth" );
        assertEquals(0, possibleAnswer.indexOf("Sloth"));
    }
    @Test
    public void testGetPossibleAnswer() {
        List<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("Sloth");
        possibleAnswers.add("Drove");
        possibleAnswers.add("Tribe");
        possibleAnswers.add("Husk");
        Question question = new Question("What is the collective noun for bears?", possibleAnswers,
                "Sloth");
        List<String> acqPossibleAnswers = question.getPossibleAnswers();
        assertEquals(possibleAnswers, acqPossibleAnswers);
    }
//    @Test
//    public void testSetPossibleAnswer() {
//        Question question = new Question("What is the collective noun for bears?",
//                new ArrayList<String>(), "Sloth" );
//        List<String> possibleAnswer1 = new ArrayList<String>();
//        possibleAnswer1.add("Sloth");
//        possibleAnswer1.add("Drove");
//        possibleAnswer1.add("Tribe");
//        possibleAnswer1.add("Husk");
//        question.setPossibleAnswer(possibleAnswer1);
//        List<String> listPossibleAnswer = Arrays.asList("Sloth", "Drove", "Tribe", "Husk");
//        question.setPossibleAnswer(possibleAnswer1);
//        assertEquals(listPossibleAnswer, question.getPossibleAnswers());
//    }
    @Test
    public void testGetQuestion() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        String ques = "What is the collective noun for bears?";
        Question question = new Question(ques, possibleAnswer, "Sloth" );
        String acqQues = question.getQuestion();
        assertEquals(ques, acqQues);
    }
//    @Test
//    public void testSetQuestion() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        String ques = "What is the collective noun for bears?";
//        Question question = new Question("", possibleAnswer, "Sloth" );
//        question.setQuestion(ques);
//        assertEquals("What is the collective noun for bears?", question.getQuestion());
//    }

}
