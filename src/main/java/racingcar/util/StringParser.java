package racingcar.util;

public class StringParser {

    private static final String DELIMITER = ",";

    private StringParser() {}

    public static String[] parse(String input) {
        return input.split(DELIMITER, -1);
    }
}
