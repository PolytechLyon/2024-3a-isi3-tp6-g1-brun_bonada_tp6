package fr.polytech.sim.cycling;

import fr.polytech.sim.transport.Vehicle;
import fr.polytech.sim.transport.Wheel;

public class TagAlongBike extends SimpleBike {

    private SimpleBike childBike;

    public TagAlongBike(SimpleBike childBike) {
        this.childBike = childBike ;
        components.add(this.childBike);
    }
}
