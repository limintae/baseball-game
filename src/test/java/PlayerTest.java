import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PlayerTest {

    @DisplayName("플레이어 인스턴스 생성")
    @Test
    void createPlayer() {
        Assertions.assertThatCode(() -> {Player.create();}).doesNotThrowAnyException();
    }

    @DisplayName("플레이어에게 게임룰의 숫자를 할당")
    @ParameterizedTest
    @MethodSource
    void setPlayerValues(List<Integer> values) {
        Player player = Player.create();
        player.setValues(values);
        Assertions.assertThat(player.getValues().size()).isEqualTo(Player.PLAYER_BALL_SIZE);
    }

    static Stream<Arguments> setPlayerValues() {
        return Stream.of(
                Arguments.of(List.of(1,2,3))
        );
    }

    @DisplayName("플레이어에게 게임룰 이상의 숫자를 할당")
    @ParameterizedTest
    @MethodSource
    void failSetPlayerValuesOver(List<Integer> values) {
        Player player = Player.create();
        Assertions.assertThatThrownBy(() -> {player.setValues(values);}).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> failSetPlayerValuesOver() {
        return Stream.of(Arguments.of(List.of(1,2,3,4)));
    }

}
