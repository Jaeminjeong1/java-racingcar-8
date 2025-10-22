package racingcar.view;

public class OutputView {

    private static final String RACE_START = "실행 결과";

    private OutputView() {}
    public static OutputView create() {
        return new OutputView();
    }

    public void printRaceStart() {
        System.out.println();
        System.out.println(RACE_START);
    }
}
