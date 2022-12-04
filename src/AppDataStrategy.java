import java.util.ArrayList;

public interface AppDataStrategy {
    public void save(ArrayList<Animal> selectedAnimals);
    public ArrayList<String> load();
}
