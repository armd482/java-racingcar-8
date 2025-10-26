package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import racingcar.model.CarStatus;

public class CarStatusTest {
    @Test
    @DisplayName("자동차 객체 초기화 테스트")
    void carInitTest() {
        CarStatus car = new CarStatus("pobi", 2);
        assertThat("pobi").isEqualTo(car.name());
        assertThat(2).isEqualTo(car.position());
    }
}
