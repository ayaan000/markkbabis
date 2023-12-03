package interface_adapter.calculate_point;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculatePointViewModel extends ViewModel {
    public final String TITLE_LABEL = "Points";
    public final String PLAYER_POINT_LABEL = "Player point: ";
    public static final String NEXT_QUESTION_BUTTON_LABEL = "Next";
    private CalculatePointState state = new CalculatePointState();
    public CalculatePointViewModel() {
        super("select answer");
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

