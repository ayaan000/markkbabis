package interface_adapter.select_answer;

import interface_adapter.calculate_point.CalculatePointViewModel;
import use_case.select_answer.SelectAnswerOutputBoundary;
import use_case.select_answer.SelectAnswerOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_point.CalculatePointState;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SelectAnswerPresenter implements SelectAnswerOutputBoundary {
    private final SelectAnswerViewModel selectAnswerViewModel;
    private final CalculatePointViewModel calculatePointViewModel;
    private ViewManagerModel viewManagerModel;

    public SelectAnswerPresenter(SelectAnswerViewModel selectAnswerViewModel,
                                 CalculatePointViewModel calculatePointViewModel,
                                 ViewManagerModel viewManagerModel ) {
        this.selectAnswerViewModel = selectAnswerViewModel;
        this.calculatePointViewModel = calculatePointViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(SelectAnswerOutputData result) {
        // On success, switch to the CalculatePoint view.
        CalculatePointState calculatePointState = calculatePointViewModel.getState();
        this.calculatePointViewModel.setState(calculatePointState);
        calculatePointViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(calculatePointViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
