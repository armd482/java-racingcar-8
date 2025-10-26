package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.CarStatus;

public class OutputParser {
    private static List<String> formatCarPositions(List<CarStatus> carStatuses) {
        return carStatuses.stream()
                            .map(carStatus -> carStatus.name() + " : " + "-"
                            .repeat(carStatus.position())).toList();
    }

    public static List<String> formatRoundResults(List<List<CarStatus>> carStatuses) {
        return carStatuses.stream()
                            .flatMap(round -> Stream.concat(formatCarPositions(round).stream(), Stream.of("")))
                            .toList();
    }

    public static String formatWinnerList(List<String> winners) {
        return String.join(",", winners);
    }
}
