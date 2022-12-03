import javax.swing.*;
import java.awt.*;

public class AnimalButton {
    private Animal animal;
    private boolean isSelected;
    private JButton animalButton;
    private Color selectedButtonColor;

    public AnimalButton(Animal animal, JButton animalButton, Color selectedButtonColor) {
        this.animal = animal;
        this.animalButton = animalButton;
        this.isSelected = false;
        this.selectedButtonColor = selectedButtonColor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public JButton getAnimalButton() {
        return animalButton;
    }

    public void updateButtonSelectionColor() {
        Color buttonColor = this.isSelected ? this.selectedButtonColor : UIManager.getColor("Button.background");
        this.animalButton.setBackground(buttonColor);
    }
    public boolean toggleSelectionState() {
        this.isSelected = !this.isSelected;
        this.updateButtonSelectionColor();
        return isSelected;
    }

}
