/**
 * Will convert Java object into JSON format. Saves into file but does not load.
 *
 */

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class JSONDataStrategy implements AppDataStrategy {
    private final String dirPath2;
    private final String fileName2;

    public JSONDataStrategy(String delimiter, String dirPath, String fileName) {
        this.dirPath2 = dirPath;
        this.fileName2 = fileName;
    }

    @Override
    public void save(ArrayList<Animal> selectedAnimals) throws FileNotFoundException {
        String completeFilePathAndName2 = String.format("%s%s",this.dirPath2, this.fileName2);
        try (PrintWriter out = new PrintWriter(completeFilePathAndName2)) {
            for (Animal selectedAnimal : selectedAnimals) {
                String saveFormat = String.format("%s,", selectedAnimal.getClass().getName());

                //convert java object to JSON format
                Gson gson = new Gson();
                String json = gson.toJson(saveFormat);
                out.println(json);
            }
        }
    }

    @Override
    public ArrayList<String> load(){
        return null;
    }

}