import java.util.List;

public class Printer {

    public static Printer create() {
        return new Printer();
    }

    public void printMessage(GameStatus gameStatus) {
        System.out.println(gameStatus.getMessage());
        if (gameStatus == GameStatus.END) {
            System.out.println(GameStatus.RESTART.getMessage());
        }
    }

    public void printGameResultMessage(List<Integer> gameResult) {
        StringBuilder gameResultMessage = new StringBuilder();
        gameResultMessage.append(generatePartialResultMessage(ResultStatus.BALL, gameResult));
        gameResultMessage.append(generatePartialResultMessage(ResultStatus.STRIKE, gameResult));
        System.out.println(gameResultMessage.toString().trim());
    }

    private String generatePartialResultMessage(ResultStatus resultStatus, List<Integer> gameResult) {
        return new StringBuilder()
                .append(gameResult.get(resultStatus.getIdx()))
                .append(resultStatus.getResultName())
                .append(" ").toString();
    }

}
