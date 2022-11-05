import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI {
    private JFrame window;
    private final int height;
    private final int width;
    private String windowName;

    private Demo[] dataStructureDemos;

    private JPanel animalButtonContainer;
    private JPanel dataStructureDemoContainer;
    private JPanel menuContainer;

    public MainGUI(int width, int height, String frameName, Demo[] demos, JPanel animalButtonJPanel, JPanel menuJPanel) {
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
        initJFrame();
        initContainers();
        initDemos();
    }

    private void initJFrame() {
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
//        do any initializations needed for demos showing them
//        once user hits go can be handled in another method
//        dataStructureDemoContainer.add(dataStructureDemos[0].getJPanel());
//        window.add(dataStructureDemos[0].getJPanel());
    }

    private void initContainers() {
//        animalButtonContainer = new JPanel();
//        animalButtonContainer.setBackground(Color.blue);
        dataStructureDemoContainer = new JPanel();
        dataStructureDemoContainer.setBackground(Color.red);
//        menuContainer = new JPanel();
//        menuContainer.setBackground(Color.green);

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
        int numOfDemos = 1;
        Demo[] demos = new Demo[numOfDemos];

//      linked list show example(WIP)
        JPanel llPanel = new JPanel();
        llPanel.setBackground(Color.pink);
        LinkedListDemo llDemo = new LinkedListDemo(llPanel);
        demos[0] = llDemo;

        new MainGUI(width, height, mainGUIName, demos, animalButtonPanel, menuPanel);
    }
}
