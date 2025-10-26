package racingcar.view;

import java.util.List;

public class OutputView {
    public void displayRoundResult(List<List<String>> roundResult) {
        System.out.println();
        System.out.println("실행 결과");
        roundResult.forEach(this::displayRound);
    }

    public void displayWinnerResult(String winnerResult) {
        System.out.println("최종 우승자 : " +  winnerResult);
    }

    private void displayRound(List<String> round) {
        round.forEach(System.out::println);
        System.out.println();
    }
}
