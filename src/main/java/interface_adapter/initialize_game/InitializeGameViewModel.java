package interface_adapter.initialize_game;


import interface_adapter.GameState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InitializeGameViewModel extends ViewModel {

    private GameState state = new GameState();

    public InitializeGameViewModel(String viewName) {
        super(viewName);
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}

