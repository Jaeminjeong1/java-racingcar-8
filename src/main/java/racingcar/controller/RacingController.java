package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void start() {
        //레이싱카 이름 입력받기
        String carNames = inputView.inputCarName();
        List<RacingCar> carList = racingService.setRacingCars(carNames); //도메인 노출
        //라운드 수 입력 받기
        Long roundNum = inputView.inputRoundNum();
        //레이스 시작
        List<String> winners = raceStart(roundNum, carList);
        //우승자 출력
        outputView.printWinners(winners);
    }

    // 서비스로
    private List<String> raceStart(Long roundNum, List<RacingCar> carList) {
        outputView.printRaceStart();

        //라운드별 현황 출력
        for (int i = 0; i < roundNum; i++) {
            racingService.playOneRound(carList);
            outputView.printOneRound(carList);
        }

        //우승자 집계
        return racingService.findWinners(carList);
    }
}
