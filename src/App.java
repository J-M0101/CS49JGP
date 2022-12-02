import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        int height = 1000;
        int width = 1000;
        String mainGUIName = "Zoo";
        String chickenImgPath = "./src/assets/images/chicken.jpg";

//      panel for the animal button section
        JPanel animalButtonPanel = new JPanel();
        animalButtonPanel.setBackground(Color.blue);

//      panel for menu button section
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.green);

//      set up demo stuff for the show DS section
        int numOfDemos = 2;
        Demo[] demos = new Demo[numOfDemos];

//      linked list show example(WIP)
        JPanel llPanel0 = new JPanel();
        llPanel0.setBackground(Color.yellow);
        LinkedListDemo llDemo = new LinkedListDemo(llPanel0);
        Chicken aChicken0 = new Chicken("Gallus gallus 00", 13, chickenImgPath);
        Chicken aChicken1 = new Chicken("Gallus gallus 01", 13, chickenImgPath);
        Chicken aChicken2 = new Chicken("Gallus gallus 02", 13, chickenImgPath);
        Chicken aChicken3 = new Chicken("Gallus gallus 03", 13, chickenImgPath);
        Chicken aChicken4 = new Chicken("Gallus gallus 04", 13, chickenImgPath);

        llDemo.addAnimal(aChicken0);
        llDemo.addAnimal(aChicken1);
        llDemo.addAnimal(aChicken2);
        llDemo.addAnimal(aChicken3);
        llDemo.addAnimal(aChicken4);

        demos[0] = llDemo;

//      Testing adding another LL demo
        JPanel llPanel1 = new JPanel();
        llPanel1.setBackground(Color.magenta);
        LinkedListDemo llDemo2 = new LinkedListDemo(llPanel1);
        Chicken aChicken5 = new Chicken("LLDemo2: chicken5", 13, chickenImgPath);
        Chicken aChicken6 = new Chicken("LLDemo2: chicken6", 13, chickenImgPath);

        llDemo2.addAnimal(aChicken5);
        llDemo2.addAnimal(aChicken6);

        demos[1] = llDemo2;

        MainGUI gui = new MainGUI(width, height, mainGUIName, demos, animalButtonPanel, menuPanel);

//      Testing playing the Demos since no "Go" button has be implemented
        gui.playDemos();
    }
}
