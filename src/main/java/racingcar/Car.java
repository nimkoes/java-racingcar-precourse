package racingcar;

public class Car {
    private int moveDistance;
    private String name;
    
    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public CarAction action(int randomNumber) {
        if(getAction(randomNumber)) {
            return CarAction.STOP;
        }
        ++this.moveDistance;
        return CarAction.GO;
    }
    
    private boolean getAction(int actionNumber) {
        return actionNumber <= 3;
    }
    
    public int moveDistance() {
        return this.moveDistance;
    }
}
