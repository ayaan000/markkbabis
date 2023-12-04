package use_case.calculate_point;

public interface CalculatePointOutputBoundary {
    void prepareSuccessView(CalculatePointOutputData user);

    void prepareFailView(String error);
}
