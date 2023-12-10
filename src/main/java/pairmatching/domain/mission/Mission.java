package pairmatching.domain.mission;

import java.util.Arrays;
import pairmatching.view.input.error.InputError;
import pairmatching.view.input.error.InputIllegalArgumentException;

public enum Mission {

    CAR_GAME("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_PATH("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTION("배포");

    final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission getMissionByName(String inputValue) {
        return Arrays.stream(values())
                .filter(input -> input.name.equals(inputValue))
                .findFirst()
                .orElseThrow(() -> new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT));
    }
}
