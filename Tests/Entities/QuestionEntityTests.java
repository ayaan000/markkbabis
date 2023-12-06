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
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth" );
        List<String> stringPossibleAns = Arrays.asList("Sloth", "Drove", "Tribe", "Husk");
        assertEquals(stringPossibleAns, question.getPossibleAnswers());
    }
    @Test
    public void testGetQuestion() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth" );
        assertEquals("What is the collective noun for bears?", question.getQuestion());
    }
}
