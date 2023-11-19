package data_access;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class RetrieveCategoryID {



    private static final String[] skipCategories = {"Entertainment: Japanese Anime & Manga"};
    //change this to skip any category in the database

    public static String APISingleLineString(){
        try {
            URL url = new URL("https://opentdb.com/api_category.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode" + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    informationString.append(line);
                }
                scanner.close();
                return informationString.toString();

            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    public static HashMap<String, Integer> getCategory (){
        HashMap<String, Integer> category = new HashMap<>();
        String informationString = APISingleLineString();
        informationString = informationString.substring(22,informationString.length()-2); //Remove 'trivia_categories'
        String[] splitComma = informationString.split("},");
        for (String s : splitComma) {
            String[] splitid = s.split(",");
            String strCategoryNumber = splitid[0].substring(splitid[0].indexOf(':') + 1);
            String categoryName = splitid[1].substring((splitid[1].indexOf(':')));
            int categoryNumber = Integer.parseInt(strCategoryNumber);
            categoryName = categoryName.substring((categoryName.indexOf('"') + 1), categoryName.lastIndexOf('"'));
            if (!Arrays.asList(skipCategories).contains(categoryName)) {
                category.put(categoryName, categoryNumber);
            }
        }
        return category;
    }


}
