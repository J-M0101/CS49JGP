import javax.swing.JPanel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Class that will be needed to "show" data structure in GUI
 */
abstract class Demo {
    private final JPanel GUIContainer;
    private boolean hasCompleted;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public Demo(JPanel panel) {
        this.GUIContainer = panel;
        this.hasCompleted = false;
    }

    public JPanel getGUIContainer() { return this.GUIContainer; }

    public boolean getHasCompleted() { return hasCompleted; }

    public void setHasCompleted(boolean newValue) {
        boolean oldValue = this.getHasCompleted();
        this.hasCompleted = newValue;
        this.pcs.firePropertyChange("hasCompleted", oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    /**
     * Plays the "show"
     */
    abstract void play();
}
