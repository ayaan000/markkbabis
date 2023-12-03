package interface_adapter.initialize_game;

import use_case.initialize_game.InitializeGameInputBoundary;
import use_case.initialize_game.InitializeGameInputData;

import java.io.IOException;

public class InitializeGameController {
    InitializeGameInputBoundary initializeGameInteractor;

    public InitializeGameController(InitializeGameInputBoundary initializeGameInteractor){
        this.initializeGameInteractor = initializeGameInteractor;
    }

    public void execute(String category, String difficulty, int nquestions){
        try {
            InitializeGameInputData initializeGameInputData =
                    new InitializeGameInputData(category, difficulty, nquestions);
            initializeGameInteractor.execute(initializeGameInputData);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
