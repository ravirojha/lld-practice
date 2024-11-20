public enum Denomination {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500);

    private final double value;
    Denomination(double value) {
        this.value = value;
    }
    public double getValue() {
        return this.value;
    }
}
