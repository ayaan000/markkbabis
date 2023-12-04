package use_case.game_stats;

import entity.Player;
import entity.Computer;
import entity.Game;

public class GameStatsInputData {
    private Player player;
    private Computer computer;
    private Game game;

    public GameStatsInputData(Player player, Computer computer, Game game) {
        this.player = player;
        this.computer = computer;
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }

    public Game getGame() {
        return game;
    }
}
