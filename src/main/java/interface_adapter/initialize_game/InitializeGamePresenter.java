package interface_adapter.initialize_game;

import interface_adapter.ViewManagerModel;
import use_case.initialize_game.InitializeGameOutputBoundary;
import use_case.initialize_game.InitializeGameOutputData;

public class InitializeGamePresenter implements InitializeGameOutputBoundary {


    private final InitializeGameViewModel initializeGameViewModel;
    private ViewManagerModel viewManagerModel;

    public InitializeGamePresenter(InitializeGameViewModel initializeGameViewModel, ViewManagerModel viewManagerModel){
        this.initializeGameViewModel = initializeGameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(InitializeGameOutputData initializeGameOutputData) {

    }
}
