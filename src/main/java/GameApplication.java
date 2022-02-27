import java.util.List;

public class GameApplication {

    public static void main(String[] args) {
        GameConsole gameConsole = GameConsole.create();

        Integer restartValue = 0;
        while (restartValue != 2) {
            restartValue = startGame(gameConsole);
        }
    }

    private static Integer startGame(GameConsole gameConsole) {
        Computer computer = Computer.create(new RandomValueGenerator());
        System.out.println(computer.getValues());
        Game game = Game.create(computer, GameRole.create(), Printer.create());
        game.joinPlayer(Player.create());
        game.getPrinter().printMessage(game.getGameStatus());
        while (game.getGameStatus() != GameStatus.END) {
            game.startOnce(gameConsole.startConsole());
        }

        Integer restartValue = 0;
        while (!validateRestartInput(restartValue)) {
            restartValue = gameConsole.restartConsole();
            System.out.println(GameStatus.RESTART.getMessage());
        }
        return restartValue;
    }

    private static boolean validateRestartInput(Integer value) {
        return value == 1 || value == 2;
    }

}
