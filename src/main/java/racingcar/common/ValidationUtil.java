package racingcar.common;

import java.util.HashSet;
import java.util.List;

public class ValidationUtil {

    static final int MAX_NAME_LENGTH = 5;
    static final String REG_EXP_ONLY_NUMBER = "^[0-9]+$";

    public static boolean validName(List<String> participants) {
        return !isEmptyOrBlank(participants)
            && !isExistsDuplicateName(participants)
            && !isNameLengthOver(participants);
    }

    private static boolean isEmptyOrBlank(List<String> participants) {
        if (participants.isEmpty() || participants.contains("")) {
            System.out.println(Message.OUTPUT_ERROR_EMPTY_STRING.getMsg());
            return true;
        }
        return false;
    }

    private static boolean isExistsDuplicateName(List<String> participants) {
        if (participants.size() != new HashSet<>(participants).size()) {
            System.out.println(Message.OUTPUT_ERROR_DUPLICATE_NAME.getMsg());
            return true;
        }
        return false;
    }

    private static boolean isNameLengthOver(List<String> participants) {
        int maxLength = -1;
        for (String participant : participants) {
            maxLength = Math.max(maxLength, participant.length());
        }

        if (maxLength > MAX_NAME_LENGTH) {
            System.out.println(Message.OUTPUT_ERROR_LENGTH_OVER.getMsg());
            return true;
        }
        return false;
    }

    public static boolean validMoveCount(String userInput) {
        return isOnlyNumber(userInput) && isPositiveNumber(userInput);
    }

    private static boolean isPositiveNumber(String userInput) {
        if (Integer.parseInt(userInput) < 1) {
            System.out.println(Message.OUTPUT_ERROR_MIUNS_VALUE.getMsg());
            return false;
        }
        return true;
    }

    private static boolean isOnlyNumber(String userInput) {
        if (!userInput.matches(REG_EXP_ONLY_NUMBER)) {
            System.out.println(Message.OUTPUT_ERROR_NOT_A_NUMBER.getMsg());
            return false;
        }
        return true;
    }
}
