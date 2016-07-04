package ink.test;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Craig
 */
public class Main {

    public static void main(String[] args) {
        LocalTime time = null;

        if (args != null && args[0] != null) {
            try {
                time = LocalTime.parse(args[0]);
            } catch (DateTimeParseException ex) {
                System.err.println("Provided time must conform to Java's DateTimeFormatter.ISO_LOCAL_TIME format");
                throw ex;
            }
        } else {
            time = LocalTime.now();
            System.out.println("No arguments provided, using current system time: " + time);
        }

        BerlinClock clock = new BerlinClock(time);
        Output.toCommandLine(clock);
    }

}
