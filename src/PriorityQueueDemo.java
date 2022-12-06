import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;


public class PriorityQueueDemo extends Demo
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
        animalPriorityQueue = new PriorityQueue<>(new weightComparator());
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
            updateLabelAnimal(animalPriorityQueue.poll());
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
        animalPriorityQueue.addAll(selectedAnimals);
    }

    @Override
    void play(ArrayList<Animal> selectedAnimals)
    {
        this.ArrayToPriorityQueue(selectedAnimals);
        Animal PresentAnimal = animalPriorityQueue.poll();
        updateLabelAnimal(PresentAnimal);
        getGUIContainer().setLayout(new BorderLayout());
        getGUIContainer().add(animalLabel, BorderLayout.CENTER);
        getGUIContainer().add(nextBtn, BorderLayout.PAGE_END);
        getGUIContainer().revalidate();
        getGUIContainer().repaint();

    }


}