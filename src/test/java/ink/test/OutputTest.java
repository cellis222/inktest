package ink.test;

import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Craig
 */
public class OutputTest {

    // Example conflicts with specification. Have chosen to follow
    // specification with regards to the colour of the last (one minute) line.

    @Test
    public void testConvertClockToString_1() {
        String expected = "  Y\nR...\nRRRR\n----\nYYRYYRYYRY.\nYYYY";

        LocalTime time = LocalTime.of(9, 54, 50);
        BerlinClock clock = new BerlinClock(time);
        String result = Output.convertClockToString(clock);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testConvertClockToString_2() {
        String expected = "  .\nRRR.\nR...\n----\nYYR........\nYYY.";

        LocalTime time = LocalTime.of(16, 18, 33);
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

    @Test
    public void testConvertClockToString_max() {
        String expected = "  .\nRRRR\nRRR.\n----\nYYRYYRYYRYY\nYYYY";

        LocalTime time = LocalTime.of(23, 59, 59);
        BerlinClock clock = new BerlinClock(time);
        String result = Output.convertClockToString(clock);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testConvertClockToString_null() {
        String result = Output.convertClockToString(null);

        Assert.assertEquals(null, result);
    }

    @Test
    public void testFourValueLine_min() {
        String expected = "....";
        String result = Output.fourValueLine(0, 'X');

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFourValueLine_max() {
        String expected = "XXXX";
        String result = Output.fourValueLine(4, 'X');

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFourValueLine_invalid() {
        Output.fourValueLine(5, 'X');
    }

    @Test
    public void testElevenValueLine_min() {
        String expected = "...........";
        String result = Output.elevenValueLine(0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testElevenValueLine_max() {
        String expected = "YYRYYRYYRYY";
        String result = Output.elevenValueLine(11);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testElevenValueLine_invalid() {
        Output.elevenValueLine(12);
    }

}
