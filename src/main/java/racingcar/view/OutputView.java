package racingcar.view;

import java.util.List;

public class OutputView {
    public void displayRoundResult(List<String> roundResult) {
        System.out.println();
        System.out.println("실행 결과");
        roundResult.forEach(System.out::println);
    }

    public void displayWinnerResult(String winnerResult) {
        System.out.println("최종 우승자 : " +  winnerResult);
    }
}
