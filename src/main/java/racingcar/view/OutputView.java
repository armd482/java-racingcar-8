package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    public void displayRoundResult(List<List<String>> roundResult) {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
        roundResult.forEach(this::displayRound);
    }

    public void displayWinnerResult(String winnerResult) {
        System.out.println(WINNER_MESSAGE_PREFIX +  winnerResult);
    }

    private void displayRound(List<String> round) {
        round.forEach(System.out::println);
        System.out.println();
    }
}
