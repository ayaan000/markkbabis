
package entity;

import java.util.List;

    public class Question {
        private String question;
        private List<String> possibleAnswer;
        private String correctAnswer;
        private float timeLeft;


        public Question(String question, List<String> possibleAnswer, String correctAnswer, float timeLeft) {
            this.question = question;
            this.possibleAnswer = possibleAnswer;
            this.correctAnswer = correctAnswer;
            this.timeLeft = timeLeft;
        }
        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public int getIndexAnswer() {
            return possibleAnswer.indexOf(correctAnswer);
        }
        public String getQuestion() {
            return question;
        }
    }

