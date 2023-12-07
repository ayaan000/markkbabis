package use_case.initialize_game;

import entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import data_access.JsonConverter;

import javax.swing.*;

public class InitializeGameInteractor implements InitializeGameInputBoundary{
    final InitializeGameDataAccessInterface initializeGameDataAccessObject;
    final InitializeGameOutputBoundary initializeGamePresenter;

    public InitializeGameInteractor(InitializeGameDataAccessInterface initializeGameDataAccessInterface,
                                    InitializeGameOutputBoundary initializeGameOutputBoundary) {
        this.initializeGameDataAccessObject = initializeGameDataAccessInterface;
        this.initializeGamePresenter = initializeGameOutputBoundary;
    }

    @Override
    public void execute(InitializeGameInputData initializeGameInputData) throws IOException, InterruptedException {
        String jsonString = initializeGameDataAccessObject.callApi(initializeGameInputData.getCategory(), initializeGameInputData.getDifficulty(), initializeGameInputData.getNumQuestions());
        JsonConverter JsonObject = JsonConverter.create(initializeGameInputData.getNumQuestions());
        Question[] questionList = JsonObject.convert(jsonString);

        Game game = new Game(questionList);
        Player player = new Player(0);
        Computer computer = new Computer(initializeGameInputData.getDifficulty());
        InitializeGameOutputData initializeGameOutputData = new InitializeGameOutputData(game, player, computer);
        initializeGamePresenter.prepareSuccessView(initializeGameOutputData);
    }
}
