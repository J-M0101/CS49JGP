import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo extends Demo {
    private LinkedList<Animal> animalDoublyLinkedList;
    private ListIterator<Animal> llIterator;
    private JButton previousBtn;
    private JButton nextBtn;
    private JLabel animalLabel;

    public LinkedListDemo(JPanel panel) {
        super(panel);
        animalLabel = new JLabel();

        animalDoublyLinkedList = new LinkedList<>();
        initButtons();
    }

    public void addAnimal(Animal animal) {
        animalDoublyLinkedList.add(animal);
    }

    private JLabel createAnimalLabel(Animal animal) {
        return new JLabel(animal.getSpecies());
    }

    private void initButtons() {
        previousBtn = new JButton("Previous");
        nextBtn = new JButton("Next");

        previousBtn.addActionListener(this::previousAnimal);
        nextBtn.addActionListener(this::nextAnimal);
    }

    private void nextAnimal(ActionEvent e) {
        if (llIterator.hasNext()) {
            Animal currentAnimal = llIterator.next();
            animalLabel.setText(currentAnimal.getSpecies());
        }
    }
    private void previousAnimal(ActionEvent e) {
        if (llIterator.hasPrevious()) {
            Animal currentAnimal = llIterator.previous();
            animalLabel.setText(currentAnimal.getSpecies());
        }
    }


    @Override
    void play() {
        Animal currAnimalLabel = animalDoublyLinkedList.getFirst();
//        JLabel aniLabel = createAnimalLabel(currAnimalLabel);
        llIterator = animalDoublyLinkedList.listIterator();
        animalLabel.setText(currAnimalLabel.getSpecies());
        getGUIContainer().setLayout(new BorderLayout());
        getGUIContainer().add(previousBtn, BorderLayout.LINE_START);
        getGUIContainer().add(animalLabel, BorderLayout.CENTER);
        getGUIContainer().add(nextBtn, BorderLayout.LINE_END);
    }
}
