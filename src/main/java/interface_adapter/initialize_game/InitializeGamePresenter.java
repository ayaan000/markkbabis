package interface_adapter.initialize_game;

import use_case.initialize_game.InitializeGameOutputBoundary;
import use_case.initialize_game.InitializeGameOutputData;
import view.GameGUI;

public class InitializeGamePresenter implements InitializeGameOutputBoundary {


//    private final InitializeGameViewModel initializeGameViewModel;
//    private ViewManagerModel viewManagerModel;

    public InitializeGamePresenter(){
//        this.initializeGameViewModel = initializeGameViewModel;
//        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(InitializeGameOutputData initializeGameOutputData) {
        new GameGUI(initializeGameOutputData.getGame(),
                initializeGameOutputData.getPlayer(),
                initializeGameOutputData.getComputer());
        //Pass question list from outputdata to GameGUI
    }
}
