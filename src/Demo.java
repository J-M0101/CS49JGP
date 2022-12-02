import javax.swing.JPanel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * abstract Class that will be needed to "show" data structure in GUI
 */
abstract class Demo {
    private final JPanel GUIContainer;
    private boolean hasCompleted;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public Demo(JPanel panel) {
        this.GUIContainer = panel;
        this.hasCompleted = false;
    }

    /**
     * GUI for showing the data structure.
     * Use this as the canvas for adding components and
     * showing Demo GUI stuff when the play() method is invoked.
     * @return JPanel
     */
    public JPanel getGUIContainer() { return this.GUIContainer; }

    /**
     * @return returns Demo current completion status
     */
    public boolean getHasCompleted() { return hasCompleted; }

    /**
     * hasCompleted setter. If overriding make sure to fire property has changed
     * in the overridden method.
     * @param newValue new Demo has completed value
     */
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
     * Plays the "show data structure".
     * Use this method to do anything needed to set up and start
     * the demo GUI.
     */
    abstract void play(ArrayList<Animal> selectedAnimals);
}
