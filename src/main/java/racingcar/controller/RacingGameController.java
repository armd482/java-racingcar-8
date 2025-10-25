package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceGame;
import racingcar.util.InputParser;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carsInput = inputView.getCarName();
        String[] carNames = InputParser.parseCarNames(carsInput);
        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();

        String attemptInput = inputView.getAttempt();
        int attempt = InputParser.parseAttempt(attemptInput);

        RaceGame raceGame = new RaceGame(cars, attempt);

        raceGame.start();

        System.out.println(raceGame.getWinnerNames());
    }
}
