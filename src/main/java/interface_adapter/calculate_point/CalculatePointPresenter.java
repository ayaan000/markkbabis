package interface_adapter.calculate_point;

import entity.Question;
import interface_adapter.ViewManagerModel;
import use_case.calculate_point.CalculatePointInputBoundary;
import use_case.calculate_point.CalculatePointInputData;
import use_case.calculate_point.CalculatePointOutputBoundary;
import use_case.calculate_point.CalculatePointOutputData;

public class CalculatePointPresenter implements CalculatePointOutputBoundary {
    private final CalculatePointViewModel calculatePointViewModel;
    // private final QuestionViewModel questionViewModel;
    private ViewManagerModel viewManagerModel;

    public CalculatePointPresenter(CalculatePointViewModel calculatePointViewModel,
                                   ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        this.calculatePointViewModel = calculatePointViewModel;
    }
    @Override
    public void prepareSuccessView(CalculatePointOutputData calculatePointOutputData) {
        // On success, switch to the question view or what?
        // QuestionState questionState = loggedInViewModel.getState();
    }
}
