<<<<<<< HEAD
package use_case.calculate_point;

public class CalculatePointInteractor implements CalculatePointInputBoundary{
    final CalculatePointDataAccessInterface dataAccessObject;
    final CalculatePointOutputBoundary calculatePointPresenter;

    public CalculatePointInteractor(CalculatePointDataAccessInterface dataAccessObject, CalculatePointOutputBoundary
            calculatePointPresenter) {
        this.dataAccessObject = dataAccessObject;
        this.calculatePointPresenter = calculatePointPresenter;
    }

    @Override
    public void execute(CalculatePointInputData calculatePointInputData) {
        boolean correctness = false;
        if (!(dataAccessObject.matchAnswer())) {
            player.point += 0; //where to access player
            CalculatePointOutputData calculatePointOutputData = new CalculatePointOutputData(false, player.point);
            execute CalulatePointPresenter; //idea only because hasn't able to access DAO
        }
        else { //correctAnswer
            player.point = player.point + 100 + round(10 * question.timeLeft); //algo
            CalculatePointOutputData calculatePointOutputData = new CalculatePointOutputData(true, player.point);
            execute CalulatePointPresenter; //idea only because hasn't able to access DAO
        }
    }
=======
package use_case.calculate_point;public class CalculatePointInteractor {
>>>>>>> b21a1d0 (Implement of CalculatePointInputBoundary)
}
