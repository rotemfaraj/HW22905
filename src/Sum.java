public class Sum extends Function {
    private Function function1;
    private Function function2;

    public Sum(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double point) {
        return function1.valueAt(point) + function2.valueAt(point);
    }

    @Override
    public String toString() {
        return function1.toString() + " + " + function2.toString();
    }

    @Override
    public Function derivative() {
        Function derivativeFunction1 = function1.derivative();
        Function derivativeFunction2 = function2.derivative();
        return new Sum(derivativeFunction1, derivativeFunction2);
    }
}
