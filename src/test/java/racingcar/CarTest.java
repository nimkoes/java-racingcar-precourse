package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    
    Car car;
    
    @BeforeEach
    void setUp() {
        car = new Car("nimkoes");
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
    
    @ParameterizedTest
    @ValueSource(strings = {"nimko,pobi", "a,b,c,d"})
    @DisplayName("레이싱 참가 자동차 Collection 생성")
    void createCarCollection(String userInput) {
        CarCollection carCollection = new CarCollection();
        List<String> participants = Arrays.asList(userInput.split(","));
        
        for (String participant : participants) {
            carCollection.getCars().add(new Car(participant));
        }
        
        int i = 0;
        for (String participant : participants) {
            assertThat(participants.contains(carCollection.getCars().get(i++).getName())).isTrue();
        }
        assertThat(carCollection.getCars().size()).isEqualTo(participants.size());
    }
}
