package use_case.initialize_game;
import entity.Computer;
import entity.Player;
import entity.Question;
public class InitializeGameOutputData {
    private final Question[] data;
    private Player player;
    private Computer computer;

    public InitializeGameOutputData (Question[] data, Player player, Computer computer)  {
        this.data = data;
        this.player = player;
        this.computer = computer;
    }

    public Question[] getData() {
        return data;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }
}
