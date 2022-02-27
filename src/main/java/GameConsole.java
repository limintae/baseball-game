import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameConsole {

    private final Scanner console = new Scanner(System.in);

    public static GameConsole create() {
        return new GameConsole();
    }

    public List<Integer> startConsole() {
        return Arrays.stream(this.console.nextLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer restartConsole() {
        return Integer.parseInt(this.console.nextLine());
    }

}
