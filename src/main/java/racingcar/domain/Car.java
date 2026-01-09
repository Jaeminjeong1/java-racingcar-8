package racingcar.domain;

public class Car {

    private static final int MOVE_STANDARD_NUM = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int distance;

    private Car(String name) {
        validateCarName(name);
        this.name = name;
        this.distance = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move(int randomNum) {
        if (randomNum >= MOVE_STANDARD_NUM) distance++;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
