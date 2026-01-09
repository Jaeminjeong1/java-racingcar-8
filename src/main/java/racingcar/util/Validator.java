package racingcar.util;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
    private static final int MIN_NUM = 1; // 수정
    private static final int MAX_NUM = 10; // 수정

    private Validator() {
    }

    // 빈값 검증
    public static void validateEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    // 숫자 형식 검증
    public static void validateNumberFormat(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    // 양수인지 검증
    public static void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    // 값 범위 검증
    public static void validateRange(int value) {
        if (value < MIN_NUM || value > MAX_NUM) {
            throw new IllegalArgumentException();
        }
    }
}

