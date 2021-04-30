package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {
    
    
    @ParameterizedTest
    @CsvSource(value = {",:false", "붕붕이,빵빵이,빙봉:true", "빙봉,빙봉:false", "붕붕,빙봉,붕붕:false", "프리코스:true", "myFancyCar:false", ",super:false"}, delimiter = ':')
    @DisplayName("입력한 이름이 올바른가")
    void emptyName(String userInput, boolean expected) {
        List<String> participants = Arrays.asList(userInput.split(","));
        
        assertThat(ValidationUtil.validName(participants)).isEqualTo(expected);
    }
}
