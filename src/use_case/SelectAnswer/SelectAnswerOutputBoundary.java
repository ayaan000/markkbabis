package use_case.SelectAnswer;

public interface SelectAnswerOutputBoundary {
    void prepareSuccessView(SelectAnswerOutputData user);

    void prepareFailView(String error);
}
