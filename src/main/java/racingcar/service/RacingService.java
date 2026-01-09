package racingcar.service;

import racingcar.domain.Car;

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
}
