package use_case.initialize_game;

import entity.Question;

import java.io.IOException;
import data_access.JsonConverter;
public class InitializeGameInteractor implements InitializeGameInputBoundary{
    final InitializeGameDataAccessInterface initializeGameDataAccessObject;
    final InitializeGameOutputBoundary initializeGamePresenter;

    public InitializeGameInteractor(InitializeGameDataAccessInterface initializeGameDataAccessInterface,
                                    InitializeGameOutputBoundary initializeGameOutputBoundary) {
        this.initializeGameDataAccessObject = initializeGameDataAccessInterface;
        this.initializeGamePresenter = initializeGameOutputBoundary;
    }

//    public void execute() {
//        // ideas from signup use case in week05
//        /* do we need any sort of conditions regarding the input from the user?
//           is there a relationship between number of questions or difficulty?
//           there is a limit to how many questions a user can ask for. what is it?
//
//           If we decide to use a Factory design pattern, we need to include it here somewhere.
//         */
//
//        // template from clear_users use case in week05
//        InitializeGameOutputData initializeGameOutputData = new InitializeGameOutputData(...);
//                    // ^^ in this line we are essentially calling the functionality/method that gets our output data
//        initializeGamePresenter.prepareSuccessView(initializeGameOutputData);
//                    // ^^ in this line we are getting ready to show the user their output data
//    }

    @Override
    public void execute(InitializeGameInputData initializeGameInputData) throws IOException, InterruptedException {
        String jsonString = initializeGameDataAccessObject.callApi(initializeGameInputData.getCategory(), initializeGameInputData.getDifficulty(), initializeGameInputData.getNumQuestions());
        JsonConverter JsonObject = JsonConverter.create(initializeGameInputData.getNumQuestions()); //Singleton
        Question[] questionList = JsonObject.convert(jsonString);
        InitializeGameOutputData initializeGameOutputData = new InitializeGameOutputData(questionList);
    }
}
