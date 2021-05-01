package racingcar.common;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import racingcar.core.Car;
import racingcar.core.CarCollection;

public class RacingUtil {

    static Random random = new Random();

    public static void makeWinner(CarCollection winner, CarCollection carCollection) {
        for (Car car : carCollection.getCars()) {
            car.checkWinner(winner);
        }
    }

    public static String inputCarName(Scanner sc) {
        System.out.println(Message.INPUT_CAR_NAME.getMsg());
        return sc.nextLine();
    }

    public static String inputTryCount(Scanner sc) {
        System.out.println(Message.INPUT_TRY_COUNT.getMsg());
        return sc.nextLine();
    }

    public static void makeParticipants(CarCollection carCollection, String userInput) {
        List<String> participants = Arrays.asList(userInput.split(","));

        if (!ValidationUtil.validName(participants)) {
            System.out.println(Message.OUTPUT_ERROR_INVALID_VALUE.getMsg());
            System.exit(0);
        }

        for (String participant : participants) {
            carCollection.getCars().add(new Car(participant));
        }
    }

    public static void validMoveCount(String tryCount) {
        if (!ValidationUtil.validMoveCount(tryCount)) {
            System.out.println(Message.OUTPUT_ERROR_INVALID_VALUE.getMsg());
            System.exit(0);
        }
    }

    private static int getRandomNumber() {
        return random.nextInt(9) + 1;
    }

    public static void doRace(CarCollection carCollection) {
        for (Car car : carCollection.getCars()) {
            Car.updateDistance(car, car.action(getRandomNumber()));
        }
        printStatus(carCollection);
    }

    private static void printStatus(CarCollection carCollection) {
        for (Car car : carCollection.getCars()) {
            System.out.println(car.getName() + " : " + car.getTrace());
        }
        System.out.println();
    }

    public static void finishRace(CarCollection carCollection) {
        CarCollection winner = new CarCollection();
        makeWinner(winner, carCollection);

        System.out.println(winner.toString() + Message.OUTPUT_RESULT_WINNER.getMsg());
    }
}
