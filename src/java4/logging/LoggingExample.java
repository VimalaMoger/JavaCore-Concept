package java4.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {

    private static final Logger logger =
            Logger.getLogger(LoggingExample.class.getName());

    // ANSI escape code
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public void doIt() {
        logger.entering(getClass().getName(), "doIt");

        try{
            int a=6, b=0;
           int z = a/b;
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Error operating  a/b", e);
        }

        logger.exiting(getClass().getName(), "doIt");
    }
    public static void main(String[] args) {
        logger.info(ANSI_BLUE +"Logging an INFO-level message");
    }

}
