import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnimalButtonComponent {
    private JPanel guiContainer;
    private HashMap<String, AnimalButton> allAnimalButtons;
    private int animalButtonVerticalSpacing;
    private Color selectedButtonColor;

    public AnimalButtonComponent(JPanel guiContainer, int animalButtonVerticalSpacing, Color selectedButtonColor) {
        this.guiContainer = guiContainer;
        this.animalButtonVerticalSpacing = animalButtonVerticalSpacing;
        this.selectedButtonColor = selectedButtonColor;
        this.allAnimalButtons = new HashMap<>();
    }

    public JPanel getGuiContainer() { return this.guiContainer; }

    public void onAnimalSelection(String animalName) {
        this.allAnimalButtons.get(animalName).toggleSelectionState();
    }

    public ArrayList<Animal> getSelectedAnimal() {
        ArrayList<Animal> selectedAnimals = new ArrayList<>();
        for (Map.Entry<String, AnimalButton> entry : this.allAnimalButtons.entrySet()) {
            if (entry.getValue().isSelected()) {
                selectedAnimals.add(entry.getValue().getAnimal());
            }
        }
        return selectedAnimals;
    }

    public void resetToDefaultState() {
        for (Map.Entry<String, AnimalButton> entry : this.allAnimalButtons.entrySet()) {
            entry.getValue().setSelected(false);
            entry.getValue().updateButtonSelectionColor();
        }
    }

    private JButton createAnimalButton(Animal animal) {
        JButton animalButton = new JButton(animal.getClass().getName());
        animalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        animalButton.addActionListener(e -> {
            JButton clickedAnimalButton = (JButton)e.getSource();
            Color color = clickedAnimalButton.getBackground() != this.selectedButtonColor ? this.selectedButtonColor : UIManager.getColor("Button.background");
            clickedAnimalButton.setBackground(color);
            onAnimalSelection(clickedAnimalButton.getText());
        });
        return animalButton;
    }

    private void addAnimalButtonToGUI(JButton animalButton) {
        guiContainer.add(Box.createVerticalStrut(this.animalButtonVerticalSpacing));
        this.guiContainer.add(animalButton);
    }

    public void addAnimal(Animal animal) {
        String animalClassName = animal.getClass().getName();
        if (animal != null && !this.allAnimalButtons.containsKey(animal.getClass().getName())) {
            JButton animalButton = this.createAnimalButton(animal);
            this.allAnimalButtons.put(animalClassName, new AnimalButton(animal, animalButton, this.selectedButtonColor));
            this.addAnimalButtonToGUI(animalButton);
        }
    }
}
