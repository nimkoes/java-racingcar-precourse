package racingcar;

public class Car {
    private static int maxDistance;

    private int moveDistance;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public static int getMaxDistance() {
        return maxDistance;
    }

    public static void updateDistance(Car car, CarAction action) {
        if (CarAction.GO == action) {
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

    private boolean isWinner(Car car) {
        return car.moveDistance() == maxDistance;
    }
}
