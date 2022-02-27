public enum GameStatus {
    CREATED("게임이 생성되었습니다"),
    READY("게임이 준비되었습니다"),
    PLAYING("숫자를 입력해주세요"),
    END("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
