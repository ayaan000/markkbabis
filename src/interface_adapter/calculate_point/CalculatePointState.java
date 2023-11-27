<<<<<<< HEAD
package interface_adapter.calculate_point;

public class CalculatePointState {
    private int player_point;

    public CalculatePointState(CalculatePointState copy) {
        player_point = copy.player_point;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CalculatePointState() {
    }

    public int getPlayerPoint() {
        return player_point;
    }
    public void setPlayerPoint(int player_point) {
        this.player_point = player_point;
    }

    @Override
    public String toString() {
        return "CalculatePointState{" +
                "player point ='" + player_point + '\'' +
                '}';
    }
}

=======
package interface_adapter.calculate_point;public class CalculatePointState {
}
>>>>>>> 5a859cf (select answer state)
