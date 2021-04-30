package racingcar;

public class Car {
    public CarAction action(int randomNumber) {
        if(getAction(randomNumber)) {
            return CarAction.STOP;
        }
        return CarAction.GO;
    }
    
    private boolean getAction(int actionNumber) {
        return actionNumber <= 3;
    }
}
