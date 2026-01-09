package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Parser;

import java.util.List;

public class InputView {

    private static final String CARS_INPUT = "경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)";

    private InputView(){}

    public static List<String> inputCars() {
        System.out.println(CARS_INPUT);
        String input = Console.readLine();

        return Parser.parseStrings(input);
    }
}
