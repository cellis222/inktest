package ink.test;

import java.time.format.DateTimeParseException;
import org.junit.Test;

/**
 *
 * @author Craig
 */
public class MainTest {

    @Test
    public void testMain_now() {
        System.out.println();
        System.out.println("Main test (no args):");
        Main.main(null);
    }

    @Test
    public void testMain_withTime1() {
        System.out.println();
        System.out.println("Main test (09:54:50):");
        String[] args = {"09:54:50"};
        Main.main(args);
    }

    @Test
    public void testMain_withTime2() {
        System.out.println();
        System.out.println("Main test (16:18:33):");
        String[] args = {"16:18:33"};
        Main.main(args);
    }

    @Test
    public void testMain_withTime3() {
        System.out.println();
        System.out.println("Main test (23:00):");
        String[] args = {"23:00"};
        Main.main(args);
    }

    @Test(expected = DateTimeParseException.class)
    public void testMain_invalid1() {
        System.out.println();
        System.out.println("Main test (26:00):");
        String[] args = {"26:00"};
        Main.main(args);
    }

    @Test(expected = DateTimeParseException.class)
    public void testMain_invalid2() {
        System.out.println();
        System.out.println("Main test (invalid):");
        String[] args = {"invalid"};
        Main.main(args);
    }

}
