package fr.polytech.sim.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDecorator implements Logger {
    private Logger logger;

    public TimeDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String format, Object... args) {
        // Get current timestamp
        String timestamp = getCurrentTimestamp();

        // Format log message
        String message = String.format("[%s] %s", timestamp, String.format(format, args));

        // Delegate log to the wrapped logger
        logger.log(message);
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}