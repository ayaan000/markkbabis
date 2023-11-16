package use_case.select_answer;

public interface SelectAnswerOutputBoundary {
    void prepareSuccessView(SelectAnswerOutputData user);

    void prepareFailView(String error);
}
