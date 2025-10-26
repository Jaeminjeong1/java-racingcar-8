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

        return List.copyOf(carList);
    }

    public void playOneRound(List<RacingCar> carList) {
        for (RacingCar racingCar : carList) {
            int randomNum = randomGenerator.generateRandomNum();
            racingCar.move(randomNum);
        }
    }

    public List<String> findWinners(List<RacingCar> carList) {
        long maxDistance = findMaxDistance(carList);

        List<String> winnerList = new ArrayList<>();
        for (RacingCar racingCar : carList) {
            if (racingCar.getDistance() == maxDistance) {
                winnerList.add(racingCar.getCarName());
            }
        }
        return winnerList;
    }

    private long findMaxDistance(List<RacingCar> carList) {
        long maxDistance = 0L;
        for (RacingCar racingCar : carList) {
            maxDistance = Math.max(maxDistance, racingCar.getDistance());
        }
        return maxDistance;
    }
}
