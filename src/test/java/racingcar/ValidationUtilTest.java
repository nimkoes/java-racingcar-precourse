package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import racingcar.common.ValidationUtil;

public class ValidationUtilTest {
    
    
    @ParameterizedTest
    @CsvSource(value = {"'':false", ",:false", "붕붕이,빵빵이,빙봉:true", "빙봉,빙봉:false", "붕붕,빙봉,붕붕:false", "프리코스:true", "myFancyCar:false", ",super:false"}, delimiter = ':')
    @DisplayName("입력한 이름이 올바른가")
    void emptyName(String userInput, boolean expected) {
        List<String> participants = Arrays.asList(userInput.split(","));
        
        assertThat(ValidationUtil.validName(participants)).isEqualTo(expected);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"'':false", "문자:false", "alpha:false", "car1:false", "-1:false", "0:false", "1:true", "17:true"}, delimiter = ':')
    @DisplayName("이동 횟수 값으로 올바른 값을 입력 했는가")
    void validMoveCountInput(String userInput, boolean expected) {
        assertThat(ValidationUtil.validMoveCount(userInput)).isEqualTo(expected);
    }
}
