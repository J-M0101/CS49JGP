## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## Documentation
 StackDemo: A class that utilizes a Jpanel as the parameter to display a data structure . 
    - Has three private instance variables stack, button, and Jlabel. 
    - The constructor sets the attributes for the class. Sets a new Stack, Button, Label, and position in the GUI.
    - ArrayToStack takes in an ArrayList parameter and through a for loop will push each item into a stack data       structure.
    - Play is used to call all the different methods to display the data to the GUI.
Babirusa: Babirusa inherits from the animal class. 
MainGUI: A Class that creates the structure of the main GUI. Implements the PropertyChangeListener.
    - Has 9 private instance variables window, height, width, windowname, an array that will hold all the demos, buttons, and components. 
    - InitGUI: Initialize the whole root GUI
    - initWindow: Initialize GUI window
    - initDemosContainer: Initializations needed for container holding Demos in window
    - initContainers: initializes the window GUI structure layout sets the container section's dimensions
    - propertyChange: Logic to execute when registered property(s) have changed. As soon as a demo's hasCompleted status changes to true will remove it and add/play the next Demo.
    - playDemos: Starts playing all Demos from the start(index = 0)  once the user hits the "Go" button.
