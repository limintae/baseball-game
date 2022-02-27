
import java.util.ArrayList;
import java.util.List;

public class Player {

    public static final Integer PLAYER_BALL_SIZE = 3;
    private List<Integer> values = new ArrayList<>(PLAYER_BALL_SIZE);

    public Player() {}

    public static Player create() {
        return new Player();
    }

    public void setValues(List<Integer> values) {
        if (values.size() > PLAYER_BALL_SIZE) {
            throw new IllegalArgumentException("player ball size must be less then " + PLAYER_BALL_SIZE);
        }
        this.values = values;
    }

    public List<Integer> getValues() {
        return this.values;
    }

}
