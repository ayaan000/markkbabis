package app;

import data_access.TriviaDataAccessObject;
import interface_adapter.initialize_game.InitializeGameController;
import interface_adapter.initialize_game.InitializeGamePresenter;
import use_case.initialize_game.InitializeGameInputBoundary;
import use_case.initialize_game.InitializeGameInteractor;
import use_case.initialize_game.InitializeGameOutputBoundary;
import view.HomeGUI;

public class Main {


    public static void main(String[] args) {
        TriviaDataAccessObject userDataAccessObject = new TriviaDataAccessObject();
        InitializeGameOutputBoundary initializeGameOutputBoundary = new InitializeGamePresenter();
        InitializeGameInputBoundary initializeGameInteractor = new InitializeGameInteractor(userDataAccessObject, initializeGameOutputBoundary);
        InitializeGameController initializeGameController = new InitializeGameController(initializeGameInteractor);

        new HomeGUI(initializeGameController);


    }
}
