package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DELIMITER = ",";

    private Parser() {
    }

    // List<String> 반환
    public static List<String> parseStrings(String input) {
        validateInput(input);

        List<String> tokens = splitAndTrim(input);

        validateTokens(tokens);

        return tokens;
    }

    // List<Integer>로 반환
    public static List<Integer> parseIntegers(String input) {
        validateInput(input);

        List<String> tokens = splitAndTrim(input);

        validateTokens(tokens);
        validateTokensNumberFormat(tokens);

        return convertToIntegers(tokens);
    }

    private static List<String> splitAndTrim(String input) {
        return Arrays.stream(input.split(DELIMITER, -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateTokens(List<String> tokens) {
        for (String token : tokens) {
            if (token == null || token.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }


    // 각 토큰이 숫자형 인지 검증
    private static void validateTokensNumberFormat(List<String> tokens) {
        for (String token : tokens) {
            Validator.validateNumberFormat(token);
        }
    }

    private static List<Integer> convertToIntegers(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }
}

