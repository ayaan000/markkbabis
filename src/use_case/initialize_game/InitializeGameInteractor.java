package use_case.initialize_game;

public class InitializeGameInteractor implements InitializeGameInputBoundary{
    final InitializeGameDataAccessInterface initializeGameDataAccessObject;
    final InitializeGameOutputBoundary initializeGamePresenter;

    // these variable names are getting really long, maybe we can shorten them to something else?
    // example ideas: initGame, initialize, or ig
    public InitializeGameInteractor(InitializeGameDataAccessInterface initializeGameDataAccessInterface,
                                    InitializeGameOutputBoundary initializeGameOutputBoundary) {
        this.initializeGameDataAccessObject = initializeGameDataAccessInterface;
        this.initializeGamePresenter = initializeGameOutputBoundary;
    }

    public void execute() {
        // ideas from signup use case in week05
        /* do we need any sort of conditions regarding the input from the user?
           is there a relationship between number of questions or difficulty?
           there is a limit to how many questions a user can ask for. what is it?

           If we decide to use a Factory design pattern, we need to include it here somewhere.
         */

        // template from clear_users use case in week05
        InitializeGameOutputData initializeGameOutputData = new InitializeGameOutputData(...);
                    // ^^ in this line we are essentially calling the functionality/method that gets our output data
        initializeGamePresenter.prepareSuccessView(initializeGameOutputData);
                    // ^^ in this line we are getting ready to show the user their output data
    }
}
