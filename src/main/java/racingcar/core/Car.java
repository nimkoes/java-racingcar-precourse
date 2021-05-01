package racingcar.core;

public class Car {

    private static final int GO_STOP_JUDGE_VALUE = 3;

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
            maxDistance = Math.max(maxDistance, car.getMoveDistance());
        }
    }

    public String getName() {
        return name;
    }

    public CarAction action(int randomNumber) {
        if (judgement(randomNumber)) {
            return CarAction.STOP;
        }
        ++this.moveDistance;
        appendGoTrace();
        return CarAction.GO;
    }

    private boolean judgement(int actionNumber) {
        return actionNumber <= GO_STOP_JUDGE_VALUE;
    }

    public int getMoveDistance() {
        return this.moveDistance;
    }

    public void checkWinner(CarCollection winner) {
        if (isWinner(this)) {
            winner.getCars().add(this);
        }
    }

    public void appendGoTrace() {
        this.trace.append("-");
    }

    public String getTrace() {
        return trace.toString();
    }

    private boolean isWinner(Car car) {
        return car.getMoveDistance() == maxDistance;
    }
}
