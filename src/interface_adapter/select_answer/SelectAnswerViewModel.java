
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectAnswerViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Question";
    public static final String A_BUTTON_LABEL = "A";
    public static final String B_BUTTON_LABEL = "B";
    public static final String C_BUTTON_LABEL = "C";
    public static final String D_BUTTON_LABEL = "D";

    private SelectAnswerState state = new SelectAnswerState();

    public SelectAnswerViewModel() {
        super("select answer");
    }

    public void setState(SelectAnswerState state) {
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

    public SelectAnswerState getState() {
        return state;
    }
}
