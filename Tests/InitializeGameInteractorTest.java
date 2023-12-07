import data_access.JsonConverter;
import data_access.TriviaDataAccessObject;
import org.junit.Test;
import use_case.initialize_game.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class InitializeGameInteractorTest {
    // IDEA: given some input data, does it produce the correct output data?
    @Test
    public void numQuestionsTest() throws IOException, InterruptedException {
        InitializeGameInputData inputData = new InitializeGameInputData("Animals",
                "medium", 5);
        InitializeGameDataAccessInterface data = new TriviaDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        InitializeGameOutputBoundary successPresenter = new InitializeGameOutputBoundary() {
            @Override
            public void prepareSuccessView(InitializeGameOutputData outputData) {
                // check if output data matches expected
                assertEquals(inputData.getNumQuestions(), outputData.getGame().getNumQuestions());
            }
        };

        InitializeGameInputBoundary interactor = new InitializeGameInteractor(data, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void difficultyTest() throws IOException, InterruptedException {
        InitializeGameInputData inputData = new InitializeGameInputData("Animals",
                "medium", 5);
        InitializeGameDataAccessInterface data = new TriviaDataAccessObject();

        // This creates a successPresenter that tests whether the test case is as we expect.
        InitializeGameOutputBoundary successPresenter = new InitializeGameOutputBoundary() {
            @Override
            public void prepareSuccessView(InitializeGameOutputData outputData) {
                // check if output data matches expected
                assertEquals(inputData.getDifficulty(), outputData.getComputer().getDifficultyRating());
            }
        };

        InitializeGameInputBoundary interactor = new InitializeGameInteractor(data, successPresenter);
        interactor.execute(inputData);
    }
}
