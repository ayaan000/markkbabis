package interface_adapter.calculate_point;

import interface_adapter.ViewModel;
import entity.Question;
import interface_adapter.ViewManagerModel;
import use_case.calculate_point.CalculatePointInputBoundary;
import use_case.calculate_point.CalculatePointInputData;

public class CalculatePointPresenter{
  
    private CalculatePointViewModel calculatePointViewModel;
    private ViewModel viewModel;

    public CalculatePointPresenter(CalculatePointViewModel calculatePointViewModel,
                                   ViewModel viewModel) {
        this.calculatePointViewModel = calculatePointViewModel;
        this.viewModel = viewModel;
    }

}
