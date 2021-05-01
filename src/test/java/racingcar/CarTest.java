package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import racingcar.common.RacingUtil;
import racingcar.core.Car;
import racingcar.core.CarAction;
import racingcar.core.CarCollection;

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
        
        assertThat(car.getMoveDistance()).isEqualTo(2);
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
    
    @Test
    @DisplayName("가장 멀리 간 자동차의 이동 거리 테스트")
    void updateMaxDistance() {
        String userInput = "nimkoes,pobi,whiteship";
        
        CarCollection carCollection = new CarCollection();
        List<String> participants = Arrays.asList(userInput.split(","));
        
        for (String participant : participants) {
            carCollection.getCars().add(new Car(participant));
        }
        
        Car.updateDistance(carCollection.getCars().get(0), carCollection.getCars().get(0).action(5));
        Car.updateDistance(carCollection.getCars().get(0), carCollection.getCars().get(0).action(5));
        Car.updateDistance(carCollection.getCars().get(0), carCollection.getCars().get(0).action(5));
        
        Car.updateDistance(carCollection.getCars().get(1), carCollection.getCars().get(1).action(5));
        
        Car.updateDistance(carCollection.getCars().get(2), carCollection.getCars().get(2).action(5));
        Car.updateDistance(carCollection.getCars().get(2), carCollection.getCars().get(2).action(5));
        
        assertThat(Car.getMaxDistance()).isEqualTo(3);
    }
    
    
    @Test
    @DisplayName("우승자 확인 테스트")
    void winner() {
        String userInput = "nimkoes,pobi,whiteship";
        
        CarCollection carCollection = new CarCollection();
        List<String> participants = Arrays.asList(userInput.split(","));
        
        for (String participant : participants) {
            carCollection.getCars().add(new Car(participant));
        }
        
        Car.updateDistance(carCollection.getCars().get(0), carCollection.getCars().get(0).action(5));
        Car.updateDistance(carCollection.getCars().get(0), carCollection.getCars().get(0).action(5));
        
        Car.updateDistance(carCollection.getCars().get(1), carCollection.getCars().get(1).action(5));
        
        Car.updateDistance(carCollection.getCars().get(2), carCollection.getCars().get(2).action(5));
        Car.updateDistance(carCollection.getCars().get(2), carCollection.getCars().get(2).action(5));
        
        CarCollection winner = new CarCollection();
        RacingUtil.makeWinner(winner, carCollection);
        
        assertThat(winner.toString()).isEqualTo("nimkoes, whiteship");
    }
}
