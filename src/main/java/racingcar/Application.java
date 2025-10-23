package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGameController racingGameController = new RacingGameController(inputView);

        racingGameController.run();
    }
}
