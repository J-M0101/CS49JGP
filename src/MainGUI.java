import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI {
    private JFrame mainFrame;
    private final int height;
    private final int width;
    private String windowName;

    public MainGUI(int width, int height, String frameName) {
        this.width = width;
        this.height = height;
        windowName = frameName;
        initJFrame();
        mainFrame.setVisible(true);
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
    }

    public static void main(String[] args) {
        int height = 1000;
        int width = 1000;
        String mainGUIName = "Zoo";

        new MainGUI(width, height, mainGUIName);
    }
}
