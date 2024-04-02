package fr.polytech.sim.log;

public class FactoryLogger {


    public static ConsoleLogger createLogger(String name) {
        return new ConsoleLogger(name);
    }
}