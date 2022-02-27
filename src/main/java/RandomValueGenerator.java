import java.util.List;
import java.util.random.RandomGenerator;

public class RandomValueGenerator implements MakeValue {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    @Override
    public List<Integer> makeRandomValue() {
        return RANDOM_GENERATOR.ints(1, 9)
                .distinct()
                .limit(3)
                .boxed()
                .toList();
    }
}
