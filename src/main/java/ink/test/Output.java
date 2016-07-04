package ink.test;

/**
 *
 * @author Craig
 */
public class Output {

    public static void toCommandLine(BerlinClock clock) {
        String clockOutput = convertClockToString(clock);
        System.out.println(clockOutput);
    }

    protected static String convertClockToString(BerlinClock clock) {
        if (clock == null) {
            return null;
        }

        StringBuilder result = new StringBuilder()
                .append("  ");

        if (clock.getSecondsLight() == 0) {
            result.append('.');
        } else {
            result.append('Y');
        }

        result.append('\n')
                .append(fourValueLine(clock.getFiveHoursLights(), 'R'))
                .append('\n')
                .append(fourValueLine(clock.getOneHourLights(), 'R'))
                .append("\n----\n")
                .append(elevenValueLine(clock.getFiveMinutesLights()))
                .append('\n')
                .append(fourValueLine(clock.getOneMinuteLights(), 'Y'));

        return result.toString();
    }

    protected static String fourValueLine(int litNum, char lightColour) {
        if (litNum < 0 || litNum > 4) {
            throw new IllegalArgumentException("Number of lit lights must be between 0 and 4");
        }

        int unlitNum = 4 - litNum;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= litNum; i++) {
            result.append(lightColour);
        }
        for (int i = 0; i < unlitNum; i++) {
            result.append('.');
        }
        return result.toString();
    }

    protected static String elevenValueLine(int litNum) {
        if (litNum < 0 || litNum > 11) {
            throw new IllegalArgumentException("Number of lit lights must be between 0 and 11");
        }

        int unlitNum = 11 - litNum;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= litNum; i++) {
            if ((i % 3) == 0) {
                result.append('R');
            } else {
                result.append('Y');
            }
        }
        for (int i = 0; i < unlitNum; i++) {
            result.append('.');
        }
        return result.toString();
    }

}
