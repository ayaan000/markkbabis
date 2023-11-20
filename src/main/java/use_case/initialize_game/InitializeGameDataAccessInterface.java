package use_case.initialize_game;

import java.io.IOException;
import java.net.MalformedURLException;

public interface InitializeGameDataAccessInterface {

    String callApi(String category, String difficulty, int numberOfQuestions) throws IOException, InterruptedException;

}
