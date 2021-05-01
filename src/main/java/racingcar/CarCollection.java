package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCollection {
    private List<Car> cars;
    
    public CarCollection() {
        cars = new ArrayList<>();
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (Car car : cars) sb.append(", " + car.getName());
        
        return sb.toString().substring(2);
    }
}
