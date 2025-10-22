package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private RandomGenerator() {}
    public static RandomGenerator create() {
        return new RandomGenerator();
    }

    public int generateRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
