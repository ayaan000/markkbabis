package use_case.select_answer;


import entity.Question;



public class SelectAnswerInteractor implements SelectAnswerInputBoundary{
    // final SelectAnswerDataAccessInterface userDataAccessObject;
    final SelectAnswerOutputBoundary selectAnswerPresenter;
    Question question;
    public SelectAnswerInteractor(SelectAnswerOutputBoundary selectAnswerOutputBoundary, Question question) {
        this.selectAnswerPresenter = selectAnswerOutputBoundary;
        this.question = question;
    }

    @Override
    public void execute(SelectAnswerInputData selectAnswerInputData) {
        String userAnswer = selectAnswerInputData.getAnswer();
        String questionAnswer = question.getCorrectAnswer();
        if (userAnswer.equals(questionAnswer)){             // correct
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(true);
            selectAnswerPresenter.prepareSuccessView(selectAnswerOutputData);
        } else {                                        // false
            SelectAnswerOutputData selectAnswerOutputData = new SelectAnswerOutputData(false);
            selectAnswerPresenter.prepareSuccessView(selectAnswerOutputData);
        }
    }
}
