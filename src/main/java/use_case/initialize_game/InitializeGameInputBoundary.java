package use_case.initialize_game;

import java.io.IOException;

public interface InitializeGameInputBoundary {
    void execute(InitializeGameInputData initializeGameInputData) throws IOException, InterruptedException;
}
