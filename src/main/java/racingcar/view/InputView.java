package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_NUM = "시도할 횟수는 몇 회인가요?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String userInput = Console.readLine();

        validateEmpty(userInput);

        return userInput;
    }

    public Long inputRoundNum() {
        System.out.println(INPUT_ROUND_NUM);
        String userInput = Console.readLine();

        validateEmpty(userInput);
        validateNumberPattern(userInput);

        Long roundNum = Long.valueOf(userInput);
        validatePositive(roundNum);

        return roundNum;
    }

    private void validateEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberPattern(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositive(Long roundNum) {
        if (roundNum <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
