package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {}
    public static InputView create() {
        return new InputView();
    }

    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String userInput = Console.readLine();
        validateEmpty(userInput);
        return userInput;
    }

    private void validateEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
