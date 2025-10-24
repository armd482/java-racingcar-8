package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class InputParserTest {

    private static final String EMPTY_INPUT = "";
    private static final String VALID_CAR_NAMES_INPUT = "pobi,woni,jun";
    private static final String ONE_CAR_INPUT = "pobi";
    private static final String LONG_CAR_NAME_INPUT = "pobi,woni12345,jun";
    private static final String EMPTY_CAR_NAME_INPUT = "pobi,,jun";
    private static final String DUPLICATE_CAR_NAME_INPUT = "pobi,woni,pobi";

    @Test
    @DisplayName("정상 입력 시 - 자동차 이름 배열 리턴")
    void carNamesParseTest() {
        String[] result = InputParser.parseCarNames(VALID_CAR_NAMES_INPUT);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("빈 값 입력 시 - 예외 발생")
    void blankInputParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(EMPTY_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름들을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차가 1개 이하일 때 - 예외 발생")
    void oneCarParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(ONE_CAR_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2개 이상부터 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과일 때 - 예외 발생")
    void longCarNamesParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(LONG_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없으며, 5글자 이하로만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 빈 이름이 있는 경우 예외 발생")
    void blankCarNamesParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(EMPTY_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없으며, 5글자 이하로만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복된 값이 있으면 예외 발생")
    void duplicateCarNamesParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(DUPLICATE_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 설정할 수 없습니다.");
    }
}
