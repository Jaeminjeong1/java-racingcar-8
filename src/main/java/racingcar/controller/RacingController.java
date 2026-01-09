package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;

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

        // 최종 우승자 출력
    }
}
