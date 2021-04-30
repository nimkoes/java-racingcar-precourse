package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    
    @Test
    @DisplayName("GO, STOP 테스트")
    public void carAction() {
        Car car = new Car();
        assertThat(car.action(1)).isEqualTo(CarAction.STOP);
        assertThat(car.action(3)).isEqualTo(CarAction.STOP);
        assertThat(car.action(4)).isEqualTo(CarAction.GO);
        assertThat(car.action(9)).isEqualTo(CarAction.GO);
    }
}
