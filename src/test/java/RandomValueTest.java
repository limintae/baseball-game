import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(ValueResolver.class)
public class RandomValueTest {

    @RepeatedTest(10)
    void validateRandomValue(RandomValueGenerator randomValueGenerator){
        List<Integer> list = randomValueGenerator.makeRandomValue();
        Assertions.assertThat(list.size()).isEqualTo(3);
    }

}
