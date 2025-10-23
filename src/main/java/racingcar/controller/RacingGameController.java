package racingcar.controller;

import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carNames = inputView.getCarName();
        String attempt = inputView.getAttempt();

        System.out.println(carNames);
        System.out.println(attempt);
    }
}
