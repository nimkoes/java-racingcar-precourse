package racingcar;

public enum Message {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
    OUTPUT_RESULT_TITLE("실행결과"),
    OUTPUT_RESULT_WINNER("가 최종 우승했습니다."),
    OUTPUT_ERROR_INVALID_VALUE("올바른 값을 입력해주세요.");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
