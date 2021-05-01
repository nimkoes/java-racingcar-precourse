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
    
}
