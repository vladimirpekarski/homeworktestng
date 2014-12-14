package classes;

public class Calculator {
    public double summ(double value1, double value2) {
        return value1 + value2;
    }

    public double divide(double value1, double value2) {
        if (value2 == 0.0) {
            throw new ArithmeticException();
        }
        return value1 / value2;
    }

    public double multiply(double value1, double value2) {
        return value1 * value2;
    }

    public  double sqrt(double value) {
        return Math.sqrt(value);
    }

}
