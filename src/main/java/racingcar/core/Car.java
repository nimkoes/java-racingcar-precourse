package racingcar.core;

public class Car {
    private static int maxDistance;

    private int moveDistance;
    private String name;
    private StringBuilder trace;

    public Car(String name) {
        trace = new StringBuilder();
        this.name = name;
    }

    public static int getMaxDistance() {
        return maxDistance;
    }

    public static void updateDistance(Car car, CarAction action) {
        if (action.isGo()) {
            maxDistance = Math.max(maxDistance, car.moveDistance());
        }
    }

    public String getName() {
        return name;
    }

    public CarAction action(int randomNumber) {
        if (getAction(randomNumber)) {
            return CarAction.STOP;
        }
        ++this.moveDistance;
        move();
        return CarAction.GO;
    }

    private boolean getAction(int actionNumber) {
        return actionNumber <= 3;
    }

    public int moveDistance() {
        return this.moveDistance;
    }

    public void checkWinner(CarCollection winner) {
        if (isWinner(this)) {
            winner.getCars().add(this);
        }
    }

    public void move() {
        this.trace.append("-");
    }

    public String getTrace() {
        return trace.toString();
    }

    private boolean isWinner(Car car) {
        return car.moveDistance() == maxDistance;
    }
}
