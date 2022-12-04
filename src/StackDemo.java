import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Stack;

public class StackDemo extends Demo {

    private final Stack<Animal> animalStack;
    private JButton nextBtn;
    private final JLabel animalLabel;

    private void setupButtonsListeners() {
        nextBtn.addActionListener(this::nextAnimal);
    }

    private void nextAnimal(ActionEvent e) {
        if(!animalStack.empty()){
            updateLabelAnimal(animalStack.pop());
        }
        else{
            setHasCompleted(true);
        }
        
    }

    public StackDemo(JPanel panel) {
        super(panel);
        animalStack = new Stack<>();
        nextBtn = new JButton("Next");
        animalLabel = new JLabel();
        animalLabel.setHorizontalTextPosition(JLabel.CENTER);
        animalLabel.setVerticalTextPosition(JLabel.NORTH);
        setupButtonsListeners();
    }

    private void updateLabelAnimal(Animal animal) {
        animalLabel.setText(animal.getSpecies());
        animalLabel.setIcon(createImageIcon(animal.getImgPath()));
    }

    private ImageIcon createImageIcon(String imgPath) {
        return new ImageIcon(imgPath);
    }

    private void ArrayToStack(ArrayList<Animal> selectedAnimals) {
        for (Animal an : selectedAnimals) {
            animalStack.push(an);
        }
    }

    @Override
    void play(ArrayList<Animal> selectedAnimals) {
        //This will be called to push animals onto stack
        this.ArrayToStack(selectedAnimals);
        Animal PresentAnimal = animalStack.pop();
        updateLabelAnimal(PresentAnimal);
        getGUIContainer().setLayout(new BorderLayout());
        getGUIContainer().add(animalLabel, BorderLayout.CENTER);
        getGUIContainer().add(nextBtn, BorderLayout.PAGE_END);
        getGUIContainer().revalidate();
        getGUIContainer().repaint();

    }

}