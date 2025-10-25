package racingcar.model.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int MOVE_THRESHOLD = 4;

    public boolean isMoveable() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
        return randomValue >= MOVE_THRESHOLD;
    }
}
