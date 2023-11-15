//package interface_adapter;
//
//import use_case.SelectAnswer;
//import use_case.SelectAnswerInputBoundary;
//import use_case.SelectAnswerInputData;
//
//public class SelectAnswerController {
//    final SelectAnswerInputBoundary userSelectAnswerInteractor;
//    public SelectAnswerController(SelectAnswerInputBoundary userSignupUseCaseInteractor) {
//        this.userSelectAnswerInteractor = userSignupUseCaseInteractor;
//    }
//
//    public void execute(int answer) {
//        SelectAnswerInputData selectAnswerInputData = new SelectAnswerInputData(answer);
//        userSelectAnswerInteractor.execute(selectAnswerInputData);
//    }
//}
