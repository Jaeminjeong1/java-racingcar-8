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
        String carNames = inputView.inputCarName();
        List<RacingCar> carList = racingService.setRacingCars(carNames);
        Long roundNum = inputView.inputRoundNum();
        List<String> winners = raceStart(roundNum, carList);
        outputView.printWinners(winners);
    }

    private List<String> raceStart(Long roundNum, List<RacingCar> carList) {
        outputView.printRaceStart();

        for (int i = 0; i < roundNum; i++) {
            racingService.playOneRound(carList);
            outputView.printOneRound(carList);
        }

        return racingService.findWinners(carList);
    }
}
