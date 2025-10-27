package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringParserTest {

    @Test
    void 구분자_기능 () {
        String input = "pobi,woni,jun";
        String[] result = StringParser.parse(input);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 공백_포함_구분자_기능() {
        String input = " pobi , woni , jun ";
        String[] result = StringParser.parse(input);

        assertThat(result).containsExactly(" pobi ", " woni ", " jun ");
    }

    @Test
    void 구분자_앞이_빈_경우() {
        String input = ",pobi,woni";
        String[] result = StringParser.parse(input);

        assertThat(result).containsExactly("", "pobi", "woni");
    }

    @Test
    void 구분자_뒤가_빈_경우() {
        String input = "pobi,woni,";
        String[] result = StringParser.parse(input);

        assertThat(result).containsExactly("pobi", "woni", "");
    }
}