import java.util.List;

public class Game {

    private Player player;
    private final Computer computer;
    private final GameRole gameRole;
    private final Printer printer;
    private GameStatus gameStatus;
    private List<Integer> gameResult;

    Game(Computer computer, GameRole gameRole, Printer printer) {
        this.computer = computer;
        this.gameRole = gameRole;
        this.printer = printer;
        this.gameStatus = GameStatus.CREATED;
    }

    public static Game create(Computer computer, GameRole gameRole, Printer printer) {
        return new Game(computer, gameRole, printer);
    }

    public void startOnce(List<Integer> playerValues) {
        if (player == null) {
            throw new NullPointerException("player must not be null");
        }
        player.setValues(playerValues);
        this.gameStatus = GameStatus.PLAYING;
        this.gameResult = gameRole.getResult(player.getValues(), computer.getValues());
        this.gameStatus = decideGameStatus(gameResult);
        printer.printGameResultMessage(gameResult);
        printer.printMessage(gameStatus);
    }

    private GameStatus decideGameStatus(List<Integer> gameResult) {
        if (gameResult.get(ResultStatus.STRIKE.getIdx()) == 3) {
            return GameStatus.END;
        }
        return GameStatus.PLAYING;
    }

//    public void setPlayerValue(List<Integer> playerValue) {
//        if (player == null) {
//            throw new NullPointerException("player must not be null");
//        }
//        player.setValues(playerValue);
//    }

//    public List<Integer> currentPlayerValue() {
//        return player.getValues();
//    }

    public void joinPlayer(Player player) {
        this.player = player;
        this.gameStatus = GameStatus.READY;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Printer getPrinter() {
        return printer;
    }

}
