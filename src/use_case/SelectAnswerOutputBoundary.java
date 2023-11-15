package use_case;

public interface SelectAnswerOutputBoundary {
    void prepareSuccessView(SelectAnswerOutputData selectAnswerOutputData);
    void prepareFailView(String message);
}
