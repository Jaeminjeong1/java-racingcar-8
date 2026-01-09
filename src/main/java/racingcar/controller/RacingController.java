package racingcar.controller;

import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void start() {
        // 경주할 자동차 입력받기
        // 자동차 생성
        List<String> carsInput = InputView.inputCars();
        List<Car> cars = racingService.setCars(carsInput);

        // 시도할 횟수 입력받기
        // 입력받은 횟수만큼 경기 실행
        // 한 경기마다 결과 출력
        int tryCount = InputView.inputTryCount();
        OutputView.printResultInfo();
        playRound(tryCount, cars);

        // 최종 우승자 출력
        printWinners(cars);
    }

    private void playRound(int tryCount, List<Car> cars) {
        for (int i = 0; i < tryCount; i++) {
            racingService.startRound(cars);
            OutputView.printRoundResult(CarDto.from(cars));
        }
    }

    private void printWinners(List<Car> cars) {
        List<String> winners = racingService.calculateWinner(cars);
        OutputView.printWinners(winners);
    }
}
