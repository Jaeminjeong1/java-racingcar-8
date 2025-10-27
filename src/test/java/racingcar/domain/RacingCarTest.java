package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void 이름이_6자_이상일_경우_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCar racingCar = RacingCar.from("woowacource");
        });
    }

    @Test
    void 이름이_공백일_경우_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCar racingCar = RacingCar.from("");
        });
    }

    @Test
    void 랜덤값이_4이상이면_이동_아니면_정지() {
        RacingCar racingCar = RacingCar.from("pobi");

        racingCar.move(1);
        assertThat(racingCar.getDistance()).isEqualTo(0);

        racingCar.move(4);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @Test
    void 여러번_이동시_거리누적() {
        RacingCar racingCar = RacingCar.from("pobi");

        racingCar.move(4);
        racingCar.move(5);

        assertThat(racingCar.getDistance()).isEqualTo(2);
    }

}