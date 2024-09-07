package java4.logging;

import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {
    protected static final Logger logger = LogManager.getLogger("newLogs");

    public static void main(String[] args) {
        logger.log(Level.getLevel("VERBOSE"), "a verbose message ");
        logger.info("Info level log messages ");
    }
}
