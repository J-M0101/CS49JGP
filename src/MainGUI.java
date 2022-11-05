import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI {
    private JFrame mainFrame;
    private final int height;
    private final int width;
    private String windowName;

    private Demo[] dataStructureDemos;

    public MainGUI(int width, int height, String frameName, int numOfDemos) {
        this.dataStructureDemos = new Demo[numOfDemos];
        this.width = width;
        this.height = height;
        windowName = frameName;
        initJFrame();
        initDemos();
    }

    private void initDemos() {
        JPanel llPanel = new JPanel();
        llPanel.setBackground(Color.blue);
        LinkedListDemo llDemo = new LinkedListDemo(llPanel);
        dataStructureDemos[0] = llDemo;
        mainFrame.add(llPanel);
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public String getJFrameName() { return windowName; }

    public void setJFrameName(String name) {
        windowName = name;
        updateJFrameWindowName();
    }

    private void updateJFrameWindowName() {
        mainFrame.setTitle(windowName);
    }

    private void initJFrame() {
        mainFrame = new JFrame(windowName);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        mainFrame.setSize(this.width, this.height);
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        int height = 1000;
        int width = 1000;
        int numOfDemos = 1;
        String mainGUIName = "Zoo";

        new MainGUI(width, height, mainGUIName, numOfDemos);
    }
}
