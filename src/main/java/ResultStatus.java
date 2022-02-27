public enum ResultStatus {
    BALL(0, "볼"),
    STRIKE(1, "스트라이크");

    private final int idx;
    private final String resultName;

    ResultStatus(int idx, String resultName) {
        this.idx = idx;
        this.resultName = resultName;
    }

    public int getIdx() {
        return idx;
    }

    public String getResultName() {
        return resultName;
    }

}
