package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public class Clock {

    private static Clock instance;

    // Rend le constructeur privé pour que personne ne puisse l'appeler
    private Clock() {}

    // Méthode statique pour récupérer l'instance unique
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }
    private final int time = new Random().nextInt(25);
    /**
     * Random integer between 0 and 24 inclusive.
     */
    public int getTime() {
        return this.time;
    }


}
