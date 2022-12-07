/**
 * Main class that runs the GUI program. Has GO, SAVE, and LOAD buttons that shows animals selected in
 * a linked list, stack, and priority queue. Title has your random farm ID and shows the total weight of all animals
 * in farm using recursion.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class App {

    // Recursive method to show total zoo farm weight
    public static int sumOfWeight(int[] a, int n) {
        if (n == 0)
            return a[n];
        else
            return a[n] + sumOfWeight(a, n - 1);
    }

    public static void main(String[] args) {
        int height = 1000;
        int width = 1000;
        // generates a random farm ID
        Random rand = new Random();
        int random_int = rand.nextInt(1000);

        String chickenImgPath = "./src/assets/images/chicken.jpg";
        String anotherImg = "./src/assets/images/Babirusa.jpg";
        String catImgPath = "./src/assets/images/cat.jpg";
        String pandaImgPath = "./src/assets/images/panda.jpg";


//      animals that will be used when displaying data structures
        Chicken aChicken = new Chicken("Gallus gallus 00", 13, chickenImgPath);
        Babirusa aBabirusa = new Babirusa("An Indonesian Island swamp pig", 230, anotherImg);
        Cat aCat = new Cat("Felis catus", 10, catImgPath);
        Panda aPanda = new Panda("Ailuropoda melanoleuca", 250, pandaImgPath);

        // Weight of each animal to pass in recursive method
        int[] a = {aChicken.getWeight(),aBabirusa.getWeight(), aCat.getWeight(), aPanda.getWeight()};
        int sum = sumOfWeight(a, a.length-1);

        String mainGUIName = "Your farm ID is: " + random_int + "... Welcome to the zoo farm. Total animal weight is "
                + sum + "lbs.";



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
        int numOfDemos = 3;
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

        // Priority Queue show example
        JPanel pqPanel0 = new JPanel();
        pqPanel0.setBackground(Color.green);
        PriorityQueueDemo pqDemo = new PriorityQueueDemo(pqPanel0);

        demos[2] = pqDemo;

        MainGUI gui = new MainGUI(width, height, mainGUIName, demos, animalButtons, menu);

    }

}
