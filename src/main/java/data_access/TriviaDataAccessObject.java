package data_access;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import use_case.initialize_game.InitializeGameDataAccessInterface;

//TODO: Add interfaces it implements
public class TriviaDataAccessObject implements InitializeGameDataAccessInterface {

    private final File csvFile;

    //private final String category;

    public TriviaDataAccessObject (String csvPath) {

        csvFile = new File(csvPath);

    }

    @Override
    public void callApi(String category, String difficulty, int numberOfQuestions) {

        try {
            String createURL = "https://opentdb.com/api.php?";
            String amountURL = "amount=" + numberOfQuestions + "&";
            String categoryURL = "category=" + convertCategory(category) + "&";
            String difficultyURL = "difficulty=" + difficulty;
            String finalURL = createURL + amountURL + categoryURL + difficultyURL;
            URL url = new URL(finalURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode" + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                TimeUnit.SECONDS.sleep(6); //API only allows one call every 5 seconds
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    informationString.append(line);
                }
                scanner.close();
                System.out.println(informationString); //for testing purposes
            }

        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }


    }

    private int convertCategory(String category) {
       HashMap<String, Integer> categoryHashMap = RetrieveCategoryID.getCategory();
       return categoryHashMap.get(category);
    }

    public static void main(String[] args) {
        TriviaDataAccessObject testObject = new TriviaDataAccessObject("");
        testObject.callApi("Sports", "medium", 5);

        //WHY 429 error?
    }
}
