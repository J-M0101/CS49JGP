import javax.swing.*;

public class MenuComponent {
    private final JPanel guiContainer;
    private final JButton goBtn;
    private final JButton saveBtn;
    private final JButton loadBtn;

    public MenuComponent(JPanel guiContainer) {
        this.guiContainer = guiContainer;
        goBtn = new JButton("Go!");
        saveBtn = new JButton("save");
        loadBtn = new JButton("load");

        guiContainer.add(goBtn);
        guiContainer.add(saveBtn);
        guiContainer.add(loadBtn);
    }

    public JPanel getGuiContainer() {
        return guiContainer;
    }

    public JButton getGoBtn() {
        return goBtn;
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getLoadBtn() {
        return loadBtn;
    }
}
