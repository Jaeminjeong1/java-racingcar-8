package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private static final String DELIMITER = ",";

    private final RandomGenerator randomGenerator;

    public RacingService(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List<RacingCar> setRacingCars(String carNames) {
        List<RacingCar> carList = new ArrayList<>();

        for (String carString : carNames.split(DELIMITER)) {
            RacingCar racingCar = RacingCar.from(carString.trim());
            carList.add(racingCar);
        }

        return carList;
    }
}
