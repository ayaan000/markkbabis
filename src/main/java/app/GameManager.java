package app;

import data_access.TriviaDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.initialize_game.InitializeGameController;
import interface_adapter.initialize_game.InitializeGamePresenter;
import use_case.initialize_game.InitializeGameInputBoundary;
import use_case.initialize_game.InitializeGameInteractor;
import use_case.initialize_game.InitializeGameOutputBoundary;
import view.HomeGUI;

public class GameManager {


    public static void main(String[] args) {
        TriviaDataAccessObject userDataAccessObject = new TriviaDataAccessObject();
//        InitializeGameViewModel initializeGameViewModel = new InitializeGameViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        InitializeGameOutputBoundary initializeGameOutputBoundary = new InitializeGamePresenter();
        InitializeGameInputBoundary initializeGameInteractor = new InitializeGameInteractor(userDataAccessObject, initializeGameOutputBoundary);
        InitializeGameController initializeGameController = new InitializeGameController(initializeGameInteractor);
        new HomeGUI(initializeGameController);


    }
}
