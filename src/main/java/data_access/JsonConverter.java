package data_access;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Question;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonConverter {

    int numberOfQuestions;
    Question[] data;

    JsonConverter (int numberOfQuestions){
        this.numberOfQuestions = numberOfQuestions;
        data = new Question[numberOfQuestions];
    }

    public Question[] convert(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Converting JSON string to JsonNode (generic representation of JSON data)
            JsonNode rootNode = objectMapper.readTree(jsonString);
            // Accessing data from the "results" key
            JsonNode resultsNode = rootNode.path("results");


            Iterator<JsonNode> resultsIterator = resultsNode.elements();
            int j = 0;
            while (resultsIterator.hasNext()) {
                JsonNode resultNode = resultsIterator.next();
                String question = resultNode.path("question").asText();
                String correctAnswer = resultNode.path("correct_answer").asText();

                question = decodeHtmlEntity(question);
                correctAnswer = decodeHtmlEntity(correctAnswer);

                // FOR TESTING
                System.out.println(question);
                System.out.println(correctAnswer);

                // Accessing data from the "incorrect_answers" key
                JsonNode incorrectsNode = resultNode.path("incorrect_answers");
                List<String> incorrectAnswers = new ArrayList<String>();

                int i = 0;      // QUESTION
                for (Iterator<JsonNode> it = incorrectsNode.elements(); it.hasNext(); ) {
                    JsonNode incorrectNode = it.next();
                    String incorrectAnswer = incorrectNode.asText();
                    incorrectAnswer = decodeHtmlEntity(incorrectAnswer);
                    incorrectAnswers.add(incorrectAnswer);
                    i++;
                }

                List<String> possibleAnswers = new ArrayList<>();
                possibleAnswers.add(correctAnswer);
                possibleAnswers.addAll(incorrectAnswers);

                // FOR TESTING
                System.out.println(incorrectAnswers);
                System.out.println(possibleAnswers);

                //int j = 0;
                Question currQuestion = new Question(question, possibleAnswers, correctAnswer);
                data[j] = currQuestion;
                j++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private String decodeHtmlEntity(String encodedString){
        return StringEscapeUtils.unescapeHtml4(encodedString);
    }

//    public static void main(String[] args) {
//        TriviaDataAccessObject triviaDataAccessObject = new TriviaDataAccessObject();
//        String jsonString = triviaDataAccessObject.callApi("Sports", "hard", 5);
//        JsonConverter myObj = new JsonConverter(5);
//        myObj.convert(jsonString);
//    }

}