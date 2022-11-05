import javax.swing.JPanel;

/**
 * Class that will be needed to "show" data structure in GUI
 */
abstract class Demo {
    private final JPanel jPanel;
    private boolean hasCompleted;

    public Demo(JPanel panel) {
        this.jPanel = panel;
        this.hasCompleted = false;
    }

    public JPanel getJPanel() { return this.jPanel; }

    public boolean getHasCompleted() { return hasCompleted; }
    public void setHasCompleted(boolean hasCompleted) { this.hasCompleted = hasCompleted; }

    /**
     * Plays the "show"
     */
    abstract void play();
}
