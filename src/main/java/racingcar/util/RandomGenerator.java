package racingcar.util;

public class RandomGenerator {

    private RandomGenerator() {}
    public static RandomGenerator create() {
        return new RandomGenerator();
    }
}
