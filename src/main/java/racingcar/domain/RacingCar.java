package racingcar.domain;

public class RacingCar {

    private String carName;
    private Long distance;

    public RacingCar(String carName) {
        this.carName = carName;
        this.distance = 0L;
    }

    public RacingCar from (String carName) {
        validateCarName(carName);
        return new RacingCar(carName);
    }

    private void validateCarName(String carName) {
        if (carName.isBlank() || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getCarName() {
        return carName;
    }

    public Long getDistance() {
        return distance;
    }
}
