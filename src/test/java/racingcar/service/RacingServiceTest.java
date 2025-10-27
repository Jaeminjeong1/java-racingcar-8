package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingServiceTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    @DisplayName("입력값으로 레이싱카 준비: trim 후 생성, 이름 보장")
    void 입력값_기준으로_레이싱카_준비() {
        String input = "pobi , woni , jun ";

        List<RacingCar> cars = racingService.setRacingCars(input);

        assertThat(cars).extracting(RacingCar::getCarName)
                .containsExactly("pobi", "woni", "jun");


    }

    @Test
    @DisplayName("잘못된 입력(트레일링 콤마 등)은 예외 발생")
    void 잘못된_입력값_예외() {
        assertThrows(IllegalArgumentException.class, () ->
                racingService.setRacingCars("pobi,woni,"));

        assertThrows(IllegalArgumentException.class, () ->
                racingService.setRacingCars(",pobi"));

        assertThrows(IllegalArgumentException.class, () ->
                racingService.setRacingCars("pobi,,woni"));

        assertThrows(IllegalArgumentException.class, () ->
                racingService.setRacingCars("pobi, ,woni"));

        assertThrows(IllegalArgumentException.class, () ->
                racingService.setRacingCars("    "));

        assertThrows(IllegalArgumentException.class, () ->
                racingService.setRacingCars(""));
    }

    @Test
    void 한_라운드_진행() {
        String input = "pobi,woni,jun";
        List<RacingCar> cars = racingService.setRacingCars(input);

        assertRandomNumberInRangeTest(
                () -> {
                    racingService.playOneRound(cars);
                    assertThat(cars.get(0).getDistance()).isEqualTo(1);
                    assertThat(cars.get(1).getDistance()).isEqualTo(0);
                    assertThat(cars.get(2).getDistance()).isEqualTo(1);
                },
                MOVE, STOP, MOVE
        );
    }

    @Test
    @DisplayName("우승자 집계 - 단독 우승")
    void 우승자_집계_단독() {
        String input = "pobi,woni";
        List<RacingCar> cars = racingService.setRacingCars(input);

        assertRandomNumberInRangeTest(
                () -> {
                    racingService.playOneRound(cars);
                    List<String> winners = racingService.findWinners(cars);
                    assertThat(winners).containsExactly("pobi");
                },
                MOVE, STOP
        );
    }

    @Test
    @DisplayName("우승자 집계 - 공동 우승")
    void 우승자_집계_공동() {
        String input = "pobi,woni";
        List<RacingCar> cars = racingService.setRacingCars(input);

        assertRandomNumberInRangeTest(
                () -> {
                    racingService.playOneRound(cars);
                    List<String> winners = racingService.findWinners(cars);
                    assertThat(winners).containsExactly("pobi", "woni");
                },
                MOVE, MOVE
        );
    }
}