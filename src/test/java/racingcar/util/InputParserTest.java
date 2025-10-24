package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;
import static org.assertj.core.api.Assertions.*;

public class InputParserTest {

    private static final String EMPTY_INPUT = "";
    private static final String VALID_CAR_NAMES_INPUT = "pobi,woni,jun";
    private static final String ONE_CAR_INPUT = "pobi";
    private static final String LONG_CAR_NAME_INPUT = "pobi,woni12345,jun";
    private static final String EMPTY_CAR_NAME_INPUT = "pobi,,jun";
    private static final String DUPLICATE_CAR_NAME_INPUT = "pobi,woni,pobi";

    @Test
    @DisplayName("정상 입력한 경우 - 자동차 이름 배열 리턴")
    void carNamesParseTest() {
        String[] result = InputParser.parseCarNames(VALID_CAR_NAMES_INPUT);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("빈 값 입력한 경우 - 예외 발생")
    void blankInputParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(EMPTY_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME_INPUT);
    }

    @Test
    @DisplayName("자동차가 1개 이하인 경우 - 예외 발생")
    void oneCarParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(ONE_CAR_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MINIMUM_CAR_COUNT);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 - 예외 발생")
    void longCarNamesParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(LONG_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    @Test
    @DisplayName("자동차 이름이 빈 이름이 있는 경우 - 예외 발생")
    void blankCarNamesParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(EMPTY_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    @Test
    @DisplayName("자동차 이름이 중복된 값이 있는 경우 - 예외 발생")
    void duplicateCarNamesParseTest() {
        assertThatThrownBy(() -> InputParser.parseCarNames(DUPLICATE_CAR_NAME_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME);
    }
}
