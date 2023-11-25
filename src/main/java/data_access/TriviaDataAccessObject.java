package data_access;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringEscapeUtils;
import use_case.initialize_game.InitializeGameDataAccessInterface;

public class TriviaDataAccessObject implements InitializeGameDataAccessInterface {

    @Override
    public String callApi(String category, String difficulty, int numberOfQuestions) {
        //Returns a String representation of the decoded JSONObject
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
                return decodeHtmlEntity(informationString.toString());
                //System.out.println(informationString);
            }

        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    private String decodeHtmlEntity(String encodedString){
        return StringEscapeUtils.unescapeHtml4(encodedString);
    }

    private int convertCategory(String category) {
       HashMap<String, Integer> categoryHashMap = RetrieveCategoryID.getCategory();
       return categoryHashMap.get(category);
    }

}
