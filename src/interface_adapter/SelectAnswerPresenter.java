package interface_adapter;

import use_case.SelectAnswerOutputBoundary;
import use_case.SelectAnswerOutputData;

public class SelectAnswerPresenter implements SelectAnswerOutputBoundary {
    // state and view model
    public SelectAnswerPresenter() {
    }
    @Override
    public void prepareSuccessView(SelectAnswerOutputData selectAnswerOutputData) {
    }

    @Override
    public void prepareFailView(String message) {
        state = viewModel.getState();
        state.setAnswerError(error);
        viewModel.firePropertyChanged();
    }
}
