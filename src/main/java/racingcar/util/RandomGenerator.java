package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private RandomGenerator() {}

    public static int generateRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
