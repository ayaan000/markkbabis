package interface_adapter.game_stats;

import entity.Computer;
import entity.Player;
import use_case.game_stats.GameStatsInputBoundary;
import use_case.game_stats.GameStatsInputData;
import use_case.initialize_game.InitializeGameInputBoundary;
import use_case.initialize_game.InitializeGameInputData;

import java.io.IOException;

public class GameStatsController {
    GameStatsInputBoundary gameStatsInteractor;

    public GameStatsController(GameStatsInputBoundary gameStatsInputBoundary){
        this.gameStatsInteractor = gameStatsInputBoundary;
    }

    public void execute(Player player, Computer computer){
        GameStatsInputData gameStatsInputData =
                new GameStatsInputData(player, computer);
        gameStatsInteractor.execute(gameStatsInputData);

    }
}
