import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void save(ArrayList<Animal> selectedAnimals) {
        String delimiter = ",";
        String fileName = "file.txt";
        String filePath = "./src/assets/saves/";
        String completeFilePathAndName = String.format("%s%s",filePath, fileName);
        try (PrintWriter out = new PrintWriter(completeFilePathAndName)) {
            for (Animal selectedAnimal : selectedAnimals) {
                String saveFormat = String.format("%s,", selectedAnimal.getClass().getName());
                out.print(saveFormat);
            }

        } catch (FileNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

    public ArrayList<String> load() {
        ArrayList<String> animalsToLoad = new ArrayList<>();
        String delimiter = ",";
        String fileName = "file.txt";
        String filePath = "./src/assets/saves/";
        String completeFilePathAndName = String.format("%s%s",filePath, fileName);
        File inputFile = new File(completeFilePathAndName);
        try (Scanner in = new Scanner(inputFile)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                Scanner lineReader = new Scanner(line);
                lineReader.useDelimiter(delimiter);
                while (lineReader.hasNext()) {
                    String animalClassName = lineReader.next();
                    animalsToLoad.add(animalClassName);
                }
            }
        } catch (FileNotFoundException e) {
            throw  new RuntimeException(e);
        }
        return animalsToLoad;
    }
}
