package racingcar.constant;

public class ErrorMessage {
    private ErrorMessage() {}

    public static final String EMPTY_CAR_NAME_INPUT = "자동차 이름들을 입력해주세요.";
    public static final String MINIMUM_CAR_COUNT = "자동차는 2개 이상부터 가능합니다.";
    public static final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 공백일 수 없으며, 5글자 이하로만 가능합니다.";
    public static final String DUPLICATE_CAR_NAME = "중복된 이름을 설정할 수 없습니다.";

    public static final String EMPTY_ATTMEPT_INPUT = "시도할 횟수를 입력해주세요.";
    public static final String INVALID_ATTEMPT_FORMAT = "입력 값은 정수여야 합니다.";
    public static final String INVALID_NEGATIVE_ATTEMPT = "양의 정수여야 합니다.";
}
