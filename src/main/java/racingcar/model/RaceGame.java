package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.strategy.MoveStrategy;

public class RaceGame {

    private final List<Car> cars;
    private final int attempts;
    private final MoveStrategy moveStrategy;
    private final List<List<CarStatus>> roundStatus =  new ArrayList<>();

    public RaceGame(List<Car> cars, int attempts, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>(cars);
        this.moveStrategy = moveStrategy;
        this.attempts = attempts;

    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            roundStatus.add(getCarRoundStatus());
        }
    }

    public List<List<CarStatus>> getRoundResult () {
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
        if (moveStrategy.isMoveable()) {
            car.go();
        }
    }

    private List<CarStatus> getCarRoundStatus() {
        return cars.stream()
                .map(car -> new CarStatus(car.getName(), car.getPosition()))
                .toList();
    }
}
