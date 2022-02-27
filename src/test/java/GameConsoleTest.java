import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameConsoleTest {

    @Test
    void createGameConsole() {
        Assertions.assertThatCode(() -> {GameConsole.create();}).doesNotThrowAnyException();
    }

}
