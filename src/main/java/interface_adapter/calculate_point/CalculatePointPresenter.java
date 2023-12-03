package interface_adapter.calculate_point;

import interface_adapter.ViewModel;
import use_case.calculate_point.CalculatePointOutputBoundary;
import use_case.calculate_point.CalculatePointOutputData;

public class CalculatePointPresenter implements CalculatePointOutputBoundary {
    private CalculatePointViewModel calculatePointViewModel;
    private ViewModel viewModel;

    public CalculatePointPresenter(CalculatePointViewModel calculatePointViewModel,
                                   ViewModel viewModel) {
        this.calculatePointViewModel = calculatePointViewModel;
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(CalculatePointOutputData user) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
