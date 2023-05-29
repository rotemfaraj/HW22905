public class Polynomial extends Function{
    private final double[] coefficients;

    public Polynomial(double... coefficients) {
        super();
        this.coefficients = coefficients;
    }

    /*public double[] getCoefficients() {
        return coefficients;
    }
    */
    @Override
    public double valueAt(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public String toString() {
        String fx = "";
        int polynomDegree = coefficients.length - 1;
        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = coefficients[i];
            if (coefficient != 0) {
                if (coefficient > 0 && i < polynomDegree) {
                    fx += "+ ";
                } else if (coefficient < 0 && i < polynomDegree) {
                    fx += "- ";
                } else if (coefficient != 1 && coefficient != -1) {
                    if (coefficient == (int) coefficient) {
                        fx += (int) coefficient;
                    } else {
                        fx += coefficient;
                    }
                    if (i < polynomDegree) {
                        fx += "x";
                        if (i != polynomDegree - 1) {
                            fx += "^" + (polynomDegree - i);
                        }
                    }
                }
            }
        }
        return fx;
    }
    @Override
    public Function derivative() {
        int derivativeDegree = coefficients.length - 1;
        double[] derivativeCoefficients = new double[derivativeDegree];
        for (int i = 0; i < derivativeDegree; i++) {
            derivativeCoefficients[i] = coefficients[i + 1] * (i + 1);
        }
        return new Polynomial(derivativeCoefficients);
    }
}

