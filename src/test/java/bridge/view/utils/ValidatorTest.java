package bridge.view.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.Constants.*;
import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @DisplayName("범위 테스트 - 범위를 벗어났을 때")
    @ValueSource(strings = {"-1", "2", "21"})
    @ParameterizedTest
    void validateForRangeException1(Integer input) {
        assertThatThrownBy(() -> {
            if (input < Validator.MIN_BRIDGE_SIZE || input > Validator.MAX_BRIDGE_SIZE) {
                throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("범위 테스트 - 범위를 벗어나지 않았을 때")
    @ValueSource(strings = {"3", "10", "20"})
    @ParameterizedTest
    void validateForRangeException2(Integer input) {
        Throwable t = catchThrowable(() -> {
            if (input < Validator.MIN_BRIDGE_SIZE || input > Validator.MAX_BRIDGE_SIZE) {
                throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
            }
        });
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("입력 테스트 - U 또는 D를 입력했을 때")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void validateForIllegalInputUpOrDown1(String input) {
        Throwable t = catchThrowable(() -> {
            if (!input.equals("U") && !input.equals("D")) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_U_OR_D_MESSAGE);
            }
        });
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("입력 테스트 - U 또는 D를 입력하지 않았을 때")
    @ValueSource(strings = {"K", "3"})
    @ParameterizedTest
    void validateForIllegalInputUpOrDown2(String input) {
        Throwable t = catchThrowable(() -> {
            if (!input.equals("U") && !input.equals("D")) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_U_OR_D_MESSAGE);
            }
        });
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_U_OR_D_MESSAGE);
    }

    @DisplayName("입력 테스트 - R 또는 Q를 입력했을 때")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void validateForIllegalInputRestartOrQuit1(String input) {
        Throwable t = catchThrowable(() -> {
            if (!input.equals("R") && !input.equals("Q")) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_R_OR_Q_MESSAGE);
            }
        });
        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("입력 테스트 - R 또는 Q를 입력하지 않았을 때")
    @ValueSource(strings = {"K", "3"})
    @ParameterizedTest
    void validateForIllegalInputRestartOrQuit2(String input) {
        Throwable t = catchThrowable(() -> {
            if (!input.equals("R") && !input.equals("Q")) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_R_OR_Q_MESSAGE);
            }
        });
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_R_OR_Q_MESSAGE);
    }
}