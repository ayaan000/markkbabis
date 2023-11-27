package use_case.initialize_game;
import entity.Question;
public class InitializeGameOutputData {
    private final Question[] data;

    public InitializeGameOutputData (Question[] data)  {
        this.data = data;
    }

    public Question[] getData() {
        return data;
    }
}
