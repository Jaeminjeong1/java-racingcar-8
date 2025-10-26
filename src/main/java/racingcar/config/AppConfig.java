package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public static RacingService createRacingService() {
        return new RacingService();
    }

    public static RacingController createRacingController() {
        return new RacingController(InputView.create(), OutputView.create(), createRacingService());
    }
}
