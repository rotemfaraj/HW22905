public class Constant extends Function {
    final double constantValue;

    public Constant(double constantValue) {
        this.constantValue = constantValue;
    }
@Override
    public double valueAt(double point){
        return constantValue;
    }
    public String toString() {
        return "("+constantValue+")";
    }
    public Function derivative() {
        return new Constant(0);
    }
}
