package ink.test;

import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Craig
 */
public class BerlinClockTest {

    @Test
    public void testSetTime_1() {
        LocalTime time = LocalTime.of(9, 54, 50);
        BerlinClock result = new BerlinClock();
        result.setTime(time);

        // Example conflicts with specification. Have chosen to follow
        // specification with regards to the second light being lit.
        BerlinClock expected = new BerlinClock()
                .withSecondsLight(1)
                .withFiveHoursLights(1)
                .withOneHourLights(4)
                .withFiveMinutesLights(10)
                .withOneMinuteLights(4);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetTime_2() {
        LocalTime time = LocalTime.of(16, 18, 33);
        BerlinClock result = new BerlinClock();
        result.setTime(time);

        // Example conflicts with specification. Have chosen to follow
        // specification with regards to the second light being lit.
        BerlinClock expected = new BerlinClock()
                .withSecondsLight(0)
                .withFiveHoursLights(3)
                .withOneHourLights(1)
                .withFiveMinutesLights(3)
                .withOneMinuteLights(3);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetTime_max() {
        LocalTime time = LocalTime.of(23, 59, 59);
        BerlinClock result = new BerlinClock();
        result.setTime(time);

        BerlinClock expected = new BerlinClock()
                .withSecondsLight(0)
                .withFiveHoursLights(4)
                .withOneHourLights(3)
                .withFiveMinutesLights(11)
                .withOneMinuteLights(4);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetTime_min() {
        LocalTime time = LocalTime.of(0, 0, 0);
        BerlinClock result = new BerlinClock();
        result.setTime(time);

        BerlinClock expected = new BerlinClock()
                .withSecondsLight(1)
                .withFiveHoursLights(0)
                .withOneHourLights(0)
                .withFiveMinutesLights(0)
                .withOneMinuteLights(0);

        Assert.assertEquals(expected, result);
    }

}
