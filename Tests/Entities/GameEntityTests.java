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
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Game game = new Game("Animals", question, questions);
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
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Game game = new Game("Animals", question, questions);
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
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        List<String> listQuestions = Arrays.asList("What is the collective noun for bears?");
        Game game = new Game("Animals", question, questions);
        assertEquals(listQuestions, game.getQuestionList());
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
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        Game game = new Game("Animals", question, questions);
        assertEquals(1, game.getNumQuestions());
    }
    @Test
    public void testNextQuestion() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        List<String> possibleAnswer1 = new ArrayList<String>();
        possibleAnswer.add("A");
        possibleAnswer.add("B");
        possibleAnswer.add("C");
        possibleAnswer.add("D");
        Question question1 = new Question("What answer is correct?",
                possibleAnswer, "Sloth");
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        questions.add(question1);
        Game game = new Game("Animals", question, questions);
        game.nextQuestion();
        assertEquals(question1, game.getCurrQuestion());
    }
}
