import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


public class GameRoleTest {

    @Test
    void createGameRole(){
        Assertions.assertThatCode(() -> {GameRole.create();}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    void getResult(List<Integer> player, List<Integer> computer, List<Integer> result){
        GameRole gameRole = GameRole.create();
        Assertions.assertThat(gameRole.getResult(player, computer)).isEqualTo(result);
    }

    static Stream<Arguments> getResult(){
        return Stream.of(
                Arguments.of(List.of(1,2,3), List.of(1,2,3), List.of(0, 3)),
                Arguments.of(List.of(1,4,5), List.of(1,2,3), List.of(0, 1)),
                Arguments.of(List.of(1,6,4), List.of(2,1,3), List.of(1, 0)));
    }

}
