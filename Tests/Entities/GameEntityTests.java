package Entities;

import entity.Game;
import entity.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameEntityTests {
    @Before
    public void init() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        Question[] questions = new Question[1];
        questions[0] = question;
        Game game = new Game(questions);
    }

    @Test
    public void testGetCurrQuestion() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        Question[] questions = new Question[1];
        questions[0] = question;
        Game game = new Game(questions);
        assertEquals(question, game.getCurrQuestion());
    }

    @Test
    public void testGetAns() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        Question[] questions = new Question[1];
        questions[0] = question;
        Game game = new Game(questions);
        assertEquals(0, game.getAns());
    }
    @Test
    public void testGetQuestionList() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        Question[] questions = new Question[1];
        questions[0] = question;
        Game game = new Game(questions);
        assertEquals(questions, game.getQuestionList());
    }
    @Test
    public void testGetNumQuestion() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        Question[] questions = new Question[1];
        questions[0] = question;
        Game game = new Game(questions);
        assertEquals(1, game.getNumQuestions());
    }
}

