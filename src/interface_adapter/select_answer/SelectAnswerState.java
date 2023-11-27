package interface_adapter.select_answer;

public class SelectAnswerState {
    private String question = "";
    private String answer_A = "";
    private String answer_B = null;
    private String answer_C = "";
    private String answer_D = null;

    public SelectAnswerState(SelectAnswerState copy) {
        question = copy.question;
        answer_A = copy.answer_A;
        answer_B = copy.answer_B;
        answer_C = copy.answer_C;
        answer_D = copy.answer_D;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SelectAnswerState() {
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer_A() {
        return answer_A;
    }

    public String getAnswer_B() {
        return answer_B;
    }

    public String getAnswer_C() {
        return answer_C;
    }

    public String getAnswer_D() {
        return answer_D;
    }


    public void setQuestion (String question) {
        this.question = question;
    }

    public void setAnswer_A(String answer_A) {
        this.answer_A = answer_A;
    }

    public void setAnswer_B(String answer_B) {
        this.answer_B = answer_B;
    }

    public void setAnswer_C(String answer_C) {
        this.answer_C = answer_C;
    }

    public void setAnswer_D(String answer_D) {
        this.answer_D = answer_D;
    }

    @Override
    public String toString() {
        return "SelectAnswerState{" +
                "question='" + question + '\'' +
                ", answer A='" + answer_A + '\'' +
                ", answer B='" + answer_B + '\'' +
                ", answer C='" + answer_C + '\'' +
                ", answer D='" + answer_D + '\'' +
                '}';
    }
}

