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

//      animals that will be used when displaying data structures
        Chicken aChicken = new Chicken("Gallus gallus 00", 13, chickenImgPath);
        Babirusa aBabirusa = new Babirusa("A PIG thing", 130, anotherImg);


//      panel for the animal button section
        JPanel animalButtonPanel = new JPanel();
        Color selectedAnimalButtonColor = Color.green;
        animalButtonPanel.setLayout(new BoxLayout(animalButtonPanel, BoxLayout.Y_AXIS));
//        animalButtonPanel.setBackground(Color.blue);
        AnimalButtonComponent animalButtons = new AnimalButtonComponent(animalButtonPanel, 10, selectedAnimalButtonColor);
        animalButtons.addAnimal(aBabirusa);
        animalButtons.addAnimal(aChicken);

//      panel for menu button section
        JPanel menuPanel = new JPanel();
//        menuPanel.setBackground(Color.green);
        MenuComponent menu = new MenuComponent(menuPanel);

//      set up demo stuff for the show DS section
        int numOfDemos = 2;
        Demo[] demos = new Demo[numOfDemos];

//      linked list show example
        JPanel llPanel0 = new JPanel();
        llPanel0.setBackground(Color.yellow);
        LinkedListDemo llDemo = new LinkedListDemo(llPanel0);

        demos[0] = llDemo;

//      Testing adding another LL demo
        JPanel llPanel1 = new JPanel();
        llPanel1.setBackground(Color.magenta);
        LinkedListDemo llDemo2 = new LinkedListDemo(llPanel1);

        demos[1] = llDemo2;

        MainGUI gui = new MainGUI(width, height, mainGUIName, demos, animalButtons, menu);

//      generates a random farm ID
        Random rand = new Random();
        int random_int = rand.nextInt(1000);
        System.out.println("Your farm ID is: " + random_int);
    }
}
