package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.FactoryLogger;
import fr.polytech.sim.log.FileLogger;
import fr.polytech.sim.log.Logger;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = FactoryLogger.createLogger("BikeSimulator");

    public void run() {
        Bike bike = new SimpleBike();
        this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
        this.logger.log("Bike's mass %.2f Kg.", bike.getMass());
    }
}
