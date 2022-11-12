import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainGUI implements PropertyChangeListener {
    private JFrame window;
    private final int height;
    private final int width;
    private String windowName;
    private Demo[] dataStructureDemos;
    private int currentDemoIndex;
    private JPanel animalButtonContainer;
    private JPanel dataStructureDemoContainer;
    private JPanel menuContainer;

    public MainGUI(int width, int height, String frameName, Demo[] demos, JPanel animalButtonJPanel, JPanel menuJPanel) {
        this.currentDemoIndex = 0;
        this.dataStructureDemos = demos;
        this.width = width;
        this.height = height;
        windowName = frameName;
        animalButtonContainer = animalButtonJPanel;
        menuContainer = menuJPanel;
        initGUI();
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

    private void initGUI(){
        initWindow();
        initContainers();
        initDemos();
    }

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

    private void initDemos() {
//      do any initializations needed for demos showing them
//      once user hits go can be handled in another method
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = gbc.weighty = 1.0;

        dataStructureDemoContainer.setLayout(new GridBagLayout());
    }

    private void initContainers() {
        dataStructureDemoContainer = new JPanel();
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

        window.add(animalButtonContainer, animalButtonConstraints);
        window.add(dataStructureDemoContainer, dataStructureDemoConstraints);
        window.add(menuContainer, menuConstraints);
    }

    private void addDemoToDemoContainer(Demo demoToAdd) {
        dataStructureDemoContainer.add(demoToAdd.getGUIContainer());
        demoToAdd.addPropertyChangeListener(this);
    }

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ((boolean) evt.getNewValue()) {
            removeActiveDemoFromContainer();
            currentDemoIndex++;
            if (currentDemoIndex < dataStructureDemos.length) {
                Demo newDemo = dataStructureDemos[currentDemoIndex];
                addDemoToDemoContainer(newDemo);
                newDemo.play();
            }
//            else if (currentDemoIndex >= dataStructureDemos.length) {
//                this.currentDemoIndex = 0;
//            }
        }
    }

    private void playDemos() {
        if (dataStructureDemoContainer.getComponentCount() != 0) {
            removeActiveDemoFromContainer();
        }
        this.currentDemoIndex = 0;
        Demo currentDemo = dataStructureDemos[this.currentDemoIndex];
        addDemoToDemoContainer(currentDemo);
        currentDemo.play();

//      test code
//        currentDemo.setHasCompleted(true);
    }

    public static void main(String[] args) {
        int height = 1000;
        int width = 1000;
        String mainGUIName = "Zoo";

//      panel for the animal button section
        JPanel animalButtonPanel = new JPanel();
        animalButtonPanel.setBackground(Color.blue);

//      panel for menu button section
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.green);

//      set up demo stuff for the show DS section
        int numOfDemos = 2;
        Demo[] demos = new Demo[numOfDemos];

//      linked list show example(WIP)
        JPanel llPanel0 = new JPanel();
        llPanel0.setBackground(Color.yellow);
        LinkedListDemo llDemo = new LinkedListDemo(llPanel0);
        Chicken aChicken0 = new Chicken("Gallus gallus 00", 13, true, 3, 5);
        Chicken aChicken1 = new Chicken("Gallus gallus 01", 13, true, 3, 5);
        Chicken aChicken2 = new Chicken("Gallus gallus 02", 13, true, 3, 5);
        Chicken aChicken3 = new Chicken("Gallus gallus 03", 13, true, 3, 5);
        Chicken aChicken4 = new Chicken("Gallus gallus 04", 13, true, 3, 5);

        llDemo.addAnimal(aChicken0);
        llDemo.addAnimal(aChicken1);
        llDemo.addAnimal(aChicken2);
        llDemo.addAnimal(aChicken3);
        llDemo.addAnimal(aChicken4);

        demos[0] = llDemo;

        JPanel llPanel1 = new JPanel();
        llPanel1.setBackground(Color.magenta);
        LinkedListDemo llDemo2 = new LinkedListDemo(llPanel1);
        Chicken aChicken5 = new Chicken("LLDemo2: chicken5", 13, true, 3, 5);
        Chicken aChicken6 = new Chicken("LLDemo2: chicken6", 13, true, 3, 5);

        llDemo2.addAnimal(aChicken5);
        llDemo2.addAnimal(aChicken6);

        demos[1] = llDemo2;

        MainGUI gui = new MainGUI(width, height, mainGUIName, demos, animalButtonPanel, menuPanel);
        gui.playDemos();
    }
}
