package racingcar.util;

import java.util.List;
import java.util.stream.Stream;
import racingcar.model.CarStatus;

public class OutputParser {
    private static List<String> formatCarPositions(List<CarStatus> carStatuses) {
        return carStatuses.stream()
                            .map(carStatus -> carStatus.name() + " : " + "-"
                            .repeat(carStatus.position())).toList();
    }

    public static List<List<String>> formatRoundResults(List<List<CarStatus>> carStatuses) {
        return carStatuses.stream()
                .map(OutputParser::formatCarPositions)
                .toList();
    }

    public static String formatWinnerList(List<String> winners) {
        return String.join(", ", winners);
    }
}
