package Entities;

import entity.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameStatsEntityTests {
    @Test
    public void InitialiseGameStats1() {

        List<Byte> avatar = new ArrayList<Byte>();

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

        List<GameStats> gameStatsList = new ArrayList<GameStats>();

        Player player = new Player(0, avatar, new ArrayList<GameStats>(), game);
        Computer computer = new Computer("easy");

        int playerPoints = player.getTotalPoints();
        int computerPoints = computer.getTotalPoints2();

        GameStats gameStats = new GameStats(playerPoints, computerPoints);

        assert (gameStats.getPlayerPoints() == 0 &&
                gameStats.getComputerPoints() == 0);
    }

    @Test
    public void InitialiseGameStats2() {

        List<Byte> avatar = new ArrayList<Byte>();

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

        List<GameStats> gameStatsList = new ArrayList<GameStats>();

        Player player = new Player(0, avatar, new ArrayList<GameStats>(), game);
        Computer computer = new Computer("easy");

        player.setAdditionalPoints(25);
        computer.setAdditionPoints(50);

        int playerPoints = player.getTotalPoints();
        int computerPoints = computer.getTotalPoints2();

        GameStats gameStats = new GameStats(playerPoints, computerPoints);

        assert (gameStats.getPlayerPoints() == 25 &&
                gameStats.getComputerPoints() == 50);
    }

    @Test
    public void InitialiseGameStats3() {

        List<Byte> avatar = new ArrayList<Byte>();

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

        List<GameStats> gameStatsList = new ArrayList<GameStats>();

        Player player = new Player(0, avatar, new ArrayList<GameStats>(), game);
        Computer computer = new Computer("easy");

        player.setAdditionalPoints(0);
        computer.setAdditionPoints(500);

        int playerPoints = player.getTotalPoints();
        int computerPoints = computer.getTotalPoints2();

        GameStats gameStats = new GameStats(playerPoints, computerPoints);

        assert (gameStats.getPlayerPoints() == 0 &&
                gameStats.getComputerPoints() == 500);
    }

//    @Test
//    public void RunGameStats1() {
//        List<String> possibleAnswer = new ArrayList<String>();
//        possibleAnswer.add("Sloth");
//        possibleAnswer.add("Drove");
//        possibleAnswer.add("Tribe");
//        possibleAnswer.add("Husk");
//        Question question = new Question("What is the collective noun for bears?",
//                possibleAnswer, "Sloth");
//        List<Byte> avatar = new ArrayList<Byte>();
//        ArrayList<Question> questions = new ArrayList<Question>();
//        questions.add(question);
//        Game game = new Game("Animals", question, questions);
//        GameStats gameStats = new GameStats(game, questions, "Medium", 1, 10,
//                20, 10, 20);
//
//        assert (Objects.equals(gameStats.getGame().getCurrCategory(), "Animals") &&
//                Objects.equals(gameStats.getGame().getCurrQuestion().getQuestion(),
//                        "What is the collective noun for bears?") &&
//                gameStats.getGame().getQuestionList().equals(questions) &&
//
//                gameStats.getQuestions()== questions &&
//                Objects.equals(gameStats.getDifficulty(), "Medium") &&
//                gameStats.getNumQuestions() == 1 &&
//                gameStats.getGame().getQuestionList() == gameStats.getQuestions() &&
//
//                gameStats.getPlayerPoints() == 10 &&
//                gameStats.getComputerPoints() == 20 &&
//                gameStats.getNumCorrectAnswers1() == 10 &&
//                gameStats.getNumCorrectAnswers2() == 20);
//    }
}
