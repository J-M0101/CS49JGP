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

weightComparator

* Comparator that will sort animals by smallest to biggest based on weight. Used in PriorityQueueDemo.
  
  Compare: compares two animal’s weights and sorts them from smallest to biggest

PriorityQueueDemo

* Priority Queue that sorts animals based on weight. The smallest animal will
* enter the list first and be the first one to be shown in GUI.
  Priority Queue Demo: Sets up panel in GUI and creates priority queue sorted by weight from smallest to largest
  nextAnimal: Shows animals selected in GUI, retrieves and removes the first element of the queue which is the smallest animal that is already sorted.
  updateLabelAnimal: sets text box and animal image on GUI which shows the species name and weight.
  arrayToPriorityQueue: adds selected animals to priority queue
  play: starts retrieving selected animals in order when pressing the next button.

App

* Main class that runs the GUI program. Has GO, SAVE, and LOAD buttons that shows animals selected in
* a linked list, stack, and priority queue. Title has your random farm ID and shows the total weight of all animals in farm using recursion.
  */
  sumOfWeight: adds entire weight of all animals in farm and displays the weight on the title
  Main: runs entire project. Shows random farm ID along with total weight on title. Has buttons for each animal to be selected along with the go,save,load buttons. Save button will save animals selected in a file which can then be loaded and played on GUI.

JSONDataStrategy

* Will convert Java object into JSON format. Saves into file but does not load.
  Save: Saves file as JSON format
  */

menuComponent
Builds the Go, Save, Load buttons on GUI
saves
animals selected can be saved and catches errors
Load
Animals that were saved are loaded and catches errors

