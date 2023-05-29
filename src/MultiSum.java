public class MultiSum extends Function {
    private Function[] functions;

    public MultiSum(Function... functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double point) {
        double result = 0;
        for (Function function : functions) {
            result += function.valueAt(point);
        }
        return result;
    }

    @Override
    public String toString() {
        String sumFunctions = "";
        for (int i = 0; i < functions.length; i++) {
            sumFunctions += functions[i].toString();
            if (i < functions.length - 1) {
                sumFunctions += " + ";
            }
        }
        return sumFunctions;
    }

    @Override
    public Function derivative() {
        Function[] derivativeFunctions = new Function[functions.length];
        for (int i = 0; i < functions.length; i++) {
            derivativeFunctions[i] = functions[i].derivative();
        }
        return new MultiSum(derivativeFunctions);
    }
}
