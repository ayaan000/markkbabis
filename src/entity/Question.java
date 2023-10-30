
package entity;

import java.util.List;

    public class Question {
        private String question;
        private List<String> possibleAnswer;
        private String correctAnswer;


        public Question(String question, List<String> possibleAnswer, String correctAnswer) {
            this.question = question;
            this.possibleAnswer = possibleAnswer;
            this.correctAnswer = correctAnswer;
        }

        public int getAnswer() {
            return possibleAnswer.indexOf(correctAnswer);
        }
        public String getQuestion() {
            return question;
        }
    }

