import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;


public class PriorityQueueDemo extends Demo implements Comparator <Animal>
{
    private final PriorityQueue<Animal> animalPriorityQueue;
    private final JButton nextBtn;
    private final JLabel animalLabel;
    private void setupButtonsListeners() {
        nextBtn.addActionListener(this::nextAnimal);
    }
    private ImageIcon createImageIcon(String imgPath) {
        return new ImageIcon(imgPath);
    }

    public PriorityQueueDemo(JPanel panel)
    {
        super(panel);
        animalPriorityQueue = new PriorityQueue<>();
        nextBtn = new JButton("Next");
        animalLabel = new JLabel();
        animalLabel.setHorizontalTextPosition(JLabel.CENTER);
        animalLabel.setVerticalTextPosition(JLabel.NORTH);
        setupButtonsListeners();
    }

    private void nextAnimal(ActionEvent e)
    {
        if(!animalPriorityQueue.isEmpty())
        {
            updateLabelAnimal(animalPriorityQueue.peek());
        }
        else
        {
            setHasCompleted(true);
        }
    }

    private void updateLabelAnimal(Animal animal) {
        animalLabel.setText(animal.getSpecies());
        animalLabel.setIcon(createImageIcon(animal.getImgPath()));
    }

    private void ArrayToPriorityQueue(ArrayList<Animal> selectedAnimals)
    {
        for (Animal animal : selectedAnimals) {
            animalPriorityQueue.add(animal);
        }
    }

    @Override
    void play(ArrayList<Animal> selectedAnimals)
    {
        this.ArrayToPriorityQueue(selectedAnimals);
        Animal PresentAnimal = animalPriorityQueue.peek();
        updateLabelAnimal(PresentAnimal);
        getGUIContainer().setLayout(new BorderLayout());
        getGUIContainer().add(animalLabel, BorderLayout.CENTER);
        getGUIContainer().add(nextBtn, BorderLayout.PAGE_END);
        getGUIContainer().revalidate();
        getGUIContainer().repaint();

    }

    // Compare weight of animals from lowest to highest.
    @Override
    public int compare(Animal o1, Animal o2)
    {
        if (o1.getWeight() != o2.getWeight())
            return o1.getWeight() - o2.getWeight();
        else
            return o1.getSpecies().compareTo(o2.getSpecies());
    }

}