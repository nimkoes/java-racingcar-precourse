package racingcar;

public class RacingUtil {
    public static void makeWinner(CarCollection winner, CarCollection carCollection) {
        for (Car car : carCollection.getCars()) {
            car.checkWinner(winner);
        }
    }
}
