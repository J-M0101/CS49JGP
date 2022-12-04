import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextDataStrategy implements AppDataStrategy {
    private String delimiter;
    private String dirPath;
    private String fileName;

    public TextDataStrategy(String delimiter, String dirPath, String fileName) {
        this.delimiter = delimiter;
        this.dirPath = dirPath;
        this.fileName = fileName;
    }

    @Override
    public void save(ArrayList<Animal> selectedAnimals) throws FileNotFoundException {
        String completeFilePathAndName = String.format("%s%s",this.dirPath, this.fileName);
        try (PrintWriter out = new PrintWriter(completeFilePathAndName)) {
            for (Animal selectedAnimal : selectedAnimals) {
                String saveFormat = String.format("%s,", selectedAnimal.getClass().getName());
                out.print(saveFormat);
            }
        }
    }

    @Override
    public ArrayList<String> load() throws FileNotFoundException {
        ArrayList<String> animalsToLoad = new ArrayList<>();
        String completeFilePathAndName = String.format("%s%s",this.dirPath, this.fileName);
        File inputFile = new File(completeFilePathAndName);
        try (Scanner in = new Scanner(inputFile)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                Scanner lineReader = new Scanner(line);
                lineReader.useDelimiter(this.delimiter);
                while (lineReader.hasNext()) {
                    String animalClassName = lineReader.next();
                    animalsToLoad.add(animalClassName);
                }
            }
        }
        return animalsToLoad;
    }
}
