package interface_adapter.select_answer;

public class SelectAnswerState {
    private String question = "";
    private String answer = "";
    private boolean correctness = false;

    public SelectAnswerState(SelectAnswerState copy) {
        question = copy.question;
        answer = copy.answer;
        correctness = copy.correctness;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SelectAnswerState() {
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    public boolean getCorrectness() {
        return correctness;
    }
    public void setQuestion (String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }

    @Override
    public String toString() {
        return "SelectAnswerState{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", correctness='" + correctness + '\'' +
                '}';
    }
}

