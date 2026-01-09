package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public static int generateRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
