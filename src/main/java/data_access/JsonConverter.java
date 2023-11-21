package data_access;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonConverter {

    // input from user (use input data or is that backwards?)
    // still need to define
    String category;
    String difficulty;
    int numberOfQuestions;
    String jsonString = TriviaDataAccessObject.callApi(category, difficulty, numberOfQuestions);

    public void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Converting JSON string to JsonNode (generic representation of JSON data)
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Access data from JsonNode
            String question = jsonNode.get("question").asText();
            String correctAnswer = jsonNode.get("correct_answer").asText();
            String incorrectAnswers = jsonNode.get("incorrect_answers").asText();   // for now storing as string

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
