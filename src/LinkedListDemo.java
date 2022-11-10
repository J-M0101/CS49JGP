import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo extends Demo {
    private LinkedList<Animal> animalDoublyLinkedList;
    private ListIterator<Animal> llIterator;
    private JButton previousBtn;
    private JButton nextBtn;

    public LinkedListDemo(JPanel panel) {
        super(panel);

        animalDoublyLinkedList = new LinkedList<>();
        llIterator = animalDoublyLinkedList.listIterator();
    }

    public void addAnimal(Animal animal) {
        animalDoublyLinkedList.add(animal);
    }

    private JLabel createAnimalLabel(Animal animal) {
        return new JLabel(animal.getSpecies());
    }

    private void initBtn() {
        previousBtn = new JButton("Previous");
        nextBtn = new JButton("Next");

        previousBtn.addActionListener(this::nextAnimal);
    }

    private void nextAnimal(ActionEvent e) {

    }


    @Override
    void play() {
        Animal currAnimalLabel = animalDoublyLinkedList.getFirst();
        JLabel animalLabel = createAnimalLabel(currAnimalLabel);
        getJPanel().add(animalLabel);
    }
}
