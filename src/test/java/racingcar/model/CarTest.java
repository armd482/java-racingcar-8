package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차 객체 초기화 테스트")
    void carInitTest() {
        Car car = new Car("pobi");
        assertThat("pobi").isEqualTo(car.getName());
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("자동차 이동 메서드 테스트")
    void carMoveTest() {
        Car car = new Car("pobi");
        car.moveForward();
        assertThat(1).isEqualTo(car.getPosition());

        car.moveForward();
        assertThat(2).isEqualTo(car.getPosition());
    }
}
