package ink.test;

import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Craig
 */
public class OutputTest {

    @Test
    public void testConvertClockToString_1() {
        String expected = "  .\nR...\nRRRR\n----\nYYRYYRYYRY.\nRRRR";

        LocalTime time = LocalTime.of(9, 54, 50);
        BerlinClock clock = new BerlinClock(time);
        String result = Output.convertClockToString(clock);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testConvertClockToString_2() {
        String expected = "  Y\nRRR.\nR...\n----\nYYR........\nRRR.";

        LocalTime time = LocalTime.of(16, 18, 33);
        BerlinClock clock = new BerlinClock(time);
        String result = Output.convertClockToString(clock);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testConvertClockToString_max() {
        String expected = "  .\nRRRR\nRRRR\n----\nYYRYYRYYRYY\nRRRR";

        LocalTime time = LocalTime.of(23, 59, 59);
        BerlinClock clock = new BerlinClock(time);
        String result = Output.convertClockToString(clock);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testConvertClockToString_min() {
        String expected = "  Y\n....\n....\n----\n...........\n....";

        LocalTime time = LocalTime.of(0, 0, 0);
        BerlinClock clock = new BerlinClock(time);
        String result = Output.convertClockToString(clock);

        Assert.assertEquals(expected, result);
    }

}
