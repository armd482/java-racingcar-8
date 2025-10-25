package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGame {

    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars;
    private final int attempts;
    private final List<List<Car>> roundStatus =  new ArrayList<>();

    public RaceGame(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            roundStatus.add(getCarRoundStatus());
        }
    }

    public List<List<Car>> getRoundResult () {
        return roundStatus;
    }

    public List<String> getWinnerNames() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private void moveCars() {
        for(Car car : cars) {
            carMove(car);
        }
    }

    private void carMove(Car car) {
        int randomValue = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
        if (randomValue < MOVE_THRESHOLD) {
            car.go();
        }
    }

    private List<Car> getCarRoundStatus() {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getPosition()))
                .toList();
    }
}
