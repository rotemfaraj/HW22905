public class MultiProduct extends Function {
    private Function[] functions;

    public MultiProduct(Function... functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double point) {
        double result = 1.0;
        for (Function function : functions) {
            result *= function.valueAt(point);
        }
        return result;
    }

    @Override
    public String toString() {
        String MultiProductString = "";
        for (int i = 0; i < functions.length; i++) {
            MultiProductString += functions[i].toString();
            if (i < functions.length - 1) {
                MultiProductString += " * ";
            }
        }
        return MultiProductString;
    }

    @Override
    public String derivative() {
        String derivativeProduct = "";
        for (int i = 0; i < functions.length; i++) {
            String term = "";
            for (int j = 0; j < i; j++) {
                term += functions[j].toString();
                if (j < i - 1) {
                    term += " * ";
                }
            }
            if (i != 0) {
                derivativeProduct += " + ";
            }
            derivativeProduct += "(" + functions[i].derivative() + " * " + term + " * " + functions[i + 1].toString() + ")";
        }
        return derivativeProduct;
    }
}

