package interface_adapter.select_answer;

public class SelectAnswerState {
    private String question = "";
    private String answer = "";
    private boolean correctness = false;
    private int playerPoint;

    public SelectAnswerState(SelectAnswerState copy) {
        question = copy.question;
        answer = copy.answer;
        correctness = copy.correctness;
        playerPoint = copy.playerPoint;
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

    public int getPlayerPoint() {
        return playerPoint;
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

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
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

