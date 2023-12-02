package use_case.select_answer;

public interface SelectAnswerOutputBoundary {
    void prepareSuccessView(String message);

    void prepareFailView(String message);
}
