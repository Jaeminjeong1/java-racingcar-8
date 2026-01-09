package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public record CarDto(
        String name,
        int distance
) {

    private static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getDistance());
    }

    public static List<CarDto> from(List<Car> cars) {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
