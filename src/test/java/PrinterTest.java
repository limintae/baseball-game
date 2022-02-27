import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PrinterTest {

    private Printer printer = Printer.create();

    @BeforeEach
    void printerTestInitialize() {
        this.printer = Printer.create();
    }

    @Test
    void createPrinter() {
        Assertions.assertThatCode(() -> {Printer.create();}).doesNotThrowAnyException();
    }

    @Test
    void printMessage() {
        Assertions.assertThatCode(() -> {printer.printMessage(GameStatus.PLAYING);}).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> {printer.printMessage(GameStatus.END);}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    void printGameResultMessage(List<Integer> gameResult) {
        Assertions.assertThatCode(() -> {printer.printGameResultMessage(gameResult);}).doesNotThrowAnyException();
    }

    static Stream<Arguments> printGameResultMessage() {
        return Stream.of(
                Arguments.of(List.of(1, 1))
        );
    }

}
