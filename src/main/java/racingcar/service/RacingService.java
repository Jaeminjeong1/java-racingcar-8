package racingcar.service;

import racingcar.domain.Car;
import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public List<Car> setCars(List<String> carsInput) {
        List<Car> cars = new ArrayList<>();

        for (String carInput : carsInput) {
            cars.add(Car.from(carInput));
        }

        return cars;
    }

    public void startRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = RandomGenerator.generateRandomNum();
            car.move(randomNum);
        }
    }

    public List<String> calculateWinner(List<Car> cars) {
        List<String> result = new ArrayList<>();

        int maxDistance = getMaxDistance(cars);
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                result.add(car.getName());
            }
        }
        return result;
    }

    private static int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }
}
