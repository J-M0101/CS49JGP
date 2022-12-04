import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int height = 1000;
        int width = 1000;
        String mainGUIName = "Zoo";
        String chickenImgPath = "./src/assets/images/chicken.jpg";
        String anotherImg = "./src/assets/images/chicken.jpg";
        String catImgPath = "./src/assets/images/cat.jpg";
        String pandaImgPath = "./src/assets/images/panda.jpg";


//      animals that will be used when displaying data structures
        Chicken aChicken = new Chicken("Gallus gallus 00", 13, chickenImgPath);
        Babirusa aBabirusa = new Babirusa("An Indonesian Island swamp pig", 130, anotherImg);
        Cat aCat = new Cat("Felis catus", 10, catImgPath);
        Panda aPanda = new Panda("Ailuropoda melanoleuca", 250, pandaImgPath);


//      panel for the animal button section
        JPanel animalButtonPanel = new JPanel();
        Color selectedAnimalButtonColor = Color.green;
        animalButtonPanel.setLayout(new BoxLayout(animalButtonPanel, BoxLayout.Y_AXIS));
//        animalButtonPanel.setBackground(Color.blue);
        AnimalButtonComponent animalButtons = new AnimalButtonComponent(animalButtonPanel, 10, selectedAnimalButtonColor);
        animalButtons.addAnimal(aBabirusa);
        animalButtons.addAnimal(aChicken);
        animalButtons.addAnimal(aCat);
        animalButtons.addAnimal(aPanda);

//      save/load arguments
        String delimiter = ",";
        String fileName = "file.txt";
        String dirPath = "./src/assets/saves/";
        AppDataStrategy saveLoadStrategy = new TextDataStrategy(delimiter, dirPath, fileName);
//      panel for menu button section
        JPanel menuPanel = new JPanel();
        MenuComponent menu = new MenuComponent(menuPanel, saveLoadStrategy);

//      set up demo stuff for the show DS section
        int numOfDemos = 2;
        Demo[] demos = new Demo[numOfDemos];

//      linked list show example
        JPanel llPanel0 = new JPanel();
        llPanel0.setBackground(Color.yellow);
        LinkedListDemo llDemo = new LinkedListDemo(llPanel0);

        demos[0] = llDemo;

//      Testing adding another LL demo
        JPanel SPanel0 = new JPanel();
        SPanel0.setBackground(Color.white);
        StackDemo SPanel = new StackDemo(SPanel0);

        demos[1] = SPanel;

        MainGUI gui = new MainGUI(width, height, mainGUIName, demos, animalButtons, menu);

//      generates a random farm ID
        Random rand = new Random();
        int random_int = rand.nextInt(1000);
        System.out.println("Your farm ID is: " + random_int);
    }
}
