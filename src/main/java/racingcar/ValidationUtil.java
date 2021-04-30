package racingcar;

import java.util.HashSet;
import java.util.List;

public class ValidationUtil {
    
    static final int MAX_NAME_LENGTH = 5;
    
    public static boolean validName(List<String> participants) {
        return !participants.isEmpty()
                && !participants.contains("")
                && !isExistsDuplicateName(participants)
                && !isNameLengthOver(participants);
    }
    
    private static boolean isExistsDuplicateName(List<String> participants) {
        return participants.size() != new HashSet<>(participants).size();
    }
    
    private static boolean isNameLengthOver(List<String> participants) {
        int maxLength = -1;
        for (String participant : participants) {
            maxLength = Math.max(maxLength, participant.length());
        }
        return maxLength > MAX_NAME_LENGTH;
    }
    
}