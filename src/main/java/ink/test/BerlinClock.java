package ink.test;

import java.time.LocalTime;

/**
 *
 * @author Craig
 */
public class BerlinClock {

    private int secondsLight = 0;

    private int fiveHoursLights = 0;
    private int oneHourLights = 0;

    private int fiveMinutesLights = 0;
    private int oneMinuteLights = 0;

    public BerlinClock() {
    }

    public BerlinClock(LocalTime time) {
    }

    public void setTime(LocalTime time) {
    }

    public int getSecondsLight() {
        return secondsLight;
    }

    public int getFiveHoursLights() {
        return fiveHoursLights;
    }

    public int getOneHourLights() {
        return oneHourLights;
    }

    public int getFiveMinutesLights() {
        return fiveMinutesLights;
    }

    public int getOneMinuteLights() {
        return oneMinuteLights;
    }

    // Setters required for testing
    public BerlinClock withSecondsLight(int light) {
        if (light < 0 || light > 1) {
            throw new IllegalArgumentException("Second light may only take a value of 0 or 1");
        }
        secondsLight = light;
        return this;
    }

    public BerlinClock withFiveHoursLights(int lights) {
        if (lights < 0 || lights > 4) {
            throw new IllegalArgumentException("Second light may only take a value of 0 or 1");
        }
        fiveHoursLights = lights;
        return this;
    }

    public BerlinClock withOneHourLights(int lights) {
        if (lights < 0 || lights > 4) {
            throw new IllegalArgumentException("Second light may only take a value of 0 or 1");
        }
        oneHourLights = lights;
        return this;
    }

    public BerlinClock withFiveMinutesLights(int lights) {
        if (lights < 0 || lights > 11) {
            throw new IllegalArgumentException("Second light may only take a value of 0 or 1");
        }
        fiveMinutesLights = lights;
        return this;
    }

    public BerlinClock withOneMinuteLights(int lights) {
        if (lights < 0 || lights > 4) {
            throw new IllegalArgumentException("Second light may only take a value of 0 or 1");
        }
        oneMinuteLights = lights;
        return this;
    }

    // Auto-generated hashCode() method
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.secondsLight;
        hash = 37 * hash + this.fiveHoursLights;
        hash = 37 * hash + this.oneHourLights;
        hash = 37 * hash + this.fiveMinutesLights;
        hash = 37 * hash + this.oneMinuteLights;
        return hash;
    }

    // Auto-generated equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BerlinClock other = (BerlinClock) obj;
        if (this.secondsLight != other.secondsLight) {
            return false;
        }
        if (this.fiveHoursLights != other.fiveHoursLights) {
            return false;
        }
        if (this.oneHourLights != other.oneHourLights) {
            return false;
        }
        if (this.fiveMinutesLights != other.fiveMinutesLights) {
            return false;
        }
        if (this.oneMinuteLights != other.oneMinuteLights) {
            return false;
        }
        return true;
    }

}
