package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Parser;
import racingcar.util.Validator;

import java.util.List;

public class InputView {

    private static final String CARS_INPUT = "경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static List<String> inputCars() {
        System.out.println(CARS_INPUT);
        String input = Console.readLine();

        return Parser.parseStrings(input);
    }

    public static int inputTryCount() {
        System.out.println(TRY_COUNT_INPUT);
        String input = Console.readLine();

        Validator.validateEmptyInput(input);
        Validator.validateNumberFormat(input);

        int count = Integer.parseInt(input);
        Validator.validatePositive(count);

        return count;
    }
}
