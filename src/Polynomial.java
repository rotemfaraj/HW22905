public class Polynomial extends Function {
    private final double[] coefficients;

    public Polynomial(double... coefficients) {
        super();
        this.coefficients = coefficients;
    }

    @Override
    public double valueAt(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public String toString() {
        String fx = "";
        int polynomialDegree = coefficients.length - 1;
        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = coefficients[i];
            if (coefficient != 0) {
                if (coefficient > 0 && i < polynomialDegree) {
                    fx += "+ ";
                } else if (coefficient < 0 && i < polynomialDegree) {
                    fx += "- ";
                } else if (coefficient != 1 && coefficient != -1) {
                    if (coefficient == (int) coefficient) {
                        fx += (int) coefficient;
                    } else {
                        fx += coefficient;
                    }
                    if (i < polynomialDegree) {
                        fx += "x";
                        if (i != polynomialDegree - 1) {
                            fx += "^" + (polynomialDegree - i);
                        }
                    }
                }
            }
        }
        return fx;
    }

    @Override
    public Function derivative() {
        int polynomialDegree = coefficients.length - 1;
        if (polynomialDegree == 0) {
            // If the polynomial is a constant, return the derivative of a constant (0)
            return new Constant(0);
        } else {
            double[] derivativeCoefficients = new double[polynomialDegree];
            for (int i = 0; i < polynomialDegree; i++) {
                derivativeCoefficients[i] = coefficients[i + 1] * (i + 1);
            }
            return new Polynomial(derivativeCoefficients);
        }
    }
}
