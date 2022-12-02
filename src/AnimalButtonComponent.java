import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnimalButtonComponent {
    private JPanel guiContainer;
    private HashMap<String, Boolean> selectedAnimals;
    private HashMap<String, JButton> animalButtons;
    private HashMap<String, Animal> allAnimals;
    private int animalButtonVerticalSpacing;

    public AnimalButtonComponent(JPanel guiContainer, int animalButtonVerticalSpacing) {
        this.guiContainer = guiContainer;
        this.animalButtonVerticalSpacing = animalButtonVerticalSpacing;
        this.selectedAnimals = new HashMap<>();
        this.animalButtons = new HashMap<>();
        this.allAnimals = new HashMap<>();
    }

    public JPanel getGuiContainer() { return this.guiContainer; }

    public void onAnimalSelection(String animalName) {
        boolean toggledAnimalSelection = !this.selectedAnimals.get(animalName);
        this.selectedAnimals.put(animalName, toggledAnimalSelection);
    }

    public ArrayList<Animal> getSelectedAnimal() {
        ArrayList<Animal> selectedAnimals = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : this.selectedAnimals.entrySet()) {
            if (entry.getValue()) {
                selectedAnimals.add(this.allAnimals.get(entry.getKey()));
            }
        }
        return selectedAnimals;
    }

    private JButton createAnimalButton(Animal animal) {
        JButton animalButton = new JButton(animal.getClass().getName());
        animalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        animalButton.addActionListener(e -> {
            JButton clickedAnimalButton = (JButton)e.getSource();
            Color color = clickedAnimalButton.getBackground() != Color.green ? Color.green : UIManager.getColor("Button.background");
            clickedAnimalButton.setBackground(color);
            onAnimalSelection(clickedAnimalButton.getText());
        });
        return animalButton;
    }

    private void addAnimalButtonToGUI(JButton animalButton) {
        guiContainer.add(Box.createVerticalStrut(this.animalButtonVerticalSpacing));
        this.animalButtons.put(animalButton.getText(), animalButton);
        this.guiContainer.add(animalButton);
    }

    public void addAnimal(Animal animal) {
        if (animal != null && !this.selectedAnimals.containsKey(animal.getClass().getName())) {
            this.allAnimals.put(animal.getClass().getName(), animal);
            this.selectedAnimals.put(animal.getClass().getName(), false);
            JButton animalButton = this.createAnimalButton(animal);
            this.addAnimalButtonToGUI(animalButton);
        }
    }
}
