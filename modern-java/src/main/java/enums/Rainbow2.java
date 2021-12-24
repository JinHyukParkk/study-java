package enums;

public enum Rainbow2 {

    RED(3),
    ORANGE(10),
    YELLOW(21),
    GREEN(5),
    BLUE(1),
    INDIGO(-1),
    VIOLET(123);

    private final int value;

    Rainbow2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
