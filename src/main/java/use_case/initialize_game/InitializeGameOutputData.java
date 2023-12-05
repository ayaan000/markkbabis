package use_case.initialize_game;
import entity.Computer;
import entity.Game;
import entity.Player;
import entity.Question;
public class InitializeGameOutputData {

    private final Game game;
    private Player player;
    private Computer computer;

    public InitializeGameOutputData (Game game, Player player, Computer computer)  {
        this.game = game;
        this.player = player;
        this.computer = computer;
    }

    public Question[] getQuestionList() {
        return game.getQuestionList();
    }

    public Game getGame(){
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }
}
