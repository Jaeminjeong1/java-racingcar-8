package racingcar.domain;

public class RacingCar {

    private static final int MOVE_NUM = 4;
    private static final int NAME_MAX_LENGTH = 5;

    private final String carName;
    private Long distance;

    private RacingCar(String carName) {
        this.carName = carName;
        this.distance = 0L;
    }

    public static RacingCar from (String carName) {
        validateCarName(carName);
        return new RacingCar(carName);
    }

    public void move (int randomNum) {
        if (randomNum >= MOVE_NUM) distance++;
    }

    private static void validateCarName(String carName) {
        if (carName.isBlank() || carName.length() > NAME_MAX_LENGTH) {
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
