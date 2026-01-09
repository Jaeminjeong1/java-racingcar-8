package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public class OutputView {

    private static final String RESULT_INFO = "\n실행 결과";
    private static final String DISTANCE = "-";
    private static final String ROUND_RESULT = "%s : %s\n";
    private static final String WINNER_PRINT = "최종 우승자 : ";

    private OutputView() {
    }

    public static void printResultInfo() {
        System.out.println(RESULT_INFO);
    }

    public static void printRoundResult(List<CarDto> cars) {
        System.out.println();
        for (CarDto car : cars) {
            String name = car.name();
            int distance = car.distance();
            System.out.printf(ROUND_RESULT, name, switchResultFormat(distance));
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNER_PRINT + String.join(",", winners));
    }

    private static String switchResultFormat(int distance) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            result.append(DISTANCE);
        }

        return result.toString();
    }
}
