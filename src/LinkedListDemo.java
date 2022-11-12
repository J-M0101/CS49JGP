import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo extends Demo {
    private final LinkedList<Animal> animalDoublyLinkedList;
    private ListIterator<Animal> llIterator;
    private JButton finishedBtn;
    private JButton previousBtn;
    private JButton nextBtn;
    private final JLabel animalLabel;

    public LinkedListDemo(JPanel panel) {
        super(panel);
        animalLabel = new JLabel();

        animalDoublyLinkedList = new LinkedList<>();
        initButtons();
    }

    public void addAnimal(Animal animal) {
        animalDoublyLinkedList.add(animal);
    }

    private void initButtons() {
        finishedBtn = new JButton("Finish");
        previousBtn = new JButton("Previous");
        nextBtn = new JButton("Next");

        finishedBtn.addActionListener(this::finishedDemo);
        previousBtn.addActionListener(this::previousAnimal);
        nextBtn.addActionListener(this::nextAnimal);
    }

    private void finishedDemo(ActionEvent e) {
        setHasCompleted(true);
    }

    private void nextAnimal(ActionEvent e) {
        if (llIterator.hasNext()) {
            previousBtn.setEnabled(true);
            Animal currentAnimal = llIterator.next();
            animalLabel.setText(currentAnimal.getSpecies());
        } else {
            nextBtn.setEnabled(false);
        }
    }
    private void previousAnimal(ActionEvent e) {
        if (llIterator.hasPrevious()) {
            nextBtn.setEnabled(true);
            Animal currentAnimal = llIterator.previous();
            animalLabel.setText(currentAnimal.getSpecies());
        } else {
            previousBtn.setEnabled(false);
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
        getGUIContainer().add(finishedBtn, BorderLayout.PAGE_END);
    }
}
