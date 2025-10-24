package racingcar.util;

import java.util.Arrays;

public class InputParser {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_SEPARATOR = ",";

    public static String[] parseCarNames(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.isBlank()) {
            throw new IllegalArgumentException("자동차 이름들을 입력해주세요.");
        }

        String[] carNames = carNamesInput.split(CAR_NAME_SEPARATOR);

        validateMinimumCarCount(carNames);
        validateCarNameLength(carNames);
        validateDuplicateCarNames(carNames);

        return carNames;
    }

    private static void validateMinimumCarCount(String[] carNames) {
        if(carNames.length < 2) {
            throw new IllegalArgumentException("자동차는 2개 이상부터 가능합니다.");
        }
    }

    private static void validateCarNameLength(String[] carNames) {
        boolean isValidateCarNames = Arrays.stream(carNames)
                                            .allMatch(name -> !name.isBlank() && name.length() <= MAX_CAR_NAME_LENGTH);
        if(!isValidateCarNames) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없으며, 5글자 이하로만 가능합니다.");
        }
    }

    private static void validateDuplicateCarNames(String[] carNames) {
        boolean hasDuplicateCarNames = Arrays.stream(carNames).distinct().count() != carNames.length;
        if(hasDuplicateCarNames) {
            throw new IllegalArgumentException("중복된 이름은 설정할 수 없습니다.");
        }
    }
}
