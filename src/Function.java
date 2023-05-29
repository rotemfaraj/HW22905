import java.util.Arrays;

public class Function {
    protected String function;

    /*public Function(String function) {
        this.function = function;
    }
*/
    public double valueAt(double point) {
        double result = point;
        return result;
    }

    public String toString() {
        // Return a string that represent the function
        return "f(x) = /* Your function expression */";
    }

    public Function derivative() {
        return this;
    }

    public double bisectionMethod(double a, double b, double epsilon) {
        double result = 0.0;
        return result;
    }

    public double bisectionMethod(double a, double b) {
        double result = 0.0;
        return result;
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        double result = 0.0;
        return result;
    }

    public double newtonRaphsonMethod(double a) {
        double result = 0.0;
        return result;
    }

    public String taylorPolynomial(int n) {
        String polynomial = "f(x) = ";

        for (int i = 0; i <= n; i++) {
            Function derivative = this;
            for (int j = 0; j < i; j++) {
                derivative = derivative.derivative();
            }
            double coefficient = derivative.valueAt(0) / factorial(i);

            if (coefficient != 0) {
                if (i > 0) {
                    polynomial += " + ";
                }
                polynomial += coefficient;
                if (i > 0) {
                    polynomial += " * x^" + i;
                }
            }
        }

        return polynomial;
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
