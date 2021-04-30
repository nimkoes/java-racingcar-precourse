package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    
    Car car;
    
    @BeforeEach
    void setUp() {
        car = new Car();
    }
    
    @Test
    @DisplayName("GO, STOP 테스트")
    void carAction() {
        assertThat(car.action(1)).isEqualTo(CarAction.STOP);
        assertThat(car.action(3)).isEqualTo(CarAction.STOP);
        assertThat(car.action(4)).isEqualTo(CarAction.GO);
        assertThat(car.action(9)).isEqualTo(CarAction.GO);
    }
    
    @Test
    @DisplayName("이동 거리 확인")
    void distance() {
        car.action(1);
        car.action(4);
        car.action(3);
        car.action(5);
        
        assertThat(car.moveDistance()).isEqualTo(2);
    }
}
