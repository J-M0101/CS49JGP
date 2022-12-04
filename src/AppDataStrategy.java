import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface AppDataStrategy {
    public void save(ArrayList<Animal> selectedAnimals) throws FileNotFoundException;
    public ArrayList<String> load() throws FileNotFoundException;
}
