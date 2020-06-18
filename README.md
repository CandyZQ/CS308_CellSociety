simulation
====

This project implements a cellular automata simulator.
> This is the link to the [assignment](http://www.cs.duke.edu/courses/compsci308/current/assign/02_simulation/)

Names: 
- Hannah Taubenfeld
- Tharun Mani Raj
- Cady Zhou

### Timeline

Start Date: 1/26/20

Finish Date: 2/9/20

Hours Spent: 14+ each

### Primary Roles

 * Hannah Taubenfeld
     - Implement ```ca.view.Main.java```, ```ca.view.GridPaneHandler.java```, ```ca.view.Styler.java```, ```ca.view.XMLReader.java```, 
     ```ca.view.GraphHandler.java```, ```ca.view.SimulationView.java```
     - Implement Segregation and Percolation and Spreading of Fire ca.model.Simulation classes

 * Tharun Mani Raj
     - Implement ```ca.model.Cell.java```, ```ca.model.Grid.java```,```ca.model.GridBase.java```, and ```ca.model.Pair.java```
     - Implement WaTorWorld and LangtonLoop ca.model.Simulation classes

 * Cady Zhou
      - Implement ```ca.controller.Controller.java```, ```ca.controller.SimulationType.java```, ```ca.controller.InitialStateHandler.java```,
       ```ca.controller.GridStatus.java```, ```ca.view.SimulationView.java```, ```ca.simulation.Simulations.java```,
       ```ca.helpers.NeighboringType.java```,  ```ca.helpers.NeighboringHelper.java``` and ```ca.controller.SimulationConfig.java```
     - Implement Game of Life and Segregation ca.model.Simulation classes


### Resources Used

- https://www2.cs.duke.edu/courses/spring20/compsci308/
- https://coursework.cs.duke.edu/compsci308_2020spring/lab_browser


### Running the Program

Main class:

- Sets stage
- Interacts with SimulationView to read in XML file from file chooser, create simulation instances, create the grid and 
graph, and return other important values from simulation config
- Sets scene
- Calls Grid class to create a grid
- Creates a GridPane and fills it will colors
- Creates a linechart / graph and displays it
- Creates/adds all necessary buttons as well as sliders
- Calls step function which updates the grid from Grid class then removes the gridpane and creates a new one, does the
same for the graph with the line chart

Data files needed: 

* GameOfLife
    - GameOfLife1.xml
    - grid_gol.txt
    - grid_gol1.txt
    - grid_gol2.txt
    - list_gol.txt
    - rand_gol.txt
    
* Percolation
    - Percolation1.xml
    - grid_perc.txt
    - list_perc.txt
    - rand_perc.txt
    
* Segregation
    - Segregation1.xml
    - grid_seg.txt
    - list_seg.txt
    - rand_seg.txt
    
* Spreading Of Fire
    - SpreadingOfFire.xml
    - grid_sof.txt
    - list_sof.txt
    - rand_sof.txt
    
* LangtonLoop
    - LangtonLoop1.xml
    - grid_ll1.txt
    
* WaTorWorld
    - WaTorWorld1.xml
    - grid_wtw.txt
    - list_wtw.txt
    - rand_wtw.txt
    
Features implemented:

- File chooser to select XML file at the beginning of the simulation
- Gridpane created with different colored cells that update at every step
- Start button to start the simulation
- Stop button to pause the simulation 
- Reload File button to select a new XML file 
- Step button to perform only one step of the simulation
- Textfile and submit button to speed up the step of the simulation
- A Run Another Simulation button which enables the user to load another simulation and run it simultaneously.
- The feature to click on cells to change the cell states in realtime.
- Graph with line chart where every line represents a different state and quantity of that state at a given step
- Ability for the user to interact and choose the size of the grid (number of rows and columns) after the simulation has
already begun
- Ability for the user to run multiple simulations at once
- Error checking for incorrect data file 
- Ability to allow simulations to be set by a specific grid, a list, or randomly
- Started implementing different arrangement of neighbors and the different location shapes, but only completed for square
and no UI to go with it

### Notes/Assumptions

Assumptions or Simplifications:

- There will always be an XML file with a corresponding text file to read in the initial states
- The numbers or states used in the text file correspond to those specified in the simulation code
- The grid size will never exceed that of the scene size 
- For the segregation simulation, the percent that makes an agent satisfied will be hardcoded into the simulation. This
way, the user cannot change the number nor update it. 
- The only shapes that the grid will be are triangles, hexagons, and squares.

Interesting data files:

- We used a simulation template that we all followed

Known Bugs:

- A bug appears when you run the simulation and the file chooser appears, however, the simulation still 
runs and uses the XML file chosen
- When the step speed gets too high, there is a lag

Extra credit:

- n/a

### Impressions

- It can be difficult when working together when it comes to merging all the code and fixing bugs. 
Although at the beginning as we all worked on different parts and then merged together it was easy, once you 
go back and make smaller changes you have to be careful of merge conflicts. Otherwise, teammates end up with
different code which can lead to even more issues. 
- Once one simulation is up and running, it is easy to debug and create other simulations. By following a similar format
and just changing the rules for how a state is determined, the rest is already all figured out. 
- Adding new features requires the entire team to work together as some parts cross over into other sections. In this way, 
communication is more important than ever!

