import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MenuComponent {
    private final JPanel guiContainer;
    private final JButton goBtn;
    private final JButton saveBtn;
    private final JButton loadBtn;
    private final AppDataStrategy readWriteStrategy;

    public MenuComponent(JPanel guiContainer, AppDataStrategy saveLoadStrategy) {
        this.guiContainer = guiContainer;
        this.readWriteStrategy = saveLoadStrategy;
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

    public void save(ArrayList<Animal> selectedAnimals) {
        try {
        this.readWriteStrategy.save(selectedAnimals);
        } catch (FileNotFoundException e) {
            System.err.printf("Error: %s %n", e.getMessage());
            System.err.println("Confirm directory path shown exits");
        }
    }

    public ArrayList<String> load() {
        try {
            return this.readWriteStrategy.load();
        } catch (FileNotFoundException e) {
            System.err.printf("Error: %s %n", e.getMessage());
            System.err.println("Confirm directory path shown exits and make a save first...");
            return new ArrayList<>();
        }
    }
}
