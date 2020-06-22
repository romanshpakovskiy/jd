package by.it.romanshpakovskiy.tasks.jd02_04;

import java.util.Arrays;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) {
        double sum = this.value + other.value;
        return new Scalar(sum);
    }

    @Override
    public Var add(Vector other) {
        return other.add(this);
    }

    @Override
    public Var add(Matrix other) {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar other) {
        return new Scalar(other.value - this.value);
    }

    @Override
    public Var sub(Vector other) {
        double[] arr = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - value;
        }
        return new Vector(arr);
    }

    @Override
    public Var sub(Matrix other) {
        double[][] otherValue = other.getValue();
        double[][] returnMatrix = new double[otherValue.length][otherValue[0].length];
        for (int y = 0; y < otherValue.length; y++) {
            for (int x = 0; x < otherValue.length; x++) {
                returnMatrix[x][y] = otherValue[x][y] - this.value;
            }
        }
        return new Matrix(returnMatrix);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar other) {
        double mul = this.value * other.value;
        return new Scalar(mul);
    }

    @Override
    public Var mul(Vector other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Matrix other) {
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div(this);
    }

    @Override
    public Var div(Scalar other) throws CalcException {
        if (this.value == 0) {
            throw new CalcException("Incertitude!");
        }
        Var sclr = new Scalar(1 / this.value);
        return other.mul(sclr);
    }

    @Override
    public Var div(Vector other) throws CalcException {
        if (this.value == 0) {
            throw new CalcException("Incertitude!");
        }
        Var sclr = new Scalar(1 / this.value);
        return other.mul(sclr);
    }

    @Override
    public Var div(Matrix other) throws CalcException {
        if (this.value == 0) {
            throw new CalcException("Incertitude!");
        }
        Var sclr = new Scalar(1 / this.value);
        return other.mul(sclr);
    }
}
