import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI {
    private JFrame mainFrame;
    private final int height;
    private final int width;
    private String jFrameName;

    public MainGUI(int width, int height, String frameName) {
        this.width = width;
        this.height = height;
        jFrameName = frameName;
        initJFrame();
        mainFrame.setVisible(true);
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public String getJFrameName() { return jFrameName; }

    public void setJFrameName(String name) {
        jFrameName = name;
    }

    private void initJFrame() {
        mainFrame = new JFrame(jFrameName);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        mainFrame.setSize(this.width, this.height);
    }

    public static void main(String[] args) {
        int height = 700;
        int width = 700;
        String mainGUIName = "Zoo";

        new MainGUI(width, height, mainGUIName);
    }
}
