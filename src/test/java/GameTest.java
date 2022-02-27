import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class GameTest {

    private Game game;
    private Player player;

    @BeforeEach
    void gameTestInitialize() {
        this.game = Game.create(Computer.create(new RandomValueGenerator()), GameRole.create(), Printer.create());
        this.player = Player.create();
        Assertions.assertThat(game.getGameStatus()).isEqualTo(GameStatus.CREATED);
    }

    @DisplayName("게임 프린터 테스트")
    @Test
    void gamePrinterTest() {
        Assertions.assertThatCode(() -> {game.getPrinter().printMessage(GameStatus.READY);}).doesNotThrowAnyException();
    }

    @DisplayName("게임 인스턴스를 생생한다")
    @Test
    void createGame() {
        // 게임 인스턴스의 생성 검증
        Assertions.assertThatCode(() -> {
            Game.create(Computer.create(new RandomValueGenerator()), GameRole.create(), Printer.create());}).doesNotThrowAnyException();
    }

    @DisplayName("플레이어가 게임에 참가한다")
    @Test
    void joinPlayer() {
        Assertions.assertThatCode(() -> {game.joinPlayer(player);}).doesNotThrowAnyException();
        Assertions.assertThat(game.getGameStatus()).isEqualTo(GameStatus.READY);
    }

    @DisplayName("플레이어를 등록하지 않은 게임 시작오류")
    @Test
    void startGameWithoutPlayer() {
        Assertions.assertThatThrownBy(() -> game.startOnce(List.of(1,2,3))).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("플레이어가 종료조건을 달성하여 게임이 종료된다(승리)")
    @ParameterizedTest
    @MethodSource
    void startGamePlayerWins(List<Integer> playerValue) {
        MakeValue givenRandomValueGenerator = () -> {return List.of(1,2,3);};
        Game game = Game.create(Computer.create(givenRandomValueGenerator), GameRole.create(), Printer.create());
        // 플레이어의 게임 참가
        game.joinPlayer(player);
        // 게임 시작
        game.startOnce(playerValue);
        Assertions.assertThat(game.getGameStatus()).isEqualTo(GameStatus.END);
    }

    static Stream<Arguments> startGamePlayerWins(){
        return Stream.of(
                Arguments.of(List.of(1,2,3))
        );
    }

    @DisplayName("플레이어가 종료조건을 달성하지 못하여 게임이 재개된다(패배)")
    @ParameterizedTest
    @MethodSource
    void startGamePlayerLoses(List<Integer> playerValue) {
        MakeValue givenRandomValueGenerator = () -> {return List.of(3,4,5);};
        Game game = Game.create(Computer.create(givenRandomValueGenerator), GameRole.create(), Printer.create());
        // 플레이어의 게임 참가
        game.joinPlayer(player);
        // 게임 시작
        game.startOnce(playerValue);
        Assertions.assertThat(game.getGameStatus()).isEqualTo(GameStatus.PLAYING);
    }

    static Stream<Arguments> startGamePlayerLoses(){
        return Stream.of(
                Arguments.of(List.of(1,2,3))
        );
    }

}
