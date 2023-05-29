public class Negation extends Function {
    private Function function;

    public Negation(Function function) {
        this.function = function;
    }

    @Override
    public double valueAt(double point) {
        return -function.valueAt(point);
    }

    @Override
    public String toString() {
        return "-(" + function.toString() + ")";
    }

    @Override
    public String derivative() {
        return "-(" + function.derivative() + ")";
    }
}
