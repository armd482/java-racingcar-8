package racingcar.util;

import java.util.List;
import org.junit.jupiter.api.*;
import racingcar.model.CarStatus;
import static org.assertj.core.api.Assertions.*;

public class OutputParserTest {
    @Test
    @DisplayName("라운드 결과 포맷팅 테스트")
    void formatCarPositionTest() {
        List<CarStatus> carStatuses = List.of(new CarStatus("pobi", 3),  new CarStatus("woni", 1));
        List<String> result = OutputParser.formatRoundResults(List.of(carStatuses));

        assertThat(result).contains("pobi : ---", "woni : -");
    }

    @Test
    @DisplayName("라운드별 결과 사이 줄바꿈 포함 포맷팅 테스트")
    void formatRoundResultsTest() {
        List<List<CarStatus>> roundResult = List.of(
                List.of(new CarStatus("pobi", 1),  new CarStatus("woni", 0)),
                List.of(new CarStatus("pobi", 2),  new CarStatus("woni", 1))
        );
        List<String> result = OutputParser.formatRoundResults(roundResult);
        assertThat(result).containsExactly(
                "pobi : -", "woni : ", "",
                "pobi : --", "woni : -", ""
        );
    }

    @Test
    @DisplayName("우승자 리스트 포맷팅 테스트")
    void formatWinnerListTest() {
        List<String> winners = List.of("pobi", "woni", "jun");
        String result = OutputParser.formatWinnerList(winners);
        assertThat(result).isEqualTo("pobi, woni, jun");
    }
}
