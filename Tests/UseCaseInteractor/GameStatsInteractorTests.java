package UseCaseInteractor;

import entity.Computer;
import entity.Game;
import entity.Player;
import interface_adapter.game_stats.GameStatsPresenter;
import org.junit.Test;
import use_case.game_stats.*;

import static junit.framework.TestCase.assertEquals;

public class GameStatsInteractorTests {


    @Test
    public void computerFinalPointsTest(){
        Player player = new Player(0);
        Computer computer = new Computer("easy");
        int points = 15;
        computer.setAdditionPoints(points);
        GameStatsInputData gameStatsInputData = new GameStatsInputData(player, computer);

        GameStatsOutputBoundary successPresenter = new GameStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(GameStatsOutputData gameStatsOutputData) {
                assertEquals(points, gameStatsOutputData.getComputerPoints());
            }
        };
        GameStatsInputBoundary gameStatsInteractor = new GameStatsInteractor(successPresenter);
        gameStatsInteractor.execute(gameStatsInputData);
    }

    @Test
    public void playerFinalPointsTest(){
        Player player = new Player(0);
        Computer computer = new Computer("easy");
        int points = 15;
        player.setAdditionalPoints(points);
        GameStatsInputData gameStatsInputData = new GameStatsInputData(player, computer);

        GameStatsOutputBoundary successPresenter = new GameStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(GameStatsOutputData gameStatsOutputData) {
                assertEquals(points, gameStatsOutputData.getPlayerPoints());
            }
        };
        GameStatsInputBoundary gameStatsInteractor = new GameStatsInteractor(successPresenter);
        gameStatsInteractor.execute(gameStatsInputData);}


}
