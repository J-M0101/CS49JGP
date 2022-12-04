import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
        finishedBtn = new JButton("Finish");
        previousBtn = new JButton("Previous");
        nextBtn = new JButton("Next");
        animalLabel = new JLabel();
        animalDoublyLinkedList = new LinkedList<>();

        this.setupButtonsListeners();
        this.initGUI();
    }

    private void initGUI() {
        animalLabel.setHorizontalTextPosition(JLabel.CENTER);
        animalLabel.setVerticalTextPosition(JLabel.NORTH);
        getGUIContainer().setLayout(new BorderLayout());
        getGUIContainer().add(previousBtn, BorderLayout.LINE_START);
        getGUIContainer().add(animalLabel, BorderLayout.CENTER);
        getGUIContainer().add(nextBtn, BorderLayout.LINE_END);
        getGUIContainer().add(finishedBtn, BorderLayout.PAGE_END);
        getGUIContainer().revalidate();
        getGUIContainer().repaint();
    }

    public void addAnimal(Animal animal) {
        animalDoublyLinkedList.add(animal);
    }

    private void setupButtonsListeners() {
        finishedBtn.addActionListener(this::finishedDemo);
        previousBtn.addActionListener(this::previousAnimal);
        nextBtn.addActionListener(this::nextAnimal);
    }

    private void finishedDemo(ActionEvent e) {
        while (!this.animalDoublyLinkedList.isEmpty()) {
            this.animalDoublyLinkedList.pop();
        }
        this.llIterator = null;
        this.enableButtons();
        setHasCompleted(true);
    }

    private void nextAnimal(ActionEvent e) {
        if (llIterator.hasNext()) {
            previousBtn.setEnabled(true);
            Animal currentAnimal = llIterator.next();
            updateLabelAnimal(currentAnimal);
        }
        this.updateNextButtonEnable(this.llIterator.hasNext());
    }
    private void previousAnimal(ActionEvent e) {
        if (llIterator.hasPrevious()) {
            nextBtn.setEnabled(true);
            Animal currentAnimal = llIterator.previous();
            updateLabelAnimal(currentAnimal);
        }
        this.updatePreviousButtonEnable(this.llIterator.hasPrevious());
    }

    private void updateLabelAnimal(Animal animal) {
        animalLabel.setText(animal.getSpecies());
        animalLabel.setIcon(createImageIcon(animal.getImgPath()));
        getGUIContainer().revalidate();
        getGUIContainer().repaint();
    }

    private ImageIcon createImageIcon(String imgPath) {
        return new ImageIcon(imgPath);
    }

    private void prePlayDemo(ArrayList<Animal> selectedAnimals) {
        for (Animal selectedAnimal : selectedAnimals) {
            this.addAnimal(selectedAnimal);
        }
    }

    private void enableButtons() {
        this.nextBtn.setEnabled(true);
        this.previousBtn.setEnabled(true);
    }

    private void updateNextButtonEnable(boolean isEnabled) {
        this.nextBtn.setEnabled(isEnabled);
    }
    private void updatePreviousButtonEnable(boolean isEnabled) {
        this.previousBtn.setEnabled(isEnabled);
    }

    private void setupFirstAnimal() {
        if (this.animalDoublyLinkedList.isEmpty()) {
            this.animalLabel.setText("No animal selected...");
        } else {
            Animal currAnimalLabel = this.llIterator.next();
            updateLabelAnimal(currAnimalLabel);
            this.updateNextButtonEnable(this.llIterator.hasNext());
            this.updatePreviousButtonEnable(false);
        }
    }

    @Override
    void play(ArrayList<Animal> selectedAnimals) {
        this.prePlayDemo(selectedAnimals);
        this.llIterator = animalDoublyLinkedList.listIterator();
        this.setupFirstAnimal();
    }
}
