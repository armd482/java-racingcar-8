package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceGame;
import racingcar.model.strategy.RandomMoveStrategy;
import racingcar.util.InputParser;
import racingcar.util.OutputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carsInput = inputView.getCarName();
        String[] carNames = InputParser.parseCarNames(carsInput);
        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();

        String attemptInput = inputView.getAttempt();
        int attempt = InputParser.parseAttempt(attemptInput);

        RaceGame raceGame = new RaceGame(cars, attempt, new RandomMoveStrategy());

        raceGame.start();

        List<List<String>> roundResult =  OutputParser.formatRoundResults(raceGame.getRoundResult());
        String winners = OutputParser.formatWinnerList(raceGame.getWinnerNames());

        outputView.displayRoundResult(roundResult);
        outputView.displayWinnerResult(winners);
    }
}
