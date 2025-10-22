package racingcar.domain;

public class RacingCar {

    private static final int MOVE_NUM = 4;

    private String carName;
    private Long distance;

    public RacingCar(String carName) {
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
