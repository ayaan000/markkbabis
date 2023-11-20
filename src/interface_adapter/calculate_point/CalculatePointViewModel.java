<<<<<<< HEAD
package interface_adapter.calculate_point;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculatePointViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Total Point";
    public static final String PLAYER_TITLE_LABEL = "Player";
    private CalculatePointState state = new CalculatePointState();

    public CalculatePointViewModel() {
        super("calculate point");
    }

    public void setState(CalculatePointState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CalculatePointState getState() {
        return state;
    }
}

=======
package interface_adapter.calculate_point;public class CalculatePointViewModel {
}
>>>>>>> 980e33e (abstract class ViewModel)
