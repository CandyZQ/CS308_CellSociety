import ca.controller.SimulationConfig;

import java.io.File;

public abstract class Simulation {
    Grid gameGrid;
    SimulationConfig simulationConfig;

    public Simulation(String simulationType) {
        simulationConfig = new SimulationConfig();
        File fileName = new File(simulationType);
        simulationConfig.readFile(fileName);
    }

    public abstract void runOneStep();

}
