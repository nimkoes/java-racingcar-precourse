package racingcar;

import java.util.Scanner;

public class MainApp {

    static CarCollection carCollection = new CarCollection();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userInput = RacingUtil.inputCarName(sc);
        RacingUtil.makeParticipants(carCollection, userInput);

        String tryCount = RacingUtil.inputTryCount(sc);
        RacingUtil.validMoveCount(tryCount);

        doProc(Integer.parseInt(tryCount));
    }

    private static void doProc(Integer tryCount) {
        System.out.println(Message.OUTPUT_RESULT_TITLE.getMsg());

        for (int i = 0; i < tryCount; ++i) {
            RacingUtil.doRace(carCollection);
        }

        RacingUtil.finishRace(carCollection);
    }

}
