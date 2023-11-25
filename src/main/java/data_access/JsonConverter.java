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

    // OLD VERSION
//    public void convert(String jsonString) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // Converting JSON string to JsonNode (generic representation of JSON data)
//            JsonNode rootNode = objectMapper.readTree(jsonString);
//
//            // Access data from JsonNode
//            String question = rootNode.path("results").path("question").asText();
//            String correctAnswer = rootNode.path("results").path("correct_answer").asText();
//
//            //JsonNode incorrectNode = rootNode.path("results").path("incorrect_answers");
//
//            //String incorrectAnswers = rootNode.path("results").path("incorrect_answers").asText();
//            List<String> incorrectAnswers = rootNode.path("results").path("incorrect_answers").readValue();
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void convert(String jsonString) {
    try {
        ObjectMapper objectMapper = new ObjectMapper();

        // read from json file and convert "incorrect_answers" array into String array
        MyObject myObject = objectMapper.readValue(jsonString, MyObject.class);

        // access data
        String question = myObject.getQuestion();
        String correctAnswer = myObject.getCorrectAnswer();
        String[] incorrectAnswers = myObject.getIncorrectAnswers();
//        for (String incorrectAnswer : myObject.getIncorrectAnswers()) {
//
//        }
//        int i = 0;
//        while (i < 3) {
//            incorrectAnswers[i] = myObject.getIncorrectAnswer
//            i++;
//        }
        System.out.println(question);
        System.out.println(correctAnswer);
        System.out.println(incorrectAnswers);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

class MyObject {        // temp name
    private String question;
    private String correctAnswer;
    private String[] incorrectAnswers;

    // Getters and setters

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(String[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}

    public static void main(String[] args) {
        TriviaDataAccessObject triviaDataAccessObject = new TriviaDataAccessObject();    // csv file?
        String jsonString = triviaDataAccessObject.callApi("Animals", "medium", 5);
        JsonConverter myObj = new JsonConverter();
        myObj.convert(jsonString);  // whyyyyyyy
    }

}