package racingcar.util;

import java.util.List;
import racingcar.model.CarStatus;

public class OutputParser {
    private static final String CAR_POSITION_SEPARATOR = " : ";
    private static final String MOVE_MARK = "-";

    public static List<List<String>> formatRoundResults(List<List<CarStatus>> carStatuses) {
        return carStatuses.stream()
                .map(OutputParser::formatCarPositions)
                .toList();
    }

    public static String formatWinnerList(List<String> winners) {
        return String.join(", ", winners);
    }

    private static List<String> formatCarPositions(List<CarStatus> carStatuses) {
        return carStatuses.stream()
                .map(carStatus -> carStatus.name() + CAR_POSITION_SEPARATOR + MOVE_MARK.repeat(carStatus.position())).toList();
    }
}
