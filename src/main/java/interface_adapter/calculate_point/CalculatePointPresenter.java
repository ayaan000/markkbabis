package interface_adapter.calculate_point;

import interface_adapter.ViewModel;
import use_case.calculate_point.CalculatePointOutputBoundary;

public class CalculatePointPresenter implements CalculatePointOutputBoundary {
    private CalculatePointViewModel calculatePointViewModel;
    private ViewModel viewModel;

    public CalculatePointPresenter(CalculatePointViewModel calculatePointViewModel,
                                   ViewModel viewModel) {
        this.calculatePointViewModel = calculatePointViewModel;
        this.viewModel = viewModel;
    }
}
