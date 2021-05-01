package racingcar.core;

public enum CarAction {
    GO, STOP;

    public boolean isGo() {
        return this == GO;
    }
}
