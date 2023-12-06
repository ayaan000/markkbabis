package Entities;

import entity.Game;
import entity.GameStats;
import entity.Player;
import entity.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerEntityTests {
    @Before
    public void init(){
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth" );

        Question[] questions = new Question[1];
        questions[0] = question;

        GameStats gameStats = new GameStats(0, 0);
        List<GameStats> listGameStats = new ArrayList<GameStats>();
        listGameStats.add(gameStats);
        Player player = new Player(10);

    }
    @Test
    public void testGetTotalPoints() {
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth" );
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);
        GameStats gameStats = new GameStats(0, 0);
        List<GameStats> listGameStats = new ArrayList<GameStats>();
        listGameStats.add(gameStats);
        Player player = new Player(10);
        assertEquals(10, player.getTotalPoints());
    }


//    @Test
//    public void testSetTotalPoints() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);

//        player.setTotalPoints(10);
//        assertEquals(10, player.getTotalPoints());
//    }
//    @Test
//    public void testGetAdditionalPoints() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);
//        Player player = new Player(0, avatar, listGameStats, game, 0);
//        player.setAdditionalPoints(100);
//        assertEquals(100, player.getTotalPoints());

//    @Test
//    public void testSetAdditionalPoints() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);
//        Player player = new Player(100, avatar, listGameStats, game, 0);
//        player.setAdditionalPoints(100);
//        assertEquals(200, player.getTotalPoints());
//    }

//    @Test
//    public void testGetGameStats() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);
//        Player player = new Player(100, avatar, listGameStats, game, 0);
//        player.setAdditionalPoints(100);
//        assertEquals(listGameStats, player.getGames());
//    }
//    @Test
//    public void testGetGame() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);
//        Player player = new Player(100, avatar, listGameStats, game, 0);
//        assertEquals(game, player.getCurrGame());
//    }
//    @Test
//    public void testSetGame() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);
//        Player player = new Player(100, avatar, listGameStats, game, 0);
//        player.setCurrGame(game);
//        assertEquals(game, player.getCurrGame());
//    }
//    @Test
//    public void testGetNumCorrectAns() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);
//        Player player = new Player(100, avatar, listGameStats, game, 0);
//        player.setNumCorrectAns(5);
//        assertEquals(5, player.getNumCorrectAns());
//    }
//    @Test
//    public void testSetNumCorrectAns() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth" );
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 0, 0,
//                0, 0);
//        List<GameStats> listGameStats = new ArrayList<GameStats>();
//        listGameStats.add(gameStats);
//        Player player = new Player(100, avatar, listGameStats, game, 0);
//        player.setNumCorrectAns(10);
//        assertEquals(10, player.getNumCorrectAns());
//    }
//
//}



}
