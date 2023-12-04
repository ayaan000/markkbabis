
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
        public String getCorrectAnswer() {
            return correctAnswer;
        }
        public int getIndexAnswer() {
            return possibleAnswer.indexOf(correctAnswer);
        }
        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }
        public List<String> getPossibleAnswer() {
            return possibleAnswer;
        }
        public void setPossibleAnswer(List<String> possibleAnswer) {
            this.possibleAnswer = possibleAnswer;
        }

        public String getQuestion() {
            return question;
        }
        public void setQuestion(String question) {
            this.question = question;
        }
    }

