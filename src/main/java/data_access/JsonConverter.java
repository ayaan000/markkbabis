package data_access;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Question; // QUESTION: is it right for me to just import the class like this?

import java.util.Iterator;
import java.util.List;

public class JsonConverter {

    // QUESTION: input from user (use input data or is that backwards?)
    // still need to define
    String category;
    String difficulty;
    int numberOfQuestions;
    Question[] data = new Question[numberOfQuestions];

    // ORIGINAL (DIRECT) VERSION
    public void convert(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Converting JSON string to JsonNode (generic representation of JSON data)
            JsonNode rootNode = objectMapper.readTree(jsonString);
            // Accessing data from the "results" key
            JsonNode resultsNode = rootNode.path("results");


            Iterator<JsonNode> resultsIterator = resultsNode.elements();
            while (resultsIterator.hasNext()) {
                JsonNode resultNode = resultsIterator.next();
                String question = resultNode.path("question").asText();
                String correctAnswer = resultNode.path("correct_answer").asText();

                // Accessing data from the "incorrect_answers" key
                JsonNode incorrectsNode = resultNode.path("incorrect_answers");
                String[] incorrectAnswers = new String[3];

                int i = 0;
                for (Iterator<JsonNode> it = incorrectsNode.elements(); it.hasNext(); ) {
                    JsonNode incorrectNode = it.next();
                    String incorrectAnswer = incorrectNode.asText();
                    incorrectAnswers[i] = incorrectAnswer;
                    i++;
                }

                int j = 0;
                Question currQuestion = new Question(question, incorrectAnswers, correctAnswer);   // QUESTION: change type in Question?
                data[j] = currQuestion;
                j++;    // QUESTION: why does it say that j is never used when it is on line 49??
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // WAY USING SUBCLASS (PROBABLY NOT)
//    public void convert(String jsonString) {
//    try {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // read from json file and convert "incorrect_answers" array into String array
//        MyObject myObject = objectMapper.readValue(jsonString, MyObject.class);
//
//        // access data
//        String question = myObject.getQuestion();
//        String correctAnswer = myObject.getCorrectAnswer();
//        String[] incorrectAnswers = myObject.getIncorrectAnswers();
////        for (String incorrectAnswer : myObject.getIncorrectAnswers()) {
////
////        }
////        int i = 0;
////        while (i < 3) {
////            incorrectAnswers[i] = myObject.getIncorrectAnswer
////            i++;
////        }
//        System.out.println(question);
//        System.out.println(correctAnswer);
//        System.out.println(incorrectAnswers);
//    }
//    catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//
//class MyObject {        // temp name
//    private String question;
//    private String correctAnswer;
//    private String[] incorrectAnswers;
//
//    // Getters and setters
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public String getCorrectAnswer() {
//        return correctAnswer;
//    }
//
//    public void setCorrectAnswer(String correctAnswer) {
//        this.correctAnswer = correctAnswer;
//    }
//
//    public String[] getIncorrectAnswers() {
//        return incorrectAnswers;
//    }
//
//    public void setIncorrectAnswers(String[] incorrectAnswers) {
//        this.incorrectAnswers = incorrectAnswers;
//    }
//}

    public static void main(String[] args) {
        TriviaDataAccessObject triviaDataAccessObject = new TriviaDataAccessObject();
        String jsonString = triviaDataAccessObject.callApi("Animals", "medium", 5);
        JsonConverter myObj = new JsonConverter();
        myObj.convert(jsonString);
    }

}