package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {

    private static final String RACE_START = "실행 결과";
    private static final String DISTANCE_SYMBOL = "-";

    private OutputView() {}
    public static OutputView create() {
        return new OutputView();
    }

    public void printRaceStart() {
        System.out.println();
        System.out.println(RACE_START);
    }

    public void printOneRound(List<RacingCar> carList) {
        for (RacingCar racingCar : carList) {
            System.out.println(racingCar.getCarName() + " : " + printDistance(racingCar.getDistance()));
        }
        System.out.println();
    }

    public String printDistance(Long distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(DISTANCE_SYMBOL);
        }
        return sb.toString();
    }
}
