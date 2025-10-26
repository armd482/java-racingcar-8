package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarStatus;
import racingcar.model.RaceGame;
import racingcar.model.strategy.RandomMoveStrategy;
import racingcar.util.InputParser;
import racingcar.util.OutputParser;
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

        RaceGame raceGame = new RaceGame(cars, attempt, new RandomMoveStrategy());

        raceGame.start();
        List<List<CarStatus>> roundResult = raceGame.getRoundResult();
        List<String> winner = raceGame.getWinnerNames();

        List<String> round =  OutputParser.formatRoundResults(roundResult);
        String winners = OutputParser.formatWinnerList(winner);

        round.forEach(System.out::println);
        System.out.println(winners);
    }
}
