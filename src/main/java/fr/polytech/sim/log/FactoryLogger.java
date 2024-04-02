package fr.polytech.sim.log;

public class FactoryLogger {


    public static TimeDecorator createLogger(String name) {
        return new TimeDecorator(new ConsoleLogger(name));
    }
}