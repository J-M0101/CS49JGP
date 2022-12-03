import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class MainGUI implements PropertyChangeListener {
    private JFrame window;
    private final int height;
    private final int width;
    private String windowName;
    /**
     * Demos that will be played
     */
    private Demo[] dataStructureDemos;
    private int currentDemoIndex;
    /**
     * Container to hold all animal selection buttons ex. "Chicken"
     */
    private AnimalButtonComponent animalButtonContainer;
    /**
     * Demos will be shown in this container
     */
    private JPanel dataStructureDemoContainer;
    /**
     * Container to hold all menu buttons ex. "GO"
     */
    private MenuComponent menuContainer;

    public MainGUI(int width, int height, String frameName, Demo[] demos, AnimalButtonComponent animalButtonJPanel, MenuComponent menuJPanel) {
        this.currentDemoIndex = 0;
        this.dataStructureDemos = demos;
        this.width = width;
        this.height = height;
        windowName = frameName;
        animalButtonContainer = animalButtonJPanel;
        menuContainer = menuJPanel;
        dataStructureDemoContainer = new JPanel();
        initGUI();
        setMenuButtonListeners();
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public String getJFrameName() { return windowName; }

    public void setJFrameName(String name) {
        windowName = name;
        updateJFrameWindowName();
    }

    private void updateJFrameWindowName() {
        window.setTitle(windowName);
    }

    /**
     * Initialize the whole root GUI
     */
    private void initGUI(){
        initWindow();
        initContainers();
        initDemosContainer();
    }

    /**
     * Initialize GUI window
     */
    private void initWindow() {
        window = new JFrame(windowName);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        window.setSize(this.width, this.height);
        window.setLayout(new GridBagLayout());
        window.setVisible(true);
    }

    /**
     * Initializations needed for container holding Demos in window
     */
    private void initDemosContainer() {
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.weightx = gbc.weighty = 1.0;

        dataStructureDemoContainer.setLayout(new GridBagLayout());
//        dataStructureDemoContainer.setLayout(new CardLayout());
    }

    /**
     * initializes the window GUI structure layout
     * Sets the container section's dimensions
     */
    private void initContainers() {
        dataStructureDemoContainer.setBackground(Color.red);

        GridBagConstraints animalButtonConstraints = new GridBagConstraints();
        animalButtonConstraints.fill = GridBagConstraints.BOTH;
        animalButtonConstraints.gridheight = 2;
        animalButtonConstraints.weighty = 1;
        animalButtonConstraints.weightx = 0.10;

        GridBagConstraints dataStructureDemoConstraints = new GridBagConstraints();
        dataStructureDemoConstraints.gridx = 1;
        dataStructureDemoConstraints.fill = GridBagConstraints.BOTH;
        dataStructureDemoConstraints.weightx = 0.5;
        dataStructureDemoConstraints.weighty = 0.5;

        GridBagConstraints menuConstraints = new GridBagConstraints();
        menuConstraints.gridx = 1;
        menuConstraints.fill = GridBagConstraints.BOTH;
        menuConstraints.weighty = 0.10;
        menuConstraints.weightx = 0.5;

        window.add(animalButtonContainer.getGuiContainer(), animalButtonConstraints);
        window.add(dataStructureDemoContainer, dataStructureDemoConstraints);
        window.add(menuContainer.getGuiContainer(), menuConstraints);
    }

    private void setMenuButtonListeners() {
        menuContainer.getGoBtn().addActionListener(this::onGo);
        menuContainer.getSaveBtn().addActionListener(this::onSave);
        menuContainer.getLoadBtn().addActionListener(this::onLoad);
    }

    private void onGo(ActionEvent e) {
        if (!this.animalButtonContainer.getSelectedAnimal().isEmpty()) {
            playDemos();
        }
    }
    private void onSave(ActionEvent e) {
        this.menuContainer.save(this.animalButtonContainer.getSelectedAnimal());
    }
    private void onLoad(ActionEvent e) {
        ArrayList<String> animalToLoad = this.menuContainer.load();
        this.animalButtonContainer.resetToDefaultState();
        for (String animalClassNames : animalToLoad) {
            this.animalButtonContainer.onAnimalSelection(animalClassNames);
        }
    }

    /**
     * Adds Demo to Demo view and registers property listener
     * @param demoToAdd Demo to add to Demo view section
     */
    private void addDemoToDemoContainer(Demo demoToAdd) {
        dataStructureDemoContainer.add(demoToAdd.getGUIContainer());
        demoToAdd.addPropertyChangeListener(this);
    }

    /**
     * Removes Demo from Demo view section and unregisters property lister
     * @param demoToRemove Demo to remove from Demo view section
     */
    private void removeDemoFromDemoContainer(Demo demoToRemove) {
        dataStructureDemoContainer.remove(demoToRemove.getGUIContainer());
        dataStructureDemoContainer.revalidate();
        dataStructureDemoContainer.repaint();
        demoToRemove.removePropertyChangeListener(this);
    }

    private void removeActiveDemoFromContainer() {
        Demo oldDemo = dataStructureDemos[currentDemoIndex];
        removeDemoFromDemoContainer(oldDemo);
        oldDemo.setHasCompleted(false);
    }

    /**
     * Logic to execute when registered property(s) have changed.
     * As soon as a Demo's hasCompleted status changes to true
     * will remove it and add/play the next Demo.
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("hasCompleted") && (boolean) evt.getNewValue()) {
            removeActiveDemoFromContainer();
            currentDemoIndex++;
            if (currentDemoIndex < dataStructureDemos.length) {
                Demo newDemo = dataStructureDemos[currentDemoIndex];
                addDemoToDemoContainer(newDemo);
                newDemo.play(this.animalButtonContainer.getSelectedAnimal());
            }
        }
    }

    /**
     * Starts playing all Demos from the start(index = 0)
     * once user hits the "Go" button.
     */
    void playDemos() {
        if ((dataStructureDemoContainer.getComponentCount() != 0 || currentDemoIndex != 0) && currentDemoIndex < dataStructureDemos.length) {
            removeActiveDemoFromContainer();
        }
        this.currentDemoIndex = 0;
        Demo currentDemo = dataStructureDemos[this.currentDemoIndex];
        addDemoToDemoContainer(currentDemo);
        currentDemo.play(this.animalButtonContainer.getSelectedAnimal());
    }
}
