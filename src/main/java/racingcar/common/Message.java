package racingcar.common;

public enum Message {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
    OUTPUT_RESULT_TITLE("실행결과"),
    OUTPUT_RESULT_WINNER("가 최종 우승했습니다."),
    OUTPUT_ERROR_EMPTY_STRING("공백 입력은 허용하지 않습니다."),
    OUTPUT_ERROR_DUPLICATE_NAME("같은 이름은 입력할 수 없습니다."),
    OUTPUT_ERROR_LENGTH_OVER("이름의 길기는 5를 초과할 수 없습니다."),
    OUTPUT_ERROR_MINUS_VALUE("0보다 큰 값을 입력해 주시기 바랍니다."),
    OUTPUT_ERROR_NOT_A_NUMBER("0보다 큰 정수값을 입력해 주시기 바랍니다.");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
