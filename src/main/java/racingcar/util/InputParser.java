package racingcar.util;

import java.util.Arrays;
import racingcar.constant.ErrorMessage;

public class InputParser {

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_SEPARATOR = ",";

    public static String[] parseCarNames(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME_INPUT.getMessage());
        }

        String[] carNames = carNamesInput.split(CAR_NAME_SEPARATOR);

        validateMinimumCarCount(carNames);
        validateCarNameLength(carNames);
        validateDuplicateCarNames(carNames);

        return carNames;
    }

    public static Integer parseAttempt(String attemptInput) {
        if (attemptInput == null || attemptInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ATTEMEPT_INPUT.getMessage());
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

    private static void validateMinimumCarCount(String[] carNames) {
        if(carNames.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CAR_COUNT.getMessage());
        }
    }

    private static void validateCarNameLength(String[] carNames) {
        boolean isValidateCarNames = Arrays.stream(carNames)
                                            .allMatch(name -> !name.isBlank() && name.length() <= MAX_CAR_NAME_LENGTH);
        if(!isValidateCarNames) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateDuplicateCarNames(String[] carNames) {
        boolean hasDuplicateCarNames = Arrays.stream(carNames).distinct().count() != carNames.length;
        if(hasDuplicateCarNames) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }
}
