package data_access;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class RetrieveCategoryID {

    private HashMap<String, Integer> category;

    private final String[] skipCategories = {"Japanese Anime & Manga"};

    public RetrieveCategoryID () throws IOException {
        category = new HashMap<>();
        this.setCategory();

    }

    public String APISingleLineString() throws IOException {
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

    }

    public void setCategory () throws IOException {
        String informationString = APISingleLineString();
        informationString = informationString.substring(22,informationString.length()-2); //Remove 'trivia_categories'
        System.out.println(informationString);
        String[] splitComma = informationString.split("},");
        for (String s : splitComma) {
            String[] splitid = s.split(",");
            String strCategoryNumber = splitid[0].substring(splitid[0].indexOf(':') + 1);
            String categoryName = splitid[1].substring((splitid[1].indexOf(':')));
            int categoryNumber = Integer.parseInt(strCategoryNumber);
            categoryName = categoryName.substring((categoryName.indexOf('"') + 1), categoryName.lastIndexOf('"'));
            category.put(categoryName, categoryNumber);
        }

    }




    public static void main(String[] args) throws IOException {
        RetrieveCategoryID testObject = new RetrieveCategoryID();
        testObject.setCategory();
        for (String name: testObject.category.keySet()){
            System.out.println(name + " " + testObject.category.get(name) );
        }
        //this code in the main branch is only for testing purposes, we can remove it later
    }
}
