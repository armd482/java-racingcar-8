package racingcar.util.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import racingcar.model.Car;
import racingcar.model.CarStatus;
import racingcar.model.RaceGame;
import racingcar.model.strategy.MoveStrategy;

public class RaceGameTest {

    @Test
    @DisplayName("첫 번째 자동차만 이동한 경우 - pobi 우승")

    void singleWinnerTest() {

        List<Car> cars = List.of(new Car("pobi"), new Car("jun"));

        MoveStrategy moveStrategy = new MoveStrategy() {
            private int count = 0;

            public boolean isMoveable() {
                if (count == 0) {
                    count++;
                    return true;
                }
                return false;
            };
        };

        RaceGame raceGame = new RaceGame(cars, 1, moveStrategy);
        raceGame.start();

        List<List<CarStatus>> roundResult = raceGame.getRoundResult();
        List<String> winners = raceGame.getWinnerNames();

        assertThat(1).isEqualTo(roundResult.getFirst().getFirst().position());
        assertThat(0).isEqualTo(roundResult.getFirst().getLast().position());

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("모든 자동차가 이동한 경우 - 모두 우승")

    void multiWinnerTest() {

        List<Car> cars = List.of(new Car("pobi"), new Car("jun"));

        MoveStrategy moveStrategy = new MoveStrategy() {
            public boolean isMoveable() {
                return true;
            };
        };

        RaceGame raceGame = new RaceGame(cars, 1, moveStrategy);
        raceGame.start();

        List<List<CarStatus>> roundResult = raceGame.getRoundResult();
        List<String> winners = raceGame.getWinnerNames();

        assertThat(1).isEqualTo(roundResult.getFirst().getFirst().position());
        assertThat(1).isEqualTo(roundResult.getFirst().getLast().position());

        assertThat(winners).contains("pobi", "jun");
    }

    @Test
    @DisplayName("모든 자동차가 움직이지 않는 경우 - 모두 우승")

    void noOneMoveTest() {

        List<Car> cars = List.of(new Car("pobi"), new Car("jun"));

        MoveStrategy moveStrategy = new MoveStrategy() {
            public boolean isMoveable() {
                return false;
            };
        };

        RaceGame raceGame = new RaceGame(cars, 1, moveStrategy);
        raceGame.start();

        List<List<CarStatus>> roundResult = raceGame.getRoundResult();
        List<String> winners = raceGame.getWinnerNames();

        assertThat(0).isEqualTo(roundResult.getFirst().getFirst().position());
        assertThat(0).isEqualTo(roundResult.getFirst().getLast().position());

        assertThat(winners).contains("pobi", "jun");
    }

}
