import data_access.JsonConverter;
import data_access.TriviaDataAccessObject;
import org.junit.Test;
import use_case.initialize_game.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class InitializeGameInteractorTest {
    // IDEA: given some input data, does it produce the correct output data?
    @Test
    public void successTest() throws IOException, InterruptedException {
        InitializeGameInputData inputData = new InitializeGameInputData("Animals",
                "medium", 5);
//        TriviaDataAccessObject dataCollecter = new TriviaDataAccessObject();
//        String dataString = dataCollecter.callApi(inputData.getCategory(),
//                                                    inputData.getDifficulty(),
//                                                    inputData.getNumQuestions());
//        JsonConverter converter = JsonConverter.create(inputData.getNumQuestions());
//        InitializeGameDataAccessInterface data = converter.convert(dataString);
        InitializeGameDataAccessInterface data = new TriviaDataAccessObject();

                // This creates a successPresenter that tests whether the test case is as we expect.
        InitializeGameOutputBoundary successPresenter = new InitializeGameOutputBoundary() {
            @Override
            public void prepareSuccessView(InitializeGameOutputData outputData) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals(inputData.getNumQuestions(), outputData.getGame().getNumQuestions());
                //assertTrue(userRepository.existsByName("Paul"));
            }

        };

        InitializeGameInputBoundary interactor = new InitializeGameInteractor(data, successPresenter);
        interactor.execute(inputData);
    }


    // UNIT TESTING
    // mock presenter class
    // create input DO, output DO, and DAO
    // this DAO created specifically for testing purposes


    // INTEGRATION TESTING
    // let UCI call actual DAO methods
    //     tests check output of DAO methods
    //
}
