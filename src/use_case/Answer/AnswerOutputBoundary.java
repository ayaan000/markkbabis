package use_case.Answer;

public interface AnswerOutputBoundary {
    void prepareSuccessView(AnswerOutputData user);

    void prepareFailView(String error);
}
