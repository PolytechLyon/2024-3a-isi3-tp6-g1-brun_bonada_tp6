package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.FactoryLogger;
import fr.polytech.sim.log.FileLogger;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.utils.Context;

import java.util.Iterator;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = FactoryLogger.createLogger("BikeSimulator");

    public void run() {

        Iterator<Bike> bikes = Context.injectAll(Bike.class);
        while (bikes.hasNext()) {
            Bike bike = bikes.next();
            System.out.println("Simulating " + bike.getClass().getSimpleName());
            this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
            this.logger.log("Bike's mass %.2f Kg.", bike.getMass());
        }

    }
}
