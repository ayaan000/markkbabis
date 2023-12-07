package UseCaseInteractor;

import entity.Question;
import org.junit.jupiter.api.Test;
import use_case.select_answer.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SelectAnswerInteractorTest {
    @Test
    void successTest() {
        SelectAnswerInputData inputData = new SelectAnswerInputData("Sloth");
        // This creates a successPresenter that tests whether the test case is as we expect.
        SelectAnswerOutputBoundary successPresenter = new SelectAnswerOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectAnswerOutputData correctness) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals(true, correctness.getCorrectness());
            }
        };
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        SelectAnswerInputBoundary interactor = new SelectAnswerInteractor(successPresenter, question);
        interactor.execute(inputData);
    }

    @Test
    void failTest() {
        SelectAnswerInputData inputData = new SelectAnswerInputData("False");
        // This creates a presenter that tests whether the test case is as we expect.
        SelectAnswerOutputBoundary failurePresenter = new SelectAnswerOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectAnswerOutputData correctness) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals(false, correctness.getCorrectness());
            }
        };
        List<String> possibleAnswer = new ArrayList<String>();
        possibleAnswer.add("Sloth");
        possibleAnswer.add("Drove");
        possibleAnswer.add("Tribe");
        possibleAnswer.add("Husk");
        Question question = new Question("What is the collective noun for bears?",
                possibleAnswer, "Sloth");
        SelectAnswerInputBoundary interactor = new SelectAnswerInteractor(failurePresenter, question);
        interactor.execute(inputData);
    }
}

