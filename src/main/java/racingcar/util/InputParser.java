package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class InputParser {

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_SEPARATOR = ",";

    public static List<String> parseCarNames(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME_INPUT.getMessage());
        }

        List<String> carNames = Arrays.stream(carNamesInput.split(CAR_NAME_SEPARATOR)).toList();

        validateMinimumCarCount(carNames);
        validateCarNameLength(carNames);
        validateDuplicateCarNames(carNames);

        return carNames;
    }

    public static Integer parseAttempt(String attemptInput) {
        if (attemptInput == null || attemptInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ATTEMPT_INPUT.getMessage());
        }

        try {
            int attempt = Integer.parseInt(attemptInput);
            if(attempt < 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_ATTEMPT.getMessage());
            }
            return attempt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_FORMAT.getMessage());
        }
    }

    private static void validateMinimumCarCount(List<String> carNames) {
        if(carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CAR_COUNT.getMessage());
        }
    }

    private static void validateCarNameLength(List<String> carNames) {
        boolean isValidateCarNames = carNames.stream()
                                                .allMatch(name -> !name.isBlank() && name.length() <= MAX_CAR_NAME_LENGTH);
        if(!isValidateCarNames) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateDuplicateCarNames(List<String> carNames) {
        boolean hasDuplicateCarNames = carNames.stream()
                                                .distinct().count() != carNames.size();
        if(hasDuplicateCarNames) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }
}
