package Entities;

import entity.Game;
import entity.GameStats;
import entity.Player;
import entity.Question;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameStatsEntityTests {
    @Test
    public void InitialiseGameStats() {

        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(question);

        List<Byte> avatar = new ArrayList<Byte>();

        Game game = new Game(questions);

        Player player = Player(0, new ArrayList<Byte>(), );
        int playerPoints = ;
        GameStats gameStats = new GameStats()

        assert (gameStats.getPlayerPoints() ==   &&
                gameStats.getComputerPoints() == );
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
